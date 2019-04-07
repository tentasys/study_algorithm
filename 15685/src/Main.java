import java.util.*;
import java.io.*;

//59�� 57��
public class Main {

	static int map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//-----�Է¹ޱ�
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101]; 
		
		int x[] = new int[N];
		int y[] = new int[N];
		int d[] = new int[N];
		int g[] = new int[N];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		//-----�Է¹ޱ� ��
		
		//�� ȸ���� �巡��Ŀ�� ����
		for(int i=0; i<N; i++)
		{
			//�巡�� Ŀ���� ����
			ArrayList<Point> dragon = new ArrayList<Point>();
			
			int initial_x = x[i];
			int initial_y = y[i];
			dragon.add(new Point(initial_x, initial_y));
			
			//0���� �巡�� Ŀ�긦 ���� �̵�
			int second_x = initial_x;
			int second_y = initial_y;
			
			if(d[i] == 0)		//x��ǥ ����, ������
				second_x++;
			else if(d[i] == 1)	//y��ǥ ����, ����
				second_y--;
			else if(d[i] == 2)	//x��ǥ ����, ����
				second_x--;
			else	//(d[i] == 3), y��ǥ�� �����ϴ� ����, �Ʒ���
				second_y++;
			
			dragon.add(new Point(second_x, second_y));
			
			//���뺰 �巡�� Ŀ�� ���ϱ�
			for(int j=0; j<g[i]; j++)
			{
				//�巡�� Ŀ���� �������� �ִ� ��ǥ ���ϱ�
				int start_x = dragon.get(dragon.size()-1).x;
				int start_y = dragon.get(dragon.size()-1).y;
				
				//������ ��ǥ�� 0���� ����� �� ���ϱ�
				int make_zero_x = start_x*(-1);
				int make_zero_y = start_y*(-1);
				
				//���� �߰��� ����Ʈ ���ϱ�
				ArrayList<Point> newList = new ArrayList<Point>();
				
				//���� �巡�� Ŀ�긦 ���鼭 �̵��ϱ�
				for(int k = dragon.size()-1; k>=0; k--)
				{
					int new_x = (dragon.get(k).y+make_zero_y)*(-1)-make_zero_x;
					int new_y = dragon.get(k).x+make_zero_x-make_zero_y;
					newList.add(new Point(new_x, new_y));
				}
				
				//���� �߰��� ����Ʈ�� �� ����Ʈ�� �߰��ϱ�
				for(Point p : newList)
					dragon.add(new Point(p.x, p.y));
			}
			
			//���� �巡�� Ŀ�긦 ���ڿ� ���
			for(Point p: dragon)
				map[p.x][p.y] = 1;
		}
		
		//�巡�� Ŀ�긦 ���������� �ϴ� �簢�� ���ϱ�
		int result = 0;
		for(int i=0; i<100; i++)
		{
			for(int j=0; j<100; j++)
			{
				if(map[i][j] == 0)
					continue;
				if(map[i+1][j] == 0)
					continue;
				if(map[i][j+1] == 0)
					continue;
				if(map[i+1][j+1] == 0)
					continue;
				result++;
			}
		}
		
		System.out.print(result);
	}
}

class Point{
	int x;
	int y;
	Point(){};
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
