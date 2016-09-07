package tokyo.leach.niwalaunchee.Listener.Key;

import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.Helper.KeyHelper;
import tokyo.leach.niwalaunchee.model.key.SpecialKeys;

/**
 * Created by tomi on 2016/09/05.
 */
public class SpecialKeyListener extends MultiKeyListener {
	protected SpecialKeys keys = null;
	static Object lock = new Object();
	SpecialKeyPressedSubject subject;

	public SpecialKeyListener(SpecialKeys keys) {
		this.keys = keys;
		this.subject = new SpecialKeyPressedSubject();
	}

	public SpecialKeys getKeys() {
		return keys;
	}

	public void setKeys(SpecialKeys keys) {
		/**
		 * to prevent chang keys varialble during nativeKeyPressed function is processed.
		 */
		synchronized (lock) {
			this.keys = keys;
		}
	}

	public void addObserver(SpecialKeyPressedObserver o) {
		this.subject.addObserver(o);
	}

	public void removeObserver(SpecialKeyPressedObserver o) {
		this.subject.removeObserver(o);
	}

	@Override
	public synchronized void nativeKeyPressed(NativeKeyEvent e) {
		super.nativeKeyPressed(e);
		synchronized (lock) {
			if(KeyHelper.isSameKey(keys, pressed)) {
				this.subject.notifyObservers();
			}
		}
	}
}
