package tokyo.leach.niwalaunchee.Util;

/**
 * Created by tomi on 2016/09/13.
 */
public class StringUtil {
	/**
	 * Split string left and right by char(String ch).
	 * <p>
	 * ex) string: "g today's weather" -> ch: " ", left: g, right: today's weather
	 * @param str the target string. not {@code null}
	 * @param ch the delimiting character. not {@code null}
	 * @return the array of 2 strings. Returns an string array which contains one empty character
	 */
	public static String[] splitLRByChar(String str, String ch) {
		return str.split(ch, 2);
	}
}
