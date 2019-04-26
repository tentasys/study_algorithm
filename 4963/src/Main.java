import java.io.*;
import java.util.*;

public class Main {

	static final int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};	//�»�, ��, ���, ��, ��, ����, ��, ����
	static final int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};	//�»�, ��, ���, ��, ��, ����, ��, ����
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			////////////////////////////////////
			//�ʱ�����	
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if(r == 0 && c == 0)
				break;
			
			/////////////////////////////////////
			//�Է¹ޱ�
			int map[][] = new int[r][c];
			boolean visit[][] = new boolean[r][c];
			
			for(int i=0; i<r; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<c; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			/////////////////////////////////////
			//Ž�� ����
			int count = 0;
			Queue<Point> q = new LinkedList<Point>();
			
			for(int i=0; i<r; i++)
			{
				for(int j=0; j<c; j++)
				{
					if(map[i][j] == 1 && visit[i][j] == false)
					{
						count++;
						q.add(new Point(i, j));
						visit[i][j] = true;
						
						//BFS
						while(q.isEmpty() == false)
						{
							Point temp = q.poll();
							
							for(int k=0; k<8; k++)	//8���� Ž��
							{
								int nR = temp.r+dr[k];
								int nC = temp.c+dc[k];
								
								if(nR<0 || nR>=r || nC<0 || nC>=c)
									continue;
								if(visit[nR][nC] == true)
									continue;
								if(map[nR][nC] == 0)
									continue;
								
								visit[nR][nC] = true;
								q.offer(new Point(nR, nC));
							}
							
						}//BFS ��
					}//if�� ��
				}
			}
			
			System.out.println(count);
		}
		
		br.close();
	}

}

class Point{
	int r, c;
	Point(int r, int c)
	{
		this.r = r;	this.c = c;
	}
}
