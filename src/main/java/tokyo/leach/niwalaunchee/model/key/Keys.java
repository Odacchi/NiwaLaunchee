package tokyo.leach.niwalaunchee.model.key;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tomi on 2016/09/05.
 */
public class Keys {
	Set<Key> keys;

	public Keys() {
		keys = new HashSet<Key>();
	}

	public void addKey(tokyo.leach.niwalaunchee.model.key.Key key) {
		keys.add(key);
	}

	public void removeKey(tokyo.leach.niwalaunchee.model.key.Key key) {
		keys.remove(key);
	}

	public boolean isExist(tokyo.leach.niwalaunchee.model.key.Key key) {
		return keys.contains(key);
	}

	public Set<tokyo.leach.niwalaunchee.model.key.Key> getKeys() {
		return keys;
	}

	public void setKeys(Set<tokyo.leach.niwalaunchee.model.key.Key> keys) {
		this.keys = keys;
	}
}
