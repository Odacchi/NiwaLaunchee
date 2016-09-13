package tokyo.leach.niwalaunchee.Util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by tomi on 2016/09/14.
 */
public class BrowserUtil {
	/**
	 * open uri by default browser
	 * Refer: http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
	 * @param uri
	 */
	public static void openWebpage(URI uri) throws IOException {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			desktop.browse(uri);
		}
	}

	/**
	 * open url by default browser
	 * Refer: http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
	 * @param url
	 * @throws URISyntaxException
	 */
	public static void openWebpage(URL url) throws URISyntaxException, IOException {
		BrowserUtil.openWebpage(url.toURI());
	}
}
