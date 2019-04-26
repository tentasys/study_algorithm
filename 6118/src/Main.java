import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> graph[] = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		/////////////////////////////////////////////////
		// 최단거리 찾기
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Node dist[] = new Node[N+1];
		
		dist[0] = new Node(Integer.MAX_VALUE, -1);
		
		for(int i=1; i<=N; i++)
		{
			dist[i] = new Node(i, Integer.MAX_VALUE);
		}
		
		dist[1].dist = 0;
		pq.offer(1);
		
		//다익스트라
		while(!pq.isEmpty())
		{
			int cur = pq.poll();
			
			for(int a : graph[cur])		//연결된 점 업데이트
			{
				if(dist[a].dist > dist[cur].dist+1)
				{
					dist[a].dist = dist[cur].dist+1;
					pq.offer(a);
				}
			}
		}
		
		//정렬
		Arrays.sort(dist, new Mysort());
		
		int max_no = dist[0].num;
		int max_dist = dist[0].dist;
		int count = 1;
		
		for(int i=1; i<dist.length; i++)
		{
			if(dist[i].dist == max_dist)
				count++;
			else
				break;
		}
		
		System.out.print(max_no+" "+max_dist+" "+count);
	}

}

class Node implements Comparable<Node>{
	int num;
	int dist;
	Node(int n, int dist)
	{
		this.num = n;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Node arg)	//거리 짧은걸 꺼내기 위함
	{
		if(this.dist==arg.dist)		//거리 같을땐
		{
			return arg.num-this.num;	//번호 큰게 우선
		}
		else
			return this.dist-arg.dist;	//거리 짧은게 우선
	}
	
}

//거리 길고 번호 작은대로 정렬
class Mysort implements Comparator<Node>{
	@Override
	public int compare(Node arg0, Node arg1)
	{
		return arg1.compareTo(arg0);
	}
}