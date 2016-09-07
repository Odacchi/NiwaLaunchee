package tokyo.leach.niwalaunchee.Listener.Key;

import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.Keys;
import tokyo.leach.niwalaunchee.model.key.SpecialKeys;

import java.awt.event.InputEvent;
import java.util.HashSet;
import java.util.Set;

import static java.awt.event.KeyEvent.VK_SHIFT;

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
		pressed.addKey(new Key((char) nativeKeyEvent.getKeyCode()));
		System.out.println(nativeKeyEvent.paramString());
		System.out.println(nativeKeyEvent.getKeyChar());
		System.out.println("modifier: " + nativeKeyEvent.getModifiers());
		if((nativeKeyEvent.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
			System.out.println("ctrl!");
		}
	}

	@Override
	public synchronized void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
		pressed.removeKey(new Key((char) nativeKeyEvent.getKeyCode()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
		// DO NOTHING
		System.out.println("typed: "+ nativeKeyEvent.paramString());
		System.out.println("modifier: " + nativeKeyEvent.getModifiers());
	}

	public Keys getPressed() {
		return pressed;
	}

	public void setPressed(Keys pressed) {
		this.pressed = pressed;
	}
}
