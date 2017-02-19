import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4781 {
	static int[] kal, price, maxKal;
	static int candyType;
	
	public static int addKal(int money) {
		int afterMoney;
		
		if(maxKal[money] != 0)
			return maxKal[money];
		
		for(int i = 0; i < candyType; i++){
			afterMoney = money - price[i];
			if(afterMoney >= 0){
				maxKal[money] = Math.max(maxKal[money], kal[i] + addKal(afterMoney));
			}
		}
		return maxKal[money];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int money;
		
		while(true){
			st = new StringTokenizer(br.readLine());
			candyType = Integer.parseInt(st.nextToken());;
			money = (int)(Float.parseFloat(st.nextToken()) * 100);
			if(candyType == 0)
				break;
			
			kal = new int[candyType];
			price = new int[candyType];
			
			for(int i = 0; i < candyType; i++){
				st = new StringTokenizer(br.readLine());
				kal[i] = Integer.parseInt(st.nextToken());
				price[i] = (int)(Float.parseFloat(st.nextToken()) * 100);
			}
			
			maxKal = new int[money+1];
			System.out.println(addKal(money));
		}
	}
}
