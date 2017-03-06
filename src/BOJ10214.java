import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// Baseball
public class BOJ10214 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int Y, K;
		String result = "";
		for(int tc = 0; tc < T; tc++){
			Y = K = 0;
			for(int i = 0; i < 9; i++){
				st = new StringTokenizer(br.readLine());
				Y += Integer.parseInt(st.nextToken());
				K += Integer.parseInt(st.nextToken());
			}
			result = (Y == K) ? "Draw" : ((Y > K) ? "Yonsei" : "Korea");
			System.out.println(result);
		}
	}
}
