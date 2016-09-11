package tokyo.leach.niwalaunchee.Window;

import java.awt.*;
import java.io.IOException;

/**
 * Created by tomi on 2016/09/07.
 */
public abstract class TaskTray {
	protected PopupMenu popupMenu;
	protected TrayIcon trayIcon;

	public TaskTray() throws IOException {
		trayIcon = generateTrayIcon();
		popupMenu = generatePopupMenu();
		trayIcon.setPopupMenu(popupMenu);
	}

	abstract public TrayIcon generateTrayIcon() throws IOException;
	abstract public PopupMenu generatePopupMenu();

	public PopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void setPopupMenu(PopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

	public TrayIcon getIcon() {
		return trayIcon;
	}

	public void setIcon(TrayIcon icon) {
		this.trayIcon = icon;
	}
}
