package tokyo.leach.niwalaunchee.Command;

import tokyo.leach.niwalaunchee.Util.BrowserUtil;

/**
 * Created by tomi on 2016/09/14.
 * Find a command from command string
 */
public class CommandFinder {
	public CommandExecutor findCommand(String cmd) {
		return new GoogleSearchCommandExecutor();
	}
}
