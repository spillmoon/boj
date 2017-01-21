import java.util.Scanner;

public class BOJ11722 {
	public static void main(String[] args) {
		int N;
		int[] sequence = new int[1000];
		int[] count = new int[1000];
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		for(int i = 0; i < N; i++){
			sequence[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < N; i++){
			count[i] = 1;
			for(int j = 0; j < i; j++){
				if(sequence[i] < sequence[j] && count[j]+1 > count[i])
					count[i] = count[j] + 1;
			}
		}
		int result = count[0];
		for(int i = 0; i < N; i++){
			if(count[i] > result)
				result = count[i];
		}
		System.out.println(result);
		scanner.close();
	}
}