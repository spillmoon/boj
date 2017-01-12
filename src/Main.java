import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 동주형이 푼 1009번 문제
		Scanner input = new Scanner(System.in);

		int num = 1; // 테스트 케이스
		num = input.nextInt();
		int a[] = new int[num];// 밑수 1~99
		int b[] = new int[num];// 지수 1~1,000,000

		for (int i = 0; i < num; i++) {
			a[i] = input.nextInt();
			b[i] = input.nextInt();
		}

		Main output = new Main();

		for (int i = 0; i < num; i++) {
			System.out.println(output.lastNum(a[i], b[i]));

		}

	}

	public int lastNum(int a, int b) {

		switch (a % 10) {
		case 1:
			return 1;

		case 2:
			if (b % 4 == 0) {
				return 6;

			}
			if (b % 4 == 1) {
				return 2;
			}
			if (b % 4 == 2) {
				return 4;
			}
			if (b % 4 == 3) {
				return 8;

			}

		case 3:
			if (b % 4 == 0) {
				return 1;
			}
			if (b % 4 == 1) {
				return 3;
			}
			if (b % 4 == 2) {
				return 9;
			}
			if (b % 4 == 3) {
				return 7;
			}

		case 4:
			if (b % 2 == 0) {
				return 6;
			}
			if (b % 2 == 1) {
				return 4;
			}

		case 5:
			return 5;
		case 6:
			return 6;
		case 7:
			if (b % 4 == 0) {
				return 1;
			}
			if (b % 4 == 1) {
				return 7;
			}
			if (b % 4 == 2) {
				return 9;
			}
			if (b % 4 == 3) {
				return 3;

			}
		case 8:
			if (b % 4 == 0) {
				return 6;
			}
			if (b % 4 == 1) {
				return 8;
			}
			if (b % 4 == 2) {
				return 4;
			}
			if (b % 4 == 3) {
				return 2;

			}
		case 9:
			if (b % 2 == 0) {
				return 1;
			}
			if (b % 2 == 1) {
				return 9;
			}

		case 0:
			return 10;
		default:
			return -1;
		}

	}

}