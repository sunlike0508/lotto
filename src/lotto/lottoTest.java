package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class lottoTest {

	@Test
	@DisplayName("Test create lotto object")
	void testShouldReturnSuccessWhenLottoClassIsCreated() {
		Lotto lotto = new Lotto();
		
		assertFalse(lotto == null);

	}

}
