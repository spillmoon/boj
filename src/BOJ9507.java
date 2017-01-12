import java.util.Scanner;

public class BOJ9507 {

	public static void main(String[] args) {
		int T, i, n;
		long myPibonach[] = new long[68];
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		
//		for(i = 0; i < T; i++){
//			System.out.print(i+1+" : ");
//			n = scanner.nextInt();
//			System.out.println(myPibonach(n));
//		}
		myPibonach[0] = 1;
		myPibonach[1] = 1;
		myPibonach[2] = 2;
		myPibonach[3] = 4;
		while (T-- > 0) {
			n = scanner.nextInt();
			if (myPibonach[n] == 0) {
				for (i = 4; i <= n; i++) {
					myPibonach[i] = myPibonach[i-4] + myPibonach[i-3] + myPibonach[i-2] + myPibonach[i-1];
				}
			}
			System.out.println(myPibonach[n]);
		}
		scanner.close();
	}
//	public static long myPibonach(int n){
//		if (n < 2) {
//			return 1L;
//		}
//		else if (n == 2) {
//			return 2L;
//		}
//		else if (n == 3) {
//			return 4L;
//		}
//		else {
//			return myPibonach(n-1) + myPibonach(n-2) + myPibonach(n-3) + myPibonach(n-4);
//		}
//	}
}
