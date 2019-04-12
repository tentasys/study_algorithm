import java.util.*;
import java.io.*;

public class Main {

	static final int dr[] = {-1, 1, 0, 0};	//�����¿�
	static final int dc[] = {0, 0, -1, 1};
	static int N;		//���� ũ��
	static int map[][];	//����
	static int shark_r, shark_c;	//���� ��� ��ǥ
	static int shark_size = 2;			//���� ��� ũ��
	static int shark_count = 0;			//�� ���� ���� ��
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		shark_r = 0;	shark_c = 0;	//�Ʊ����� ��ġ
		map = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9)	//����� ��� ��ǥ ����
				{
					shark_r = i;	shark_c = j;
					map[i][j] = 0;
				}
			}
		}
		
		//�Է� ��
		int count = 0;
		while(true)	//�� ���� -1 ��ȯ. �׶����� count �÷�����
		{
			int temp = solution();
			if(temp == -1)
				break;
			else
				count += temp;
		}
		
		System.out.print(count);
	}

	static int solution()
	{
		int result = -1;
		Queue<Fish> q = new LinkedList<Fish>();
		boolean visit[][] = new boolean[N][N];		//BFS �湮 üũ�ϱ� ���� �迭
		int dist[][] = new int[N][N];				//�ش� ��ǥ������ �Ÿ�
		
		q.offer(new Fish(shark_r, shark_c, shark_size));	//���� ����� ��ġ ����
		visit[shark_r][shark_c] = true;			//���� ��ġ�� �湮 üũ
		
		//BFS�� ����Ž��
		Fish min_fish = new Fish(999, 999, 999);
		int min_dist = Integer.MAX_VALUE;	//�̵� Ƚ���� �ּҰ�
		
		while(!q.isEmpty())
		{
			Fish cur = q.poll();		//ť�� ���� ������
			
			int nR, nC;					//���� ��ǥ
			
			for(int i=0; i<4; i++)
			{
				nR = cur.r + dr[i];		nC = cur.c + dc[i];		//�� ������ �� ��ǥ
				
				if(nR < 0 || nR >= N || nC < 0 || nC >= N)		//��ǥ ������ ��� ���
					continue;
				if(visit[nR][nC] == true)			//�̹� �湮���� ���
					continue;
				if(map[nR][nC] > cur.size)		//�� ��ġ�� ������ ū ����Ⱑ �����Ѵٸ� ���� ����
					continue;
				
				//��ƸԵ� ����ƸԵ� �̵��� �ؾ���
				dist[nR][nC] = dist[cur.r][cur.c] + 1;
				visit[nR][nC] = true;
				
				if(map[nR][nC] < cur.size && map[nR][nC] != 0)		//��Ƹ��� �� �ִٸ�
				{
					if(dist[nR][nC] < min_dist)		//�̵����� �ּҰ����� ������
					{
						min_dist = dist[nR][nC];			//�ּ� �Ÿ��� ������Ʈ
						min_fish = new Fish(nR, nC, map[nR][nC]);	//��Ƹ��� ����� ���� ������Ʈ
						continue;
					}
					else if(dist[nR][nC] == min_dist)	//�̵����� �ּҰ��̶� ������ ����� ��ǥ ��
					{
						Fish temp = new Fish(nR, nC, map[nR][nC]);	//����� ���� ���ϱ� ���� �ҷ���
						if(temp.compareTo(min_fish) < 0)		//������ ����⺸�� ���ǿ� ������
						{
							min_dist = dist[nR][nC];
							min_fish = temp;
							continue;
						}
					}	
				}
				
				//��Ƹ��� �� ���ٸ� �ٸ� ����� Ž��		
				q.offer(new Fish(nR, nC, shark_size));		
			}
		}
		
		if(min_dist < 400)		//����⸦ ���� ���
		{
			result = dist[min_fish.r][min_fish.c];	//���������� �����ϴ� �Ÿ�
			map[min_fish.r][min_fish.c] = 0;		//������ 0���� �����
			shark_r = min_fish.r;	//����� �� ��ǥ
			shark_c = min_fish.c;
			shark_count++;		//���� ���� �� ����
			
			if(shark_count%shark_size == 0)		//��� ũ�� ����
			{
				shark_count = 0;
				shark_size++;
			}
		}
		
		return result;
	}
}

class Fish implements Comparable<Fish>{
	int r, c;
	int size;
	Fish(){};
	Fish(int r, int c, int size)
	{
		this.r = r; this.c = c;	this.size = size;
	}
	
	@Override		
	public int compareTo(Fish f){
		if(this.r == f.r)
			return this.c-f.c;
		else
			return this.r-f.r;
	}

}