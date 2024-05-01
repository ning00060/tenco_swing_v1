package test;

import java.util.Arrays;
import java.util.Random;

public class testLotto {

	public int[] createNumber() {
		int[] getNum = new int[6];
		Random random = new Random();
		for (int i = 0; i < getNum.length; i++) {
			getNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (getNum[i] == getNum[j]) {
					i--;
				}

			}
		}
		Arrays.sort(getNum);
		return getNum;
	}

	public static void main(String[] args) {
		testLotto testlotto = new testLotto();
		int[] resultNumber = testlotto.createNumber();
		for (int i = 0; i < resultNumber.length; i++) {
			System.out.println(resultNumber[i]);
		}

	}
}
