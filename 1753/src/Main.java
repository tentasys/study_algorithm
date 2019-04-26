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
		
		//��������Ʈ
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
		
		//���ͽ�Ʈ��
		//�Ÿ��迭 �ʱ�ȭ
		int dist[] = new int[V+1];
		for(int i=1; i<=V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[K] = 0;

		boolean visit[] = new boolean[V+1];
		
		//���ͽ�Ʈ�� ������ �켱���� ť
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.offer(new Edge(K, 0));
		
		//���ͽ�Ʈ�� ����
		while(!q.isEmpty())
		{
			Edge cur = q.poll();

			if(visit[cur.dest] == false)
			{
				for(Edge e : adj[cur.dest])	//���� ����Ʈ Ž��
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
		
		//���
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