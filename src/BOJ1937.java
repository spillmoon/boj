import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 욕심쟁이 판다
public class BOJ1937 {
	//{하, 우, 상, 좌}
	final static int[] X = {0, 1, 0, -1};
	final static int[] Y = {1, 0, -1, 0};
	static int N;
	static int[][] bambooArr;
	static int[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		bambooArr = new int[N][N];
		visit = new int[N][N];
		int result = 0;
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				bambooArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				result = Math.max(result, move(i, j));
			}
		}
		System.out.println(result);
	}
	public static int move(int i, int j) {
		if(visit[i][j] != 0)
			return visit[i][j];
		
		int day = 1;		
		for(int d = 0; d < 4; d++){
			int nextX = i + X[d];
			int nextY = j + Y[d];
			
			if((nextX >=0 && nextX < N) && (nextY >= 0 && nextY < N)){
				if(bambooArr[nextX][nextY] > bambooArr[i][j]){
					day = Math.max(day, move(nextX, nextY)+1);
					visit[i][j] = day;
				}
			}
		}
		return day;
	}
}
