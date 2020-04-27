package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
	 	  * N개의 로또 의 당첨여부를 통계내어 출력
	 */
	
	private Lotto lotto;
	
	@BeforeEach
	void testBeoreEach() {
		lotto = new Lotto();
	}

	@Test
	@DisplayName("Test create lotto object")
	void testShouldReturnSuccessWhenLottoClassIsCreated() {
		assertTrue(lotto != null);
	}
	
	@Test
	@DisplayName("숫자 배열 중복 검사 하는 메소드. 결과 값은 성공")
	void testShouldReturnSuccessCheckNonoverlapNumberOfSix() {
		assertTrue(lotto.validateNonoverlapNumberList(new int[] {1,2,3,4,5,6}));
	}

	@Test
	@DisplayName("숫자 배열 중복 검사하는 메소드. 결과 값을 실패")
	void testShouldReturnFailCheckNonoverlapNumberOfSix() {
		assertFalse(lotto.validateNonoverlapNumberList(new int[] {1,2,3,4,5,1}));
	}
	
	@Test
	@DisplayName("랜덤으로 생성된 숫자 중복 검사 테스트. 결과는 성공")
	void testShouldReturnSuccessCheckNonoverlapRandomNumberOfSix() {
		assertTrue(lotto.validateNonoverlapNumberList(lotto.LOTTO_NUMBER));
	}
	
	@Test
	@DisplayName("사용자로부터 로또 번호 입력 받은 숫자 중복 테스트")
	void testShouldReturnSuccessNonoverlapInputNumberFromUser() {
		lotto.inputLottoNumberFromUser();
		assertTrue(lotto.validateNonoverlapNumberList(lotto.userLottoNumber));
	}
}
