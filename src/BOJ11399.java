import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 11399 ATM
public class BOJ11399 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] people = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < people.length; i++)
			people[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(people);
		int total = 0;
		for(int i = 0; i < people.length; i++){
			for(int j = 0; j <=i; j++){
				total += people[j];
			}
		}
		System.out.println(total);
	}
}
