import java.util.Scanner;
// 더하기 사이클
public class BOJ1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int cnt=1;
		int chk = num;
		while(true){
			int a = num/10;
			int b = num%10;
			int c = a + b;
			num = b*10 + c%10;
			
			if(num==chk)
				break;
			else{
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
