import java.util.Scanner;

public class BOJ2698 {
	public static void main(String[] args) {
		int TC, n, k;
		int[][][] bitArr = new int[105][105][2]; // 길이, 인접 비트 수, 끝 비트 경우(0, 1)
		Scanner scanner = new Scanner(System.in);
		
		bitArr[1][0][0] = 1; // n=1, k=0 => bit : 0
		bitArr[1][0][1] = 1; // n=1, k=0 => bit : 1
		for (int i = 2; i < 105; i++) {
			for (int j = 0; j < i; j++) {
				bitArr[i][j][0] = bitArr[i-1][j][0] + bitArr[i-1][j][1];
				bitArr[i][j][1] = bitArr[i-1][j][0] + ((j>0) ? bitArr[i-1][j-1][1] : 0);
			}
		}
		
		TC = scanner.nextInt();
		for (int t = 0; t < TC; t++) {
			n = scanner.nextInt();
			k = scanner.nextInt();
			System.out.println(bitArr[n][k][0] + bitArr[n][k][1]);
		}
		scanner.close();
	}
}
