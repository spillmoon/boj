import java.util.Scanner;
// 분수 찾기
public class BOJ1193 {
	public static void main(String[] args) {
		int find; 	// position to find
		int n;		// which line?
		int min;	// minimum range
		int max;	// maximum range
		Scanner sc = new Scanner(System.in);

		find = sc.nextInt();
		
		for(n=1;;n++){	// find line
			min = n*(n+1)/2-n;
			max = n*(n+1)/2;
			if((min < find) && (find <= max))
				break;	// now n is line number
		}
		
		if(n%2==1){	// if n is odd
			int u = 1;	// b u n j a
			int d = n;	// b u n m o
			while(true){
				if(max==find){
					System.out.println(u +"/"+d);
					break;
				}
				else{
					max--;
					u++;
					d--;
				}
			}
		}
		else{	// if n is even
			int u = n;
			int d = 1;
			while(true){
				if(max==find){
					System.out.println(u +"/"+d);
					break;
				}
				else{
					max--;
					u--;
					d++;
				}
			}
		}
	}
}
