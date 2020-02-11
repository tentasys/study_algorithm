import java.io.*;
import java.util.*;

public class Solution {

	static int map[][];
	static boolean visit[];
	static int min;
	static int N, H, W;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			visit = new boolean[W];
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<H; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0, map);
			
			System.out.println("#"+ii+" "+min);
		}
		
		br.close();
	}

	static void DFS(int count, int[][] arr)
	{
		if(count == N)
		{
			int bricks = 0;
			
			for(int i=0; i<H; i++)
			{
				for(int j=0; j<W; j++)
					if(arr[i][j] != 0)	bricks++;
			}
			
			min = Math.min(bricks, min);
//			System.out.println("Minimum :"+min);
			
			return;
		}
		for(int i=0; i<W; i++)
		{
			int[][] temp = crash(arr, i);
			DFS(count+1, temp);
		}
	}
	
	static int[][] crash(int[][] arr, int col)		//�ش� �ٿ� ���� �� �� ����
	{
//		System.out.println("crash column : "+ col);
		
		int[][] result = new int[H][W];
		//�迭 ����
		for(int i=0; i<H; i++)
			for(int j=0; j<W; j++)
				result[i][j] = arr[i][j];
		
		int start_row = H;
		
		for(int i=0; i<H; i++)
		{
			if(arr[i][col] != 0)
			{
				start_row = i;
				break;
			}
		}
		
		if(start_row == H)			return result;		//�� ������ �������� �� �迭 ����
		
		//�� ������ ���� �� ���� ����
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(start_row, col));
		
		while(!q.isEmpty())
		{
			Node cur = q.poll();
			int power = arr[cur.r][cur.c];	//������ ����
			result[cur.r][cur.c] = 0;
			
			//������
			for(int i=1; i<power; i++)
			{
				if(cur.r-i < 0)	break;		//���� �Ѿ�� Ż��
				if(result[cur.r-i][cur.c] > 1)	q.add(new Node(cur.r-i, cur.c));
				result[cur.r-i][cur.c] = 0;
				
			}
			//�Ʒ�����
			for(int i=1; i<power; i++)
			{
				if(cur.r+i >= H)	break;		//���� �Ѿ�� Ż��
				if(result[cur.r+i][cur.c] > 1)	q.add(new Node(cur.r+i, cur.c));
				result[cur.r+i][cur.c] = 0;
			}	
			//����
			for(int i=1; i<power; i++)
			{
				if(cur.c-i < 0)	break;		//���� �Ѿ�� Ż��
				if(result[cur.r][cur.c-i] > 1)	q.add(new Node(cur.r, cur.c-i));
				result[cur.r][cur.c-i] = 0;
			}
			//������
			for(int i=1; i<power; i++)
			{
				if(cur.c+i >= W)	break;		//���� �Ѿ�� Ż��
				if(result[cur.r][cur.c+i] > 1)	q.add(new Node(cur.r, cur.c+i));
				result[cur.r][cur.c+i] = 0;
			}
		}
		
		//����� ä���
		for(int i=0; i<W; i++)
		{
			int count = H-1;
			for(int j=H-1; j>=0; j--)
			{
				if(result[j][i] != 0)
				{
					result[count][i] = result[j][i];
					if(count != j)
						result[j][i] = 0;
					count--;
				}
					
			}
		}
		
//		//������
//		for(int i=0; i<H; i++)
//		{
//			for(int j=0; j<W; j++)
//				System.out.print(result[i][j]);
//			System.out.println();
//		}
//		System.out.println();
		return result;
	}
}

class Node{
	int r;	int c;		//�����¿� 0123
	Node(){};
	Node(int r, int c)
	{
		this.r = r;	this.c = c;
	}
}