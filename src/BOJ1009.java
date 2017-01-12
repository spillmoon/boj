import java.util.Scanner;


public class BOJ1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] r = new int[T];
		int[] a = new int[T];
		int[] b = new int[T];
		
		for(int tc=0; tc<T; tc++){
			a[tc] = sc.nextInt();
			b[tc] = sc.nextInt();
			r[tc] = 1;
			for(int i=0; i<b[tc]; i++){
				r[tc] = r[tc] * a[tc];
				if(r[tc] >= 10)
					r[tc] = r[tc] % 10;
			}
		}
		
		for(int i=0; i<T; i++)
			System.out.println(r[i]);
	}
}
