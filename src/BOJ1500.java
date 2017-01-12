import java.util.Scanner;


public class BOJ1500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s;
		int k;
		int result = 1;
		
		s = sc.nextInt();
		k = sc.nextInt();
		
		if((k<1)||(20<k)||(s<k)||(100<s))
			System.out.println("input error 1 <= k <= 20 AND k <= s <=100");
		else{
			int[] number = new int[k];
			int d = s/k;
			int r = s%k;
			
			for(int i=0;i<k;i++){
				number[i] = d;
			}
			
			for(int i=0;i<r;i++){
				number[i] += 1;
			}
			
			for(int i=0;i<k;i++){
				result *= number[i];
			}
			
			System.out.println("max mul is " + result);
		}
	}
}
