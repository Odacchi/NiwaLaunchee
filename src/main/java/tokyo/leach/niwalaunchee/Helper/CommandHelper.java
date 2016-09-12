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
}
