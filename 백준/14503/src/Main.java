import java.io.*;
import java.util.*;

//2�ð� 20��
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//ù°�� �Է¹ޱ�
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		
		//��°�� �Է¹ޱ�
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());		//0: ����, 1: ����, 2: ����, 3: ����
		
		//ĭ �ʱ�ȭ�ϱ�
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		while(true)
		{	
			if(arr[r][c] == 0)		//�����Ѱ� ���
			{
				arr[r][c] = -1;		//�����ڸ� û��
				count++;			//Ƚ�� ����
			}
			
			Point next = direction_point(r, c, (direction+3)%4);	//���� �� �� ã��
			
			if(arr[next.r][next.c] == 0)	//���� �� û���ؾ��Ѵ�
			{
				r = next.r;
				c = next.c;
				direction = (direction+3)%4;	//ȸ��
				continue;
			}
			
			int i;
			//���� ���� �� �� ���ٸ� ���� ȸ��
			for(i=0; i<3; i++)
			{
				direction = (direction+3)%4;	//�ϴ� ȸ��
				next = direction_point(r, c, (direction+3)%4);	//ȸ���� ������ ���� ã��
				
				if(arr[next.r][next.c] == 0)	//ȸ���� ������ ������ ��������� �̵�
				{
					r = next.r;
					c = next.c;
					direction = (direction+3)%4;	//�� �������� ȸ��
					break;
				}
			}
			
			//���� ȸ���� ������ ��
			if(i==3)
			{
				direction = (direction+3)%4;	//�ٶ󺸴� ���� �����·�	
				next = direction_point(r, c, ((direction+3)%4+3)%4);		//�޹��� ĭ ã��
				
				if(arr[next.r][next.c] == -1)	//���� �ƴ� ��� �̵�
				{
					r = next.r;
					c = next.c;
					continue;
				}
				else		//���ΰ�� Ż��
					break;
			}
		}
		
		System.out.print(count);
	}

	//���⺰ ����Ű�� ��
	static Point direction_point(int r, int c, int d)
	{
		Point result;
		
		if(d == 0)		//����
			result = new Point(r-1, c);
		else if(d == 1)	//����
			result = new Point(r, c+1);
		else if(d == 2)	//����
			result = new Point(r+1, c);
		else//(d == 3)	���� 
			result = new Point(r, c-1);
		
		return result;
	}
	
	static void PrintArr(int arr[][], int n, int m)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
}

class Point{
	int r;
	int c;
	Point(){};
	Point(int x, int y)
	{
		this.r = x;
		this.c = y;
	}
}
