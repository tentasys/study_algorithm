import java.io.*;
import java.util.*;
import java.awt.Point;

public class Solution {

	static final int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static final int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int map[][] = new int[N+1][N+1];
			map[N/2][N/2] = map[N/2+1][N/2+1] = 2;	//�鵹 �ʱ�ȭ
			map[N/2][N/2+1] = map[N/2+1][N/2] = 1;	//�浹 �ʱ�ȭ
			
			int count[] = {0, 2, 2};	//�浹 ī��Ʈ �ε����� 1, �鵹 ī��Ʈ �ε����� 2. �ʱ� ������ 2�� ����
			
			for(int jj=0; jj<M; jj++)
			{
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());	//�浹�� 1, �鵹�� 2
				
				map[r][c] = color;
				count[color]++;
				
				ArrayList<Point> change_list[] = new ArrayList[8];
				for(int i=0; i<8; i++)
					change_list[i] = new ArrayList<Point>();	//������ �� ã�Ƽ� ����Ʈ�� ���
				
				//���� �ٲ� ���� ã��
				for(int i=0; i<8; i++)		//�밢�� �������� Ž��
				{
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr > N || nc > N || nr <= 0 || nc <= 0)	//�ٿ���� üũ
						continue;
					
					if(map[nr][nc] == 0 || map[nr][nc] == color)	//���� ���ų� 0�̸� üũ ����
						continue;
					
					//��ȿ�� �����̸� ��� ã�� ������
					int temp_r = nr;
					int temp_c = nc;
					change_list[i].add(new Point(temp_r, temp_c));
					
					while(true)
					{
						temp_r = temp_r + dr[i];
						temp_c = temp_c + dc[i];
						
						//���� ������ �ٿ������ �Ѿ�� Ż��
						if(temp_r > N || temp_c > N || temp_r <= 0 || temp_c <= 0)
						{
							change_list[i] = null;
							break;
						}
						
						if(map[temp_r][temp_c] == color)	//���� ���� �� ������ ���� ����
							break;
						
						if(map[temp_r][temp_c] == 0)	//�߰��� 0�� ����������
						{
							change_list[i] = null;	//����Ʈ�� �����ɷ� ����� Ż��
							break;
						}						
						
						change_list[i].add(new Point(temp_r, temp_c)); 	//���� ���� �ֱ�. �� ���� ���� ������ �ٸ� ������ ��
					}
				}
				
				for(int i=0; i<8; i++)
				{
					if(change_list[i] == null)
						continue;
					
					for(Point p : change_list[i])
					{
						map[p.x][p.y] = color;
						count[color]++;
						
						if(color == 1)
							count[2]--;
						else
							count[1]--;
					}
				}

			}
			
			System.out.println("#"+ii+" "+count[1]+" "+count[2]);
		}
		
		br.close();
	}
}