package tokyo.leach.niwalaunchee.Helper;

/**
 * Created by tomi on 2016/09/05.
 */
public class KeyHelper {
	public static boolean isSameKey(tokyo.leach.niwalaunchee.model.key.Keys keysA, tokyo.leach.niwalaunchee.model.key.Keys keysB) {
		if(keysA.getKeys().size() != keysB.getKeys().size()) return false;

		for(tokyo.leach.niwalaunchee.model.key.Key keyA : keysA.getKeys()) {
			if(keysB.isExist(keyA) == false) return false;
		}
		return true;
	}
}
