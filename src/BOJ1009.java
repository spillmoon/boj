import java.util.Scanner;
// 분산처리
public class BOJ1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int r, a, b;
		
		for(int tc = 0; tc < T; tc++){
			a = sc.nextInt();
			b = sc.nextInt();
			r = 1;
			for(int i = 0; i < b; i++){
				r = (r * a) % 10;
			}
			if(r == 0)
				r = 10;
			System.out.println(r);
		}
		sc.close();
	}
}
