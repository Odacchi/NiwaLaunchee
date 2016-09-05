package tokyo.leach.niwalaunchee.UnitTest.model.key;

import org.testng.annotations.Test;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.Keys;

import static org.testng.Assert.*;

/**
 * Created by tomi on 2016/09/06.
 */
public class KeysTest {
	@Test
	public void keysExistTest() {
		Keys keys = new Keys();
		keys.addKey(new Key('H'));
		assertTrue(keys.isExist(new Key('H')));
		assertFalse(keys.isExist(new Key('I')));
	}
}
