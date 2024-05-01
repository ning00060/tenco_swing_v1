package test;

import java.util.Random;

//- 여러 개의 수가 배열에 있을 때 그 중 가장 큰 값과 가장 작은 값을 찾는다.
//- 배열의 몇 번째에 있는지 순서를 찾는다.
//- 반복문을 한번만 사용하여 문제를 해결한다.
//- 수의 예 : [10, 55, 23, 2, 79, 101, 16, 82, 30, 45]
public class MaxMin {

	public int[] getNumber() {
		int[] numbers = new int[6];
		Random random = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(60);
			for (int j = 0; j < i; j++) {
				if (numbers[j] == numbers[i]) {
					// 값이 중복된 상태

					i--;
				}
			}
		}
		return numbers;

	}

	public int max() {
		int maxNum = 0;
		int maxPos = 0;
		int minNum = 0;
		int minPos = 0;
		int[] maxNumber = getNumber();
		for (int i = 0; i < maxNumber.length; i++) {
//			maxNumber[i]=maxNumber[i];
//			System.out.println(maxNumber[i]);
			for (int j = 0; j < i; j++) {
				if (maxNumber[j] > maxNumber[i]) {
					maxNum = maxNumber[j];
					maxPos = j + 1;
//					System.out.println(maxNum+"큰값");
				}
				if (maxNumber[j] < maxNumber[i]) {
					minNum = maxNumber[j];
					minPos = j + 1;
//					System.out.println(minNum+"작은값");
				}

			}
		}
		System.out.println("가장 큰 값은 " + maxNum + "이고, 위치는 " + maxPos + "번째 입니다.");
		System.out.println("가장 작은 값은 " + minNum + "이고, 위치는 " + minPos + "번째 입니다.");
		return minNum;
	}
//	public int min() {
//
//		int[] maxNumber=getNumber();
//		for (int i = 0; i < maxNumber.length; i++) {
//			maxNumber[i]=maxNumber[i];
//			System.out.println(maxNumber[i]);
//			for (int j = 0; j < i; j++) {
//				if (maxNumber[j]<maxNumber[i]) {
//					minNum=maxNumber[j];
//					minPos=j+1;
////					System.out.println(minNum+"작은값");
//				}
//				
//			}
//		}
//		

	public static void main(String[] args) {
		MaxMin randomNumber = new MaxMin();
		int number = randomNumber.max();

		System.out.println(number);

	}
}
