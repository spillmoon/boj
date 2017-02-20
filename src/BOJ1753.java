import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ1753 {
	static final int INF = 11;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점과 간선, 시작 정점 입력
		int nVertex = Integer.parseInt(st.nextToken());
		int nEdge = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sVertex = Integer.parseInt(st.nextToken());
		
		// 간선을 저장할 벡터 배열
		Vector<Line>[] vector = new Vector[nVertex+1];
		for(int i = 0; i < vector.length; i++){
			vector[i] = new Vector<>();
		}
		// 간선 입력
		for(int i = 0; i < nEdge; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// 시작점 u에서 뻗어나가는 간선들을 벡터(u)에 저장
			vector[u].add(new Line(u, v, w));
		}
		// 총 가중치, 방문여부
		int dist[] = new int[nVertex+1];
		boolean[] visit = new boolean[nVertex+1];
		// 방문 전이므로 가중치는 크다
		for(int i = 0; i < dist.length; i++){
			dist[i] = INF;
		}
		// 시작점에서 시작점까지는 0
		dist[sVertex] = 0;
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		pq.add(new Line(sVertex, sVertex, 0));
		
		while(!pq.isEmpty()){
			int nowVertex;
			// 한 정점을 선택
			do{
				nowVertex = pq.peek().v;
				pq.poll();
			}while(visit[nowVertex]);
			if(visit[nowVertex])
				break;
			// 해당 정점에 연관된 간선들 선택 후 우선순위 큐에 삽입, 거리 계산
			for(Line line : vector[nowVertex]){
				int nextVertext = line.v;
				int oldDist = dist[nextVertext];
				int newDist = dist[nowVertex] + line.w;
				dist[nextVertext] = (newDist < oldDist) ? newDist:oldDist;
				pq.add(new Line(nowVertex, nextVertext, dist[nextVertext]));
			}
		}
		for(int i = 1; i < dist.length; i++){
			if(dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
}
// 간선의 시작, 끝, 가중치를 저장할 클래스
class Line implements Comparable<Line>{
	int u, v, w;
	
	public Line(int u, int v, int w){
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Line line) {
		return (w <= line.w) ? -1:1;
	}
}