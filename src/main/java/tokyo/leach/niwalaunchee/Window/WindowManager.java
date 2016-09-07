package tokyo.leach.niwalaunchee.Window;

/**
 * Created by tomi on 2016/09/07.
 */

import java.awt.*;

/**
 * manage window (GUI)
 */
public class WindowManager {
	// main window
	SearchWindow searchWindow;

	// task tray
	NiwaTaskTray taskTray;

	public SearchWindow getSearchWindow() {
		return searchWindow;
	}

	public void setSearchWindow(SearchWindow searchWindow) {
		this.searchWindow = searchWindow;
	}

	public NiwaTaskTray getTaskTray() {
		return taskTray;
	}

	public void setTaskTray(NiwaTaskTray taskTray) throws AWTException {
		this.taskTray = taskTray;
		SystemTray.getSystemTray().add(taskTray.getIcon());
	}
}
