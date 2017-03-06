import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 기지국
public class BOJ2300 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] building = new int[N][2];
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			building[i][0] = Integer.parseInt(st.nextToken());
			building[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(building);
		
	}
}
