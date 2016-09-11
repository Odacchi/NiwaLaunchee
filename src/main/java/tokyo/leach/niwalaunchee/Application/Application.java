package tokyo.leach.niwalaunchee.Application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.Listener.Key.SpecialKeyListener;
import tokyo.leach.niwalaunchee.Listener.Key.SpecialKeyPressedObserver;
import tokyo.leach.niwalaunchee.System.NiwaSystem;
import tokyo.leach.niwalaunchee.Window.NiwaTaskTray;
import tokyo.leach.niwalaunchee.Window.SearchWindow;
import tokyo.leach.niwalaunchee.Window.WindowManager;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.Keys;
import tokyo.leach.niwalaunchee.model.key.SpecialKeys;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tomi on 2016/09/07.
 */
//@Singleton
public class Application {
	private Injector injector;
	private static Application instance;
	private static NiwaSystem system;

	// FIXME tomi: this implementation is not so perfect for singleton class.
	private Application() {
		// DO NOTHING
		// You should implement init() function
	}

	public static Application get() {
		if(instance == null) {
			instance = new Application();
			system = new NiwaSystem();
		}
		return instance;
	}

	/**
	 * you must call this function before call another function.
	 */
	public void init() throws IOException, AWTException {
		injector = Guice.createInjector(new AppInjector());
		system = new NiwaSystem();
		system.init();
	}

	/**
	 * start application
	 */
	public void start() throws NativeHookException {
		system.keyListenStart();
	}

	/**
	 * stop application
	 */
	public void stop() throws NativeHookException {
		// TODO tomi: write finalize procedures here.
		system.keyListenStop();
		System.exit(0);
	}
}
