package tokyo.leach.niwalaunchee.Window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tomi on 2016/09/07.
 */
public class SearchWindow {
	private JFrame frame;
	private JTextField textField;

	public SearchWindow() {
		frame = new JFrame("SearchWindow");
		frame.setLayout(new FlowLayout());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		textField = new JTextField(50);
		frame.getContentPane().add(BorderLayout.EAST, textField);
		frame.pack();
		frame.setLocationRelativeTo(null); // center of screen
		frame.setVisible(true);
	}
}
