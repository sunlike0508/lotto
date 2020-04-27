package lotto;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public int[] getRandomLottoNumber() {
		
		int[] lottoNumber = new int[6];
		Random random = new Random();
		
		for(int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = random.nextInt(42)+1;
		}
		
		return lottoNumber;
	}

}
