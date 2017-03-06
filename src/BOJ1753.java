import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ1753 {
	// 방문 전의 무한대 값
    public static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점, 간선, 시작점
        int nVertex = Integer.parseInt(st.nextToken());
        int nEdge = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;
        // 간선이 저장될 공간
        Vector<Element>[] adj = new Vector[nVertex];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Vector<>();
        }
        // 간선 입력
        for (int i = 0; i < nEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 점에서 점으로 연결되는 간선
            adj[start - 1].add(new Element(weight, end - 1));
        }

        int[] dist = new int[nVertex];
        boolean[] visited = new boolean[nVertex];
        // 방문 전
        for (int i = 0; i < nVertex; i++) {
            dist[i] = INF;
            visited[i] = false;
        }
        // 다익스트라
        PriorityQueue<Element> pq = new PriorityQueue<>();
        dist[K] = 0;
        pq.offer(new Element(0, K));

        while (!pq.isEmpty()) {
            int curVertex;
            do {
                curVertex = pq.peek().vertex;
                pq.poll();
            } while (!pq.isEmpty() && visited[curVertex]);

            if (visited[curVertex]) break;

            for (Element e : adj[curVertex]) {
                int next = e.vertex;
                int oldDis = dist[next];
                int newDis = dist[curVertex] + e.dis;

                if (newDis < oldDis) {
                    dist[next] = newDis;
                    pq.offer(new Element(newDis, next));
                }
            }
        }
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}

class Element implements Comparable<Element> {
    int dis;
    int vertex;

    public Element(int dis, int vertex) {
        this.dis = dis;
        this.vertex = vertex;
    }


    @Override
    public int compareTo(Element o) {
        return dis <= o.dis ? -1 : 1;
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//import java.util.Vector;
//// 최단경로
//public class BOJ1753 {
//	public static final int INF = 10000000;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		// 정점과 간선, 시작 정점 입력
//		int nVertex = Integer.parseInt(st.nextToken());
//		int nEdge = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		int sVertex = Integer.parseInt(st.nextToken());
//		
//		// 간선을 저장할 벡터 배열
//		Vector<Line>[] vector = new Vector[nVertex+1];
//		for(int i = 1; i < vector.length; i++){
//			vector[i] = new Vector<>();
//		}
//		// 간선 입력
//		for(int i = 0; i < nEdge; i++){
//			st = new StringTokenizer(br.readLine());
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			// 시작점 u에서 뻗어나가는 간선들을 벡터(u)에 저장
//			vector[u].add(new Line(v, w));
//		}
//		// 총 가중치, 방문여부
//		int dist[] = new int[nVertex+1];
//		boolean[] visit = new boolean[nVertex+1];
//		// 방문 전이므로 가중치는 크다
//		for(int i = 0; i < dist.length; i++){
//			dist[i] = INF;
//		}
//		// 시작점에서 시작점까지는 0
//		dist[sVertex] = 0;
//		
//		PriorityQueue<Line> pq = new PriorityQueue<>();
//		pq.add(new Line(sVertex, 0));
//		
//		while(!pq.isEmpty()){
//			int nowVertex;
//			// 한 정점을 선택
//			do{
//				nowVertex = pq.peek().v;
//				pq.poll();
//			}while(visit[nowVertex]);
//			if(visit[nowVertex])
//				break;
//			// 해당 정점에 연관된 간선들 선택 후 우선순위 큐에 삽입, 거리 계산
//			for(Line line : vector[nowVertex]){
//				int nextVertext = line.v;
//				int oldDist = dist[nextVertext];
//				int newDist = dist[nowVertex] + line.w;
//				dist[nextVertext] = (newDist < oldDist) ? newDist:oldDist;
//				pq.add(new Line(nextVertext, dist[nextVertext]));
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for(int i = 1; i < dist.length; i++){
//			if(dist[i] == INF)
//				sb.append("INF").append("\n");
//			else
//				sb.append(dist[i]).append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//}
//// 간선의 시작, 끝, 가중치를 저장할 클래스
//class Line implements Comparable<Line>{
//	int v, w;
//	
//	public Line(int v, int w){
//		this.v = v;
//		this.w = w;
//	}
//	
//	@Override
//	public int compareTo(Line line) {
//		return (w <= line.w) ? -1:1;
//	}
//}