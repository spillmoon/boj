import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int maxVertex = Integer.parseInt(st.nextToken());
        int maxEdge = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine())-1;
        // 간선이 저장될 공간
        Vector<Element>[] fromToArr = new Vector[maxVertex];
        for (int i = 0; i < fromToArr.length; i++) {
            fromToArr[i] = new Vector<>();
        }
        // 간선 입력
        for (int i = 0; i < maxEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 점에서 점으로 연결되는 간선
            fromToArr[from - 1].add(new Element(weight, to - 1));
        }

        int[] dist = new int[maxVertex];
        boolean[] visited = new boolean[maxVertex];
        // 방문 전
        for (int i = 0; i < maxVertex; i++) {
            dist[i] = INF;
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

            if (visited[curVertex])
            	break;

            for (Element e : fromToArr[curVertex]) {
                int next = e.vertex;
                int oldDis = dist[next];
                int newDis = dist[curVertex] + e.weight;

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
    int weight;
    int vertex;

    public Element(int weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Element o) {
        return weight <= o.weight ? -1 : 1;
    }
}
