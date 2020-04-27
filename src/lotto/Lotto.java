package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	private static final int LOTTO_COUNT = 6;
	private static final int MAX_lottoNumber = 42;
	
	int[] lottoNumber = new int[LOTTO_COUNT];
	int[] userLottoNumber = new int [LOTTO_COUNT];

	public Lotto() {
		
		Random random = new Random();
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			lottoNumber[i] = random.nextInt(MAX_lottoNumber)+1;
			
			for(int j = 0; j < i; j++) {
				if(lottoNumber[i] == lottoNumber[j]) {
					continue;
				}
			}
		}
		
		printLottoNumberArray(lottoNumber);
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
	
	private void printLottoNumberArray(int[] numberArray) {
		for(int number : numberArray) {
			System.out.print(number + " ");
		}
		
		System.out.println();
	}

	public void inputLottoNumberFromUser() {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < LOTTO_COUNT; i++) {
			userLottoNumber[i] = sc.nextInt();
			
			for(int j = 0; j < i; j++) {
				if(userLottoNumber[i] == userLottoNumber[j]) {
					continue;
				}
			}
		}
		
		sc.close();
		
		printLottoNumberArray(userLottoNumber);
	}
}
