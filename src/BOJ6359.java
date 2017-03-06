import java.util.Scanner;
// 만취한 상범
public class BOJ6359 {
	public static void main(String[] args) {
		int TC, n, cnt, round, door;
		boolean room[];
		Scanner scanner = new Scanner(System.in);
		TC = scanner.nextInt();
		
		while(TC>0) {
			cnt = 0;
			n = scanner.nextInt();
			room = new boolean[n];
			for (round = 1; round <= n; round++) {
				for(door = 0; door < n; door++) {
					if ((door+1) % round == 0) {
						if (room[door] == false) {
							cnt++;
							room[door] = true;
						}
						else {
							cnt--;
							room[door] = false;
						}
					}
				}
			}
			System.out.println(cnt);
			TC--;
		}
		scanner.close();
	}
}
