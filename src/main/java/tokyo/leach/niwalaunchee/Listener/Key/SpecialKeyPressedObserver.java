package tokyo.leach.niwalaunchee.Listener.Key;

import tokyo.leach.niwalaunchee.Window.WindowManager;

/**
 * Created by tomi on 2016/09/06.
 */
public class SpecialKeyPressedObserver implements ISpecialKeyPressedListener {
	private WindowManager windowManager;
	public SpecialKeyPressedObserver(WindowManager winManager) {
		this.windowManager = windowManager;
	}
	@Override
	public void specialKeyPressed() {
		windowManager.getSearchWindow().toggle();
	}
}
