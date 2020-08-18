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
		// �ִܰŸ� ã��
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Node dist[] = new Node[N+1];
		
		dist[0] = new Node(Integer.MAX_VALUE, -1);
		
		for(int i=1; i<=N; i++)
		{
			dist[i] = new Node(i, Integer.MAX_VALUE);
		}
		
		dist[1].dist = 0;
		pq.offer(1);
		
		//���ͽ�Ʈ��
		while(!pq.isEmpty())
		{
			int cur = pq.poll();
			
			for(int a : graph[cur])		//����� �� ������Ʈ
			{
				if(dist[a].dist > dist[cur].dist+1)
				{
					dist[a].dist = dist[cur].dist+1;
					pq.offer(a);
				}
			}
		}
		
		//����
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
	public int compareTo(Node arg)	//�Ÿ� ª���� ������ ����
	{
		if(this.dist==arg.dist)		//�Ÿ� ������
		{
			return arg.num-this.num;	//��ȣ ū�� �켱
		}
		else
			return this.dist-arg.dist;	//�Ÿ� ª���� �켱
	}
	
}

//�Ÿ� ��� ��ȣ ������� ����
class Mysort implements Comparator<Node>{
	@Override
	public int compare(Node arg0, Node arg1)
	{
		return arg1.compareTo(arg0);
	}
}