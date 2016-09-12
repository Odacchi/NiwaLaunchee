package tokyo.leach.niwalaunchee.Util;

/**
 * Created by tomi on 2016/09/13.
 */
public class StringUtil {
	/**
	 * Split string left and right by char(String ch)
	 * ex) string: "g today's weather" -> ch: " ", left: g, right: today's weather
	 * @param str
	 * @param ch
	 * @return
	 */
	public static String[] splitLRByChar(String str, String ch) {
		return str.split(ch, 2);
	}
}
