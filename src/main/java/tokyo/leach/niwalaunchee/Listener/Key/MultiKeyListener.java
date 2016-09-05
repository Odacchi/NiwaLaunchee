package tokyo.leach.niwalaunchee.Listener.Key;

import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.model.key.Key;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tomi on 2016/09/05.
 */
public class MultiKeyListener extends GlobalKeyListener {
	/**
	 * pushed key
	 */
	protected tokyo.leach.niwalaunchee.model.key.Keys pressed = new tokyo.leach.niwalaunchee.model.key.Keys();

	@Override
	public synchronized void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
		pressed.addKey(new Key(nativeKeyEvent.getKeyChar()));
	}

	@Override
	public synchronized void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
		pressed.removeKey(new Key(nativeKeyEvent.getKeyChar()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
		// DO NOTHING
	}
}
