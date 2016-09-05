package tokyo.leach.niwalaunchee.model.key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomi on 2016/09/05.
 */
public class Keys {
	List<Key> keys;

	public Keys() {
		keys = new ArrayList<Key>();
	}

	public void addKey(Key key) {
		keys.add(key);
	}

	public void removeKey(Key key) {
		keys.remove(key);
	}
}
