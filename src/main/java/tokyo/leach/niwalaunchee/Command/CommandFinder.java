package tokyo.leach.niwalaunchee.Command;

import tokyo.leach.niwalaunchee.Util.BrowserUtil;

/**
 * Created by tomi on 2016/09/14.
 * Find a command from command string
 */
public class CommandFinder {
	public CommandExecutor findCommand(String cmd) {
		// FIXME tomi: separate command string array from CommandExecutor.
		CommandExecutor executor = new GoogleSearchCommandExecutor();
		if(executor.getCommand().contains(cmd)) {
			return executor;
		}
		executor = new TwitterSearchCommandExecutor();
		if(executor.getCommand().contains(cmd)) {
			return executor;
		}
		return null;
	}
}
