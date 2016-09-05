package tokyo.leach.niwalaunchee.UnitTest.model.key;

import org.testng.annotations.Test;
import tokyo.leach.niwalaunchee.model.key.Key;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by tomi on 2016/09/06.
 */
public class KeyTest {
	@Test
	public void keyNotEqualsTest() {
		Key keyA = new Key(new Character('H'));
		Key keyB = new Key(new Character('A'));
		assertNotEquals(keyA, keyB);
	}

	@Test
	public void keyEqualityTest() {
		Key keyA = new Key(new Character('H'));
		Key keyB = new Key(new Character('H'));
		assertEquals(keyA, keyB);
	}
}
