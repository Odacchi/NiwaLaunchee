package tokyo.leach.niwalaunchee.Component;

import tokyo.leach.niwalaunchee.Helper.CommandHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tomi on 2016/09/12.
 */
public class CommandJTextField extends JTextField {
	private String commandSplitter;

	/**
	 * DO NOT USE
	 */
	private CommandJTextField() {
		// DO NOTHING
	}

	public CommandJTextField(String commandSplitter) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = CommandHelper.getCommandStr(getText(), commandSplitter);
			}
		});
	}
}
