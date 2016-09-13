package tokyo.leach.niwalaunchee.Command;

import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.httpclient.util.URIUtil;
import tokyo.leach.niwalaunchee.Util.BrowserUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomi on 2016/09/14.
 */
public class GoogleSearchCommandExecutor extends CommandExecutor {
	private String urlFormat = "https://www.google.com/search?q=%1$s";

	public GoogleSearchCommandExecutor() {
		this.commands = new ArrayList<String>();
		this.commands.add("g");
		this.commands.add("google");
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
