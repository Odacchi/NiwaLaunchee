package tokyo.leach.niwalaunchee.Command;

import org.apache.commons.httpclient.util.URIUtil;
import tokyo.leach.niwalaunchee.Util.BrowserUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by tomi on 2016/09/14.
 */
public class TwitterSearchCommandExecutor extends CommandExecutor {
	private String urlFormat = "https://twitter.com/search?q=%1$s";

	public TwitterSearchCommandExecutor() {
		this.commands = new ArrayList<String>();
		this.commands.add("t");
		this.commands.add("tw");
		this.commands.add("tweet");
		this.commands.add("twitter");
	}

	@Override
	public void execute(String cmdBody) {
		try {
			BrowserUtil.openWebpage(new URI(URIUtil.encodeQuery(String.format(urlFormat, cmdBody))));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
