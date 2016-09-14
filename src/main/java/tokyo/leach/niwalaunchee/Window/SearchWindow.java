package tokyo.leach.niwalaunchee.Window;

import tokyo.leach.niwalaunchee.Command.CommandExecutor;
import tokyo.leach.niwalaunchee.Command.CommandFinder;
import tokyo.leach.niwalaunchee.Component.CommandJTextField;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tomi on 2016/09/07.
 */
public class SearchWindow implements IToggleable {
	private JFrame frame;
	private CommandJTextField textField;

	private SearchWindow() {}

	public SearchWindow(final String commandSplitter) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame = new JFrame("SearchWindow");
				frame.setAlwaysOnTop(true);
				frame.setLayout(new FlowLayout());
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				textField = new CommandJTextField(50, commandSplitter) {
					@Override
					public void commandReceived(String cmd, String cmdBody) {
						System.out.println(String.format("%s, %s", cmd, cmdBody));
						CommandFinder finder = new CommandFinder();
						CommandExecutor executor = finder.findCommand(cmd);
						if(executor != null) {
							// before execute command, hide search window
							frame.setVisible(false);
							executor.execute(cmdBody);
						}
					}
				};
				frame.getContentPane().add(BorderLayout.EAST, textField);
				frame.pack();
				frame.setLocationRelativeTo(null); // center of screen
			}
		});
	}

	@Override
	public void toggle() {
		frame.setVisible(!frame.isVisible());
	}
}
