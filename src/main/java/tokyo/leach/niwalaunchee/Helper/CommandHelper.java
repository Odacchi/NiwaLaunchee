package tokyo.leach.niwalaunchee.Helper;

/**
 * Created by tomi on 2016/09/13.
 */
public class CommandHelper {
	/**
	 * return command string
	 * @param str
	 * @param splitter
	 * @return
	 */
	public static String getCommandStr(String str, String splitter) {
		return str.split(splitter, 2)[0];
	}

	/**
	 * return command body string
	 * @param str
	 * @param splitter
	 * @return
	 */
	public static String getCommandBodyStr(String str, String splitter) {
		String[] lr = str.split(splitter, 2);
		if(lr.length <= 1) {
			return "";
		}
		return lr[1];
	}

	/**
	 * return a shutdown command string
	 * Refer: http://stackoverflow.com/questions/25637/shutting-down-a-computer
	 * @param operatingSystem (please give the osname by System.getProperty("os.name")
	 * @return
	 */
	public static String getShutdownCommandStr(String operatingSystem) {
		String shutdownCommand;

		if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
			shutdownCommand = "shutdown -h now";
		}
		else if ("Windows".equals(operatingSystem)) {
			shutdownCommand = "shutdown.exe -s -t 0";
		}
		else {
			throw new RuntimeException("Unsupported operating system.");
		}
		return shutdownCommand;
	}

	public static String getRebootCommandStr(String operatingSystem) {
		return "shutdown -r";
	}
}
