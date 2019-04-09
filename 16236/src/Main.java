import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int map[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];			//������ ��� �ִ� ����
		Baby_Shark shark = null;		//��~��~���~�ѷ�ѶѶ�~
		ArrayList<Fish> fish = new ArrayList<Fish>();
		
		//�Է� �ޱ�
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9)						//�Ʊ��� ������
				{
					shark = new Baby_Shark(i, j, 2, 0);//��� �����
					map[i][j] = 0;						//�ٽ� ���ƿ;��ϹǷ� 0���� �����
				}
				else if(map[i][j] != 0)		fish.add(new Fish(i, j, map[i][j]));	//����� ����Ʈ�� �߰�
			}
		}
		//----�Է� ��
		
		int time = 0;		//�󸶸��� ������ û�ϴ°�
		
		//ã���鼭 �԰� �� �� ����!
		for(int i=0; i<fish.size(); i++)		//�� ���� ����� ����ŭ ����
		{
			int min_distance = 401;			//�ִ� ũ��� 20x20�̹Ƿ� 400�� ���� �� ����
			Fish min_fish = fish.get(0);	//�ּҰŸ��� ���� ��� ����
			
			for(int j=0; j<fish.size(); j++)
			{
				if(fish.get(j).isAlive() == false || fish.get(j).size >= shark.size)	//�׾��ų� ū���� �ǳʶ�
					continue;
				
				int temp;
				
				temp = distance(fish.get(j), shark);	//������ �Ÿ� ���ϱ�
				if(temp == -1)	continue;	//�� �� ���� ���
				else
				{
					//���� ������ ���ϱ�
					if(temp < min_distance)	//�Ÿ��� ������
					{
						min_distance = temp;
						min_fish = fish.get(j);
					}
					else if(temp == min_distance)	//�Ÿ��� ���� ���
					{
						if(fish.get(j).x < min_fish.x)		//���ʿ� ������
						{
							min_distance = temp;
							min_fish = fish.get(j);
						}
						else if(fish.get(j).x == min_fish.x)	//���̰� ���� ���
						{
							if(fish.get(j).y < min_fish.y)		//���ʿ� ������
							{
								min_distance = temp;
								min_fish = fish.get(j);
							}
						}
					}
				}//������ ���ϱ� ��
			}
			
			//���� ��� ���ϱ�
			if(min_distance < 401)
			{
				time += min_distance;			//�ð��� �Ÿ� ���ϱ�
				min_fish.alive = false;
				shark.level_up(1);
				shark.x = min_fish.x;
				shark.y = min_fish.y;
				map[min_fish.x][min_fish.y] = 0;
			}
		}
		
		System.out.print(time);
	}
	
	//�ּҰŸ� ã��
	static public int distance(Fish fish, Baby_Shark shark)
	{	
		Queue<Fish> q = new LinkedList<Fish>();
		q.offer(new Fish(shark.x, shark.y, 0));		//��� �̵�����
		
		int dist[][] = new int[N][N];
		boolean visit[][] = new boolean[N][N];
		int min = Integer.MAX_VALUE;
		
		//BFS���� ť�� ���� �� visit�� �� ����� �ߺ��湮�� ���� �ʴ´�
		while(!q.isEmpty())
		{
			Fish temp = q.poll();
			
			//��
			if(temp.x > 0)
			{
				if(map[temp.x-1][temp.y] <= shark.size && visit[temp.x-1][temp.y] == false)
				{
					visit[temp.x-1][temp.y] = true;
					q.offer(new Fish(temp.x-1, temp.y, 0));
					dist[temp.x-1][temp.y] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x-1 == fish.x && temp.y == fish.y)	min = Math.min(min, dist[temp.x-1][temp.y]);
				}
			}
			//��
			if(temp.x < N-1)
			{
				if(map[temp.x+1][temp.y] <= shark.size && visit[temp.x+1][temp.y] == false)
				{
					visit[temp.x+1][temp.y] = true;
					q.offer(new Fish(temp.x+1, temp.y, 0));
					dist[temp.x+1][temp.y] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x+1 == fish.x && temp.y == fish.y)	min = Math.min(min, dist[temp.x+1][temp.y]);
				}
			}
			//��
			if(temp.y > 0)
			{
				if(map[temp.x][temp.y-1] <= shark.size && visit[temp.x][temp.y-1] == false)
				{
					visit[temp.x][temp.y-1] = true;
					q.offer(new Fish(temp.x, temp.y-1, 0));
					dist[temp.x][temp.y-1] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x == fish.x && temp.y-1 == fish.y)	min = Math.min(min, dist[temp.x][temp.y-1]);
				}
			}
			//��
			if(temp.y < N-1)
			{
				if(map[temp.x][temp.y+1] <= shark.size && visit[temp.x][temp.y+1] == false)
				{
					visit[temp.x][temp.y+1] = true;
					q.offer(new Fish(temp.x, temp.y+1, 0));
					dist[temp.x][temp.y+1] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x == fish.x && temp.y+1 == fish.y)	min = Math.min(min, dist[temp.x][temp.y+1]);
				}
			}
		}
		
		if(dist[fish.x][fish.y] == 0)	return -1;
		else							return min;
	}
}

//��Ƹ��� ������
class Fish{
	int x;	int y;	int size;	boolean alive;
	Fish(){};
	Fish(int x, int y, int size)
	{
		this.x = x;		this.y = y;		this.size = size;	this.alive = true;
	}
	public boolean isAlive()
	{
		if(this.alive == true)	return true;
		else	return false;
	}
}

//�Ʊ� ���
class Baby_Shark{
	int x;	int y;	int size;	int count;
	Baby_Shark(){};
	Baby_Shark(int x, int y, int size, int count)
	{
		this.x = x;		this.y = y;		this.size = size;	this.count = count;
	}
	
	//�� �� ������ �������ϳ�
	public void level_up(int n) {
		int sum = n + this.count;
		
		if(sum/this.size > 0)
		{
			this.size++;
			this.count = 0;
		}
		else
			this.count += n;
	}
}