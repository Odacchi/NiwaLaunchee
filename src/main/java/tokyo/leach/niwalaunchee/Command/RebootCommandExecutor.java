package tokyo.leach.niwalaunchee.Command;

import tokyo.leach.niwalaunchee.Helper.CommandHelper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tomi on 2016/09/14.
 */
public class RebootCommandExecutor extends CommandExecutor {
	public RebootCommandExecutor() {
		this.commands = new ArrayList<String>();
		this.commands.add("reboot");
	}
	@Override
	public void execute(String cmdBody) {
		String sdCmd = CommandHelper.getShutdownCommandStr(System.getProperty("os.name"));
		try {
			Runtime.getRuntime().exec(sdCmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
