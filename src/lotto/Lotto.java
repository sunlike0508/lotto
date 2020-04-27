package lotto;

import java.util.Random;

public class Lotto {
	
	private static final int LOTTO_COUNT = 6;
	private static final int MAX_LOTTO_NUMBER = 42;

	public int[] getRandomLottoNumber() {
		
		int[] lottoNumber = new int[LOTTO_COUNT];
		Random random = new Random();
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			lottoNumber[i] = random.nextInt(MAX_LOTTO_NUMBER)+1;
		}
		
		return lottoNumber;
	}

}
