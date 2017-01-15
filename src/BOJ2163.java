import java.util.Scanner;

public class BOJ2163 {

	public static void main(String[] args) {
		int N, M;
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		scanner.close();
		// N * M => (N-1) + N(M-1) = N - 1 + N*M - N = N*M - 1
		System.out.println(N*M-1);
	}

}
