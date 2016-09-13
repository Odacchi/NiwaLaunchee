package tokyo.leach.niwalaunchee.System;

import com.google.inject.Injector;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import tokyo.leach.niwalaunchee.Listener.Key.SpecialKeyListener;
import tokyo.leach.niwalaunchee.Listener.Key.SpecialKeyPressedObserver;
import tokyo.leach.niwalaunchee.Window.NiwaTaskTray;
import tokyo.leach.niwalaunchee.Window.SearchWindow;
import tokyo.leach.niwalaunchee.Window.WindowManager;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.SpecialKeys;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tomi on 2016/09/06.
 */
public class NiwaSystem {
	private SpecialKeyListener spKeylistener;
	private SpecialKeyPressedObserver spKeyObserver;
	private SpecialKeys specialKeys;
	private WindowManager windowManager;
	private String commandSplitter = " ";

	public NiwaSystem() {

	}

	public void init() throws IOException, AWTException {
		windowManager = new WindowManager();
		windowManager.setSearchWindow(new SearchWindow(commandSplitter));
		windowManager.setTaskTray(new NiwaTaskTray());
		setDefaultSpecialKeys();
		spKeylistener = new SpecialKeyListener(specialKeys);
		spKeyObserver = new SpecialKeyPressedObserver(windowManager);
		spKeylistener.addObserver(spKeyObserver);
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
	 * Left Control + Space is a default special key
	*/
	public void setDefaultSpecialKeys() {
		SpecialKeys keys = new SpecialKeys();
		keys.addKey(new Key((char) NativeKeyEvent.VC_CONTROL_L));
		keys.addKey(new Key((char) NativeKeyEvent.VC_SPACE));
		this.setSpecialKeys(keys);
	}

	public void keyListenStart() throws NativeHookException {
		GlobalScreen.addNativeKeyListener(spKeylistener);
		GlobalScreen.registerNativeHook();

		// Get the logger for "org.jnativehook" and set the level to warning.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
		// Don't forget to disable the parent handlers.
		logger.setUseParentHandlers(false);
	}

	public void keyListenStop() throws NativeHookException {
		GlobalScreen.removeNativeKeyListener(spKeylistener);
		GlobalScreen.unregisterNativeHook();
	}

	public String getCommandSplitter() {
		return commandSplitter;
	}

	public void setCommandSplitter(String commandSplitter) {
		this.commandSplitter = commandSplitter;
	}
}
