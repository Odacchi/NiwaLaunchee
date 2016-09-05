package tokyo.leach.niwalaunchee.model.key;

/**
 * Created by tomi on 2016/09/05.
 */
public class Key {
	Character key;

	public Key(Character key) {
		this.key = key;
	}

	public Character getKey() {
		return key;
	}

	public void setKey(Character key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object keyB) {
		return key.equals(((Key)keyB).getKey());
	}
}
