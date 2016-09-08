package tokyo.leach.niwalaunchee.Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tomi on 2016/09/07.
 */
public class SearchWindow implements IToggleable {
	private JFrame frame;
	private JTextField textField;

	public SearchWindow() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame = new JFrame("SearchWindow");
				frame.setLayout(new FlowLayout());
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				textField = new JTextField(50);
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
