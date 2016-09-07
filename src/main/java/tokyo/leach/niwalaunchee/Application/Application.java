package tokyo.leach.niwalaunchee.Application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.SpecialKeys;

/**
 * Created by tomi on 2016/09/07.
 */
//@Singleton
public class Application {
	private SpecialKeys specialKeys;
	private Injector injector;
	private Application instance;

	// FIXME tomi: this implementation is not so perfect for singleton class.
	private Application() {
		// do nothing (singleton)
	}

	public Application get() {
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
	public void init() {
		injector = Guice.createInjector(new AppInjector());
	}

	/**
	 * start application
	 */
	public void start() {

	}

	/**
	 * stop application
	 */
	public void stop() {

	}
}
