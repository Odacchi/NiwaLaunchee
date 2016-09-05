package tokyo.leach.niwalaunchee.Listener.Key;

import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.Helper.KeyHelper;

/**
 * Created by tomi on 2016/09/05.
 */
public class SpecialKeyListener extends MultiKeyListener {
	protected tokyo.leach.niwalaunchee.model.key.SpecialKeys keys = null;
	static Object lock = new Object();
	SpecialKeyPressedSubject subject;

	public SpecialKeyListener(tokyo.leach.niwalaunchee.model.key.SpecialKeys keys) {
		this.keys = keys;
		this.subject = new SpecialKeyPressedSubject();
	}

	public tokyo.leach.niwalaunchee.model.key.SpecialKeys getKeys() {
		return keys;
	}

	public void setKeys(tokyo.leach.niwalaunchee.model.key.SpecialKeys keys) {
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
