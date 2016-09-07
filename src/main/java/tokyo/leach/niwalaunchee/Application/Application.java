package tokyo.leach.niwalaunchee.Application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.Listener.Key.SpecialKeyListener;
import tokyo.leach.niwalaunchee.Listener.Key.SpecialKeyPressedObserver;
import tokyo.leach.niwalaunchee.Window.NiwaTaskTray;
import tokyo.leach.niwalaunchee.Window.SearchWindow;
import tokyo.leach.niwalaunchee.Window.WindowManager;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.Keys;
import tokyo.leach.niwalaunchee.model.key.SpecialKeys;

import java.awt.*;
import java.io.IOException;

/**
 * Created by tomi on 2016/09/07.
 */
//@Singleton
public class Application {
	private SpecialKeyListener spKeylistener;
	private SpecialKeyPressedObserver spKeyObserver;
	private SpecialKeys specialKeys;
	private Injector injector;
	private static Application instance;
	private WindowManager windowManager;

	// FIXME tomi: this implementation is not so perfect for singleton class.
	private Application() {
		// DO NOTHING
		// You should implement init() function
	}

	public static Application get() {
		if(instance == null) {
			instance = new Application();
		}
		return instance;
	}

	public SpecialKeys getSpecialKeys() {
		return specialKeys;
	}

	public void setSpecialKeys(SpecialKeys specialKeys) {
		this.specialKeys = specialKeys;
	}

	public void resetSpecialKeys() {
		specialKeys = new SpecialKeys();
	}

	public void setSpecialKeysFromKey(Key... keys) {
		specialKeys = new SpecialKeys();
		for(Key key : keys) {
			specialKeys.addKey(key);
		}
	}

	/**
	 * you must call this function before call another function.
	 */
	public void init() throws IOException, AWTException {
		injector = Guice.createInjector(new AppInjector());
		windowManager = new WindowManager();
		windowManager.setSearchWindow(new SearchWindow());
		windowManager.setTaskTray(new NiwaTaskTray());
		setDefaultSpecialKeys();
		spKeylistener = new SpecialKeyListener(specialKeys);
		spKeyObserver = new SpecialKeyPressedObserver(windowManager);
		spKeylistener.addObserver(spKeyObserver);
	}

	/**
	 * Left Control + Space is a default special key
	 */
	public void setDefaultSpecialKeys() {
		SpecialKeys keys = new SpecialKeys();
		keys.addKey(new Key((char) NativeKeyEvent.VC_CONTROL_L));
		keys.addKey(new Key((char) NativeKeyEvent.VC_SPACE));
		this.setSpecialKeys(keys);
	}

	/**
	 * start application
	 */
	public void start() throws NativeHookException {
		GlobalScreen.registerNativeHook();
	}

	/**
	 * stop application
	 */
	public void stop() throws NativeHookException {
		// TODO tomi: write finalize procedures here.
		GlobalScreen.unregisterNativeHook();
		System.exit(0);
	}
}
