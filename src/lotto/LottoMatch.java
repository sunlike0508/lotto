package lotto;

import java.util.Arrays;
import java.util.Random;

class Lotto{	
	int[] lottoNumber;
	int bonusNumber;
}

public class LottoMatch implements LottoInterface{

	Lotto lotto;

	public LottoMatch() {
		lotto = createLottoNumber();
	}

	public Lotto createLottoNumber() {
		Random random = new Random();
		Lotto lotto = new Lotto();
		lotto.lottoNumber = new int[LOTTO_COUNT];
		lotto.bonusNumber = random.nextInt(MAX_LOTTO_NUMBER)+1;
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			lotto.lottoNumber[i] = random.nextInt(MAX_LOTTO_NUMBER)+1;
			
			for(int j = 0; j < i; j++) {
				if(lotto.lottoNumber[i] == lotto.lottoNumber[j]
						|| lotto.lottoNumber[i] == lotto.bonusNumber) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(lotto.lottoNumber); // 정렬할 필요는 없는데 출력 시 깔끔하게 보이기 위해서 정렬
		
		return lotto;
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

	public String matchClassLottoNumber(Lotto userlotto) {
		return returnMatchClass(userlotto, countMatchLottoNumber(userlotto));
	}
	
	private int countMatchLottoNumber(Lotto userlotto) {
		int matchCount = 0;
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			for(int j = 0; j < LOTTO_COUNT; j++) {
				if(lotto.lottoNumber[i] == userlotto.lottoNumber[j]) {
					matchCount++;
				}
			}
		}
		
		return matchCount;
	}

	private String returnMatchClass(Lotto userlotto, int matchCount) {
		if(matchCount == FIRST_CLASS) {
			return "1등";
		} else if(matchCount == SECOND_CLASS && lotto.bonusNumber == userlotto.bonusNumber){
			return "2등";
		} else if(matchCount == THIRD_CLASS){
			return "3등";
		} else if(matchCount == FOUR_CLASS){
			return "4등";
		} else if(matchCount == FIVE_CLASS) {
			return "5등";
		} else {
			return "꽝";
		}
	}
	
	public void printLottoNumberArray(Lotto lotto) {
		for(int number : lotto.lottoNumber) {
			System.out.print(number + " ");
		}
		
		System.out.print(lotto.bonusNumber);
		System.out.println();
	}
	
	public static void main(String[] argv) {
		LottoMatch lottoMatch = new LottoMatch();
		Lotto mylottNumber = lottoMatch.createLottoNumber();
		lottoMatch.printLottoNumberArray(lottoMatch.lotto);
		lottoMatch.printLottoNumberArray(mylottNumber);
		System.out.println(lottoMatch.matchClassLottoNumber(mylottNumber));
	}
}
