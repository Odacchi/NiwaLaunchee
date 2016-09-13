package tokyo.leach.niwalaunchee.Command;

import java.util.List;

/**
 * Created by tomi on 2016/09/14.
 */
public abstract class CommandExecutor {
	protected List<String> commands;
	public List<String> getCommand() {
		return commands;
	}
	public abstract void execute(String cmdBody);

}
