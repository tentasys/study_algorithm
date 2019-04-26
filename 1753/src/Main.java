import java.util.*;
import java.io.*;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		//인접리스트
		ArrayList<Edge> adj[] = new ArrayList[V+1];
		for(int i=1; i<=V; i++)
			adj[i] = new ArrayList<Edge>();
		
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[start].add(new Edge(dest, weight));
		}
		
		//다익스트라
		//거리배열 초기화
		int dist[] = new int[V+1];
		for(int i=1; i<=V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[K] = 0;

		boolean visit[] = new boolean[V+1];
		
		//다익스트라 관리할 우선순위 큐
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.offer(new Edge(K, 0));
		
		//다익스트라 진입
		while(!q.isEmpty())
		{
			Edge cur = q.poll();

			if(visit[cur.dest] == false)
			{
				for(Edge e : adj[cur.dest])	//인접 리스트 탐색
				{
					int new_dist = dist[cur.dest]+e.weight;
					if(new_dist < dist[e.dest])
					{
						dist[e.dest] = new_dist;
						q.offer(new Edge(e.dest, dist[e.dest]));
					}
				}
			}
			visit[cur.dest] = true;
		}
		
		//출력
		for(int i=1; i<=V; i++)
		{
			if(dist[i] != Integer.MAX_VALUE)
				System.out.println(dist[i]);
			else
				System.out.println("INF");
		}
	}
 
}

class Edge implements Comparable<Edge>{
	int dest;
	int weight;
	
	Edge(int dest, int weight)
	{
		this.dest = dest;	this.weight = weight;
	}
	@Override
	public int compareTo(Edge arg)
	{
		return this.weight-arg.weight;
	}
}