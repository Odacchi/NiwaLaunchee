package tokyo.leach.niwalaunchee.UnitTest.Listener.key;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tokyo.leach.niwalaunchee.Listener.Key.MultiKeyListener;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by tomi on 2016/09/06.
 */
public class MultiKeyListenerTest {
	@BeforeTest
	public void beforeDo() throws NativeHookException {
		GlobalScreen.registerNativeHook();
	}

	@AfterTest
	public void afterDo() throws NativeHookException {
		GlobalScreen.unregisterNativeHook();
	}

	@Test
	public void pressMultiKeyTest() throws AWTException, InterruptedException {
		MultiKeyListener mkl = new MultiKeyListener();
		GlobalScreen.addNativeKeyListener(mkl);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SPACE);

		Thread.sleep(300);

		Keys pressed = mkl.getPressed();
		assertEquals(pressed.getKeys().size(), 2);
		assertTrue(pressed.getKeys().contains(new Key((char)NativeKeyEvent.VC_CONTROL_L)));
		assertTrue(pressed.getKeys().contains(new Key((char) NativeKeyEvent.VC_SPACE)));

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SPACE);

		assertEquals(pressed.getKeys().size(), 0);
	}
}
