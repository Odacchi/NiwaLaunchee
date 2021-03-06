package tokyo.leach.niwalaunchee.Window;

import org.jnativehook.NativeHookException;
import tokyo.leach.niwalaunchee.Application.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by tomi on 2016/09/07.
 */
public class NiwaTaskTray extends TaskTray {
	public NiwaTaskTray() throws IOException {
		super();
	}

	@Override
	public TrayIcon generateTrayIcon() throws IOException {
		System.out.println("loaded from icon: " + getClass().getClassLoader().getResources("").nextElement().toString());
		Image image = ImageIO.read(
				getClass().getClassLoader().getResourceAsStream("resources/Icon/trayIcon.jpg"));
		TrayIcon icon = new TrayIcon(image);
		icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		return icon;
	}

	@Override
	public PopupMenu generatePopupMenu() {
		PopupMenu menu = new PopupMenu();
		// exit
		MenuItem exitItem = new MenuItem("Quit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Application.get().stop();
				} catch (NativeHookException e1) {
					e1.printStackTrace();
				}
			}
		});
		menu.add(exitItem);

		return menu;
	}
}
