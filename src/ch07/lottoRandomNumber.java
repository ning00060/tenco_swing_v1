package ch07;

import java.util.Arrays;
import java.util.Random;

// 클래스를 --> 단일 책임 원칙을 설정하는 것이 좋다.
public class lottoRandomNumber {

	final int LOTTO_NUMBER_COUNT = 6;
	// 6개의 랜덤 번호를 생성하는 메서드 필요하다

	public int[] createNumber() {

		int[] lottowinnum = new int[LOTTO_NUMBER_COUNT];
		Random random = new Random();
		// outer for -> 0 --> inner for -> 동작 X
		// outer for -> 1 --> inner for -> 한번 동작
		// outer for -> 2 --> inner for -> 두번 동작
		for (int i = 0; i < lottowinnum.length; i++) {
			lottowinnum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottowinnum[j] == lottowinnum[i]) {
					// 값이 중복된 상태
					i--;
				}

			}
		}
		Arrays.sort(lottowinnum); // 오름차순으로 자동 정렬

		return lottowinnum;
	}

	public static void main(String[] args) {
		lottoRandomNumber randomNumber = new lottoRandomNumber();
		int[] resultArray = randomNumber.createNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);

		}
	}

}
