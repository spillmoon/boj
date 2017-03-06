import java.util.Scanner;
// 숫자삼각형
public class BOJ1932 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];
		int max;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = scanner.nextInt(); 
			}
		}
		dp[0][0] = triangle[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0)
					dp[i][j] = triangle[i][j] + dp[i-1][j];
				else if(j == i)
					dp[i][j] = triangle[i][j] + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j-1], triangle[i][j] + dp[i-1][j]);
			}
		}
		max = dp[N-1][0];
		for(int i = 1; i < N; i++) {
			if (dp[N-1][i] > max)
				max = dp[N-1][i];
		}
		System.out.println(max);
		scanner.close();
	}
}
