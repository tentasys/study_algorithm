import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {

	static final int dr[] = {-1, 1, 0, 0};	//�����¿�
	static final int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine().trim());
		
		for(int ii=1; ii<=T; ii++)
		{
			int N = Integer.parseInt(br.readLine().trim());
			int map[][] = new int[N][N];
			Point wormhole[][] = new Point[11][2];
						
			for(int i=0; i<N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
				{
					int cur = Integer.parseInt(st.nextToken());
					map[i][j] = cur;
					
					if(cur >= 6 && cur <= 10)		//��Ȧ �迭�� �ֱ�
					{
						if(wormhole[cur][0] == null)	wormhole[cur][0] = new Point(i, j);
						else							wormhole[cur][1] = new Point(i, j);
					}
				}
			}
			
			int max = Integer.MIN_VALUE;			//������ �ִ밪
			int dp[][][] = new int[N][N][4];		//�����¿쿡 ���� ���� ����
			boolean visit[][][] = new boolean[N][N][4];
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(map[i][j] != 0)		continue;	//0�϶��� Ž�� ����
					
					for(int k=0; k<4; k++)
					{
						int temp = Simulation(map, visit, dp, N, wormhole, i, j, k);
						max = Math.max(max, temp);
					}	
				}
			}
			
			System.out.println("#"+ii+" "+max);
		}
		
		br.close();
	}

	static int Simulation(int map[][], boolean visit[][][], int dp[][][], int N, Point hole[][], int r, int c, int dir)
	{
		int sum = 0;
		int start_r = r;	int start_c = c;
		r = r + dr[dir];		c = c + dc[dir];	//���Ⱚ ���� ������ ����
		
		while(true)
		{	
			if(r < 0 || c < 0 || r >= N || c >= N)		//���� �ε����� ���� �ٲٱ�
			{
				if(dir%2 == 0)		dir++;		//0->1, 2->3
				else				dir--;		//1->0, 3->2
				
				sum++;					//���� ����
				
				//��ǥ ����
				if(r < 0)		r++;
				else if(c < 0)	c++;
				else if(r >= N)	r--;
				else			c--;
			}
			else if(map[r][c] >= 6 && map[r][c] <= 10)		//��Ȧ Ÿ��
			{
				Point one = hole[map[r][c]][0];		//�ش� ��ȣ�� ��Ȧ ������
				Point two = hole[map[r][c]][1];
				
				if(one.x == r && one.y == c)	//�ش��ϴ� ��Ȧ�� �ݴ��� ��Ȧ�� �̵�
				{
					r = two.x+dr[dir];		c = two.y+dc[dir];	//���Ⱚ ���ϱ�
				}
				else
				{
					r = one.x+dr[dir];		c = one.y+dc[dir];	//���Ⱚ ���ϱ�
				}
			}
			else if(map[r][c] >=1 && map[r][c] <= 5)	//���� �ε����� : �� ���⿡ ���� ������ ������ �ٸ� / ��ǥ ����
			{
				switch(map[r][c])
				{
				case 1:	//1�����
					if(dir == 0)
					{	dir = 1;	r++;	}
					else if(dir == 1)
					{	dir = 3;	c++;	}
					else if(dir == 2)
					{	dir = 0;	r--;	}
					else if(dir == 3)
					{	dir = 2;	c--;	}
					break;
					
				case 2:	//2�����
					if(dir == 0)
					{	dir = 3;	c++;	}
					else if(dir == 1)
					{	dir = 0;	r--;	}
					else if(dir == 2)
					{	dir = 1;	r++;	}
					else if(dir == 3)
					{	dir = 2;	c--;	}
					break;
				
				case 3:	//3�����
					if(dir == 0)
					{	dir = 2;	c--;	}
					else if(dir == 1)
					{	dir = 0;	r--;	}
					else if(dir == 2)
					{	dir = 3;	c++;	}
					else if(dir == 3)
					{	dir = 1;	r++;	}
					break;
				
				case 4:	//4�����
					if(dir == 0)
					{	dir = 1;	r++;	}
					else if(dir == 1)
					{	dir = 2;	c--;	}
					else if(dir == 2)
					{	dir = 3;	c++;	}
					else if(dir == 3)
					{	dir = 0;	r--;	}
					break;
					
				case 5: //�������� �ݴ�������� �̵�
					if(dir == 0)
					{	dir = 1;	r++;	}
					else if(dir == 1)
					{	dir = 0;	r--;	}
					else if(dir == 2)
					{	dir = 3;	c++;	}
					else if(dir == 3)
					{	dir = 2;	c--;	}
					break;
				}
				sum++;
			}
			else if(map[r][c] == -1 || (r==start_r && c==start_c))	//Ż�� ����
			{
				break;
			}
			else		//0�϶� �̵�
			{
				//���� ��ǥ ����
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				r = nr;
				c = nc;
				
				if(r >= N || c >= N || r < 0 || c < 0)		//�ٿ������ �Ѿ�� ��� �迭 üũ�� �н�
					continue;
//				
//				if(visit[r][c][dir] == true && dp[r][c][dir] >= sum)		//�湮���� ��� -> dp���� ���簪���� �� ũ�� �� �ʿ� X
//					break;
//				
//				visit[r][c][dir] = true;	//�湮 üũ
//				dp[r][c][dir] = sum;
			}
		}
		
		return sum;
	}
}
