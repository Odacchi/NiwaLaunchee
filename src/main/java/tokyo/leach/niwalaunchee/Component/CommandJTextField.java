package tokyo.leach.niwalaunchee.Component;

import tokyo.leach.niwalaunchee.Helper.CommandHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tomi on 2016/09/12.
 */
public abstract class CommandJTextField extends JTextField implements ICommandListener {
	private String commandSplitter;

	/**
	 * DO NOT USE
	 */
	private CommandJTextField() {
		// DO NOTHING
	}

	public CommandJTextField(int columns, final String commandSplitter) {
		super(columns);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = CommandHelper.getCommandStr(getText(), commandSplitter);
				String cmdBody = CommandHelper.getCommandBodyStr(getText(), commandSplitter);
				commandReceived(cmd, cmdBody);
			}
		});
	}

	/**
	 * this function will be called when text has changed
	 * @param cmd
	 * @param cmbBody
	 */
	@Override
	public abstract void commandReceived(String cmd, String cmbBody);
}
