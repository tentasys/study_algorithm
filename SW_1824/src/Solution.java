import java.util.*;
import java.io.*;

public class Solution {

	static final int dr[] = {-1, 1, 0, 0};	//��, ��, ��, ��
	static final int dc[] = {0, 0, -1, 1};	//0, 1, 2, 3
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char map[][] = new char[R][C];
			int visit[][] = new int[R][C];
			
			for(int i=0; i<R; i++)
			{
				String str = br.readLine();
				for(int j=0; j<C; j++)
					map[i][j] = str.charAt(j);
			}
			//�Է� �Ϸ�
			int memory = 0;
			boolean result = false;
			
			Queue<Node> q = new LinkedList<Node>();
			q.offer(new Node(0, 0, 3));
			visit[0][0] = 1;
			
			while(!q.isEmpty())
			{
				Node cur = q.poll();
				int r = cur.r;
				int c = cur.c;
				char op = map[r][c];		//���� �ɼ�
				int dir = cur.dir;
				
				if(op == '<')			//�̵� ������ �������� �ٲ۴�
					dir = 2;
				else if(op == '>')		//�̵� ������ ���������� �ٲ۴�
					dir = 3;
				else if(op == '^')		//�̵� ������ �������� �ٲ۴�
					dir = 0;
				else if(op == 'v')		//�̵� ������ �Ʒ������� �ٲ۴�
					dir = 1;
				else if(op == '_')		//�޸𸮿� 0�� ����Ǿ� ������ �̵� ������ ���������� �ٲٰ�, �ƴϸ� �������� �ٲ۴�
				{
					if(memory == 0)	dir = 3;
					else			dir = 2;
				}
				else if(op == '|')		//�޸𸮿� 0�� ����Ǿ� ������ �̵� ������ �Ʒ������� �ٲٰ�, �ƴϸ� �������� �ٲ۴�
				{
					if(memory == 0)	dir = 1;
					else			dir = 0;
				}
				else if(op == '?')		//�̵� ������ �����¿� �� �ϳ��� �������� �ٲ۴�. ������ �ٲ� Ȯ���� �� ���� �����ϴ�
				{
					//���� ������ ������ ��� ������ ť�� �ֱ�
					for(int i= 0; i<4; i++)
					{
						if(i == dir)	continue;
						
						//���� �� �� ���ϱ�
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						//�ٿ������ �Ѿ ��
						if(nr >= R)	nr = 0;
						if(nc >= C) nc = 0;
						if(nr < 0)	nr = R-1;
						if(nc < 0)	nc = C-1;
						
						if(visit[nr][nc] > 16)
							continue;
						
						visit[nr][nc]++;
						q.offer(new Node(nr, nc, i));
					}
				}
				else if(op == '.')		//�ƹ� �͵� ���� �ʴ´�
				{}
				else if(op == '@')		//���α׷��� ������ �����Ѵ�
				{
					result = true;
					break;
				}
				else if(op >= '0' && op <= '9')		//�޸𸮿� ���ڰ� ��Ÿ���� ���� �����Ѵ�
				{
					memory = op - '0';
				}
				else if(op == '+')		//�޸𸮿� ����� ���� 1�� ���Ѵ�. ���� ���ϱ� �� ���� 15�̶�� 0���� �ٲ۴�
				{
					memory++;
					if(memory == 16)	memory = 0;
				}
				else if(op == '-')		//�޸𸮿� ����� ���� 1�� ����. ���� ���� �� ���� 0�̶�� 15�� �ٲ۴�
				{
					memory--;
					if(memory == -1)	memory = 15;
				}
				
				//���� �� �� ���ϱ�
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				//�ٿ������ �Ѿ ��
				if(nr >= R)	nr = 0;
				if(nc >= C) nc = 0;
				if(nr < 0)	nr = R-1;
				if(nc < 0)	nc = C-1;
				
				if(visit[nr][nc] > 16)
					continue;
				
				visit[nr][nc]++;
				q.offer(new Node(nr, nc, dir));
			}
			
			//��� ���
			StringBuilder sb = new StringBuilder();
			sb.append("#"+ii+" ");
			if(result == true)
				sb.append("YES");
			else
				sb.append("NO");
			
			System.out.println(sb);
		}
		
		br.close();
	}

}

class Node{
	int r;	int c;	int dir;
	Node(int r, int c, int dir)
	{
		this.r = r;	this.c = c;	this.dir = dir;
	}
}