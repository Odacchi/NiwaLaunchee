package tokyo.leach.niwalaunchee.Main;

import tokyo.leach.niwalaunchee.Application.Application;

import java.awt.*;
import java.io.IOException;

/**
 * Created by tomi on 2016/09/05.
 */
public class Main {
	/**
	 * Start point
	 * @param args
	 */
	public static void main(String[] args) {
		Application app = null;
		try {
			app = Application.get();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		app.init();
	}
}
