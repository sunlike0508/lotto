package lotto;

import java.util.Random;

public class Lotto {
	
	private static final int LOTTO_COUNT = 6;
	private static final int MAX_LOTTO_NUMBER = 42;

	public int[] getNonoverlapRandomLottoNumber() {
		
		int[] lottoNumber = new int[LOTTO_COUNT];
		Random random = new Random();
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			lottoNumber[i] = random.nextInt(MAX_LOTTO_NUMBER)+1;
			
			for(int j = 0; j < i; j++) {
				if(lottoNumber[i] == lottoNumber[i]) {
					i--;
					break;
				}
			}
		}
		
		return lottoNumber;
	}

	public Boolean validateNonoverlapNumberList(int[] lotterNumber) {
		
		for(int i = 0; i < LOTTO_COUNT-1; i++) {
			for(int j = i+1 ; j < LOTTO_COUNT; j++) {
				if(lotterNumber[i] == lotterNumber[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
