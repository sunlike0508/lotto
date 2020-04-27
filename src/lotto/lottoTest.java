package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class lottoTest {
	/*
	 	1. 로또 숫자 구성
	 	  *숫자 범위 : 1 ~ 42
	 	  *갯수 : 기본 번호 6개 + 보너스 번호 1개
	 	2. 당첨 규칙
	 	  * 1등 : 기본 번호 6개 일치
	 	  * 2등 : 기본 번호 5개 일치 + 보너스 번호 1개 일치
	 	  * 3등 : 기본 번호 5개 일치
	 	  * 4등 : 기본 번호 4개 일치
	 	  * 5등 : 기본 번호 3개 일치
	 	3. 시뮬레이션 프로세스
	 	  * N개의 로또 자동 생성
	 	  * 당첨 번호 생성
	 	  * N개의 로또 의 당첨여부를 통개내어 출력
	 */

	@Test
	@DisplayName("Test create lotto object")
	void testShouldReturnSuccessWhenLottoClassIsCreated() {
		Lotto lotto = new Lotto();
		assertFalse(lotto == null);
	}
	
	@Test
	void testShouldReturnRandomNumberOfSix() {
		Lotto lotto = new Lotto();
		int[] lottoNumbers = lotto.getRandomLottoNumber();
		assertEquals(6, lottoNumbers.length);
	}

}
