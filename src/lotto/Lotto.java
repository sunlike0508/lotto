package lotto;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	
	private static final int LOTTO_COUNT = 6;
	private static final int MAX_LOTTO_NUMBER = 42;
	
	int[] LOTTO_NUMBER = new int[LOTTO_COUNT];
	int[] userLottoNumber = new int [LOTTO_COUNT];

	public Lotto() {
		
		Random random = new Random();
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			LOTTO_NUMBER[i] = random.nextInt(MAX_LOTTO_NUMBER)+1;
			
			for(int j = 0; j < i; j++) {
				if(LOTTO_NUMBER[i] == LOTTO_NUMBER[j]) {
					continue;
				}
			}
		}
		
		Arrays.sort(LOTTO_NUMBER);
		
		printLottoNumberArray();
	}

	public Boolean validateNonoverlapNumberList(int[] lotterNumber) {
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			for(int j = i+1 ; j < LOTTO_COUNT; j++) {
				if(lotterNumber[i] == lotterNumber[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void printLottoNumberArray() {
		for(int number : LOTTO_NUMBER) {
			System.out.print(number + " ");
		}
		
		System.out.println();
	}

	public void inputLottoNumberFromUser() {
		// TODO Auto-generated method stub
		
	}
}
