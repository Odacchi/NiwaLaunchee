package tokyo.leach.niwalaunchee.UnitTest.Helper;

import org.testng.annotations.Test;
import tokyo.leach.niwalaunchee.Helper.KeyHelper;
import tokyo.leach.niwalaunchee.model.key.Key;
import tokyo.leach.niwalaunchee.model.key.Keys;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by tomi on 2016/09/06.
 */
public class KeyHelperTest {
	@Test
	public void isSameKeyTest() {
		Keys keysA = new Keys();
		keysA.addKey(new Key('H'));
		keysA.addKey(new Key('I'));

		Keys keysB = new Keys();
		keysB.addKey(new Key('I'));
		keysB.addKey(new Key('H'));
		assertTrue(KeyHelper.isSameKey(keysA, keysB));
	}

	@Test
	public void isSameKeyFalseTest() {
		Keys keysA = new Keys();
		keysA.addKey(new Key('I'));

		Keys keysB = new Keys();
		keysB.addKey(new Key('J'));
		assertFalse(KeyHelper.isSameKey(keysA, keysB));
	}
}
