package lotto;

import java.util.Arrays;
import java.util.Random;

class LottoNumber{	
	int[] lottoNumber;
	int bonusNumber;
}

public class Lotto {
	
	private static final int LOTTO_COUNT = 6;
	private static final int MAX_LOTTO_NUMBER = 46;
	
	LottoNumber lottoNubmer;

	public Lotto() {
		
		lottoNubmer = createLottoNumber();
		
		printLottoNumberArray(lottoNubmer);
	}

	public LottoNumber createLottoNumber() {
		Random random = new Random();
		LottoNumber lottoNumber = new LottoNumber();
		lottoNumber.lottoNumber = new int[LOTTO_COUNT];
		lottoNumber.bonusNumber = random.nextInt(MAX_LOTTO_NUMBER);
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			lottoNumber.lottoNumber[i] = random.nextInt(MAX_LOTTO_NUMBER);
			
			for(int j = 0; j < i; j++) {
				if(lottoNumber.lottoNumber[i] == lottoNumber.lottoNumber[j] 
						||  lottoNumber.lottoNumber[i] == lottoNumber.bonusNumber) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(lottoNumber.lottoNumber);
		
		return lottoNumber;
	}

	public Boolean validateNonoverlapNumberList(int[] lotterNumber, int bonusNumber) {
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			for(int j = i+1 ; j < LOTTO_COUNT; j++) {
				if(lotterNumber[i] == lotterNumber[j] || lotterNumber[i] == bonusNumber) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void printLottoNumberArray(LottoNumber lottoNumber) {
		for(int number : lottoNumber.lottoNumber) {
			System.out.print(number + " ");
		}
		
		System.out.print(lottoNumber.bonusNumber);
		
		System.out.println();
	}

	public String matchClassLottoNumber(LottoNumber lottoNumber) {
		
		return "2등";
	}
}
