import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			Person person1[] = new Person[M+1];
			Person person2[] = new Person[M+1];
			
			person1[0] = new Person(1, 1);
			person2[0] = new Person(10, 10);
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++)
			{
				int dir = Integer.parseInt(st.nextToken());
				int x, y;
				if(dir == 1)	//╩С
				{
					x = person1[i-1].x;
					y = person1[i-1].y-1;
				}
				else if(dir == 2)//©Л
				{
					x = person1[i-1].x+1;
					y = person1[i-1].y;
				}
				else if(dir == 3)//го
				{
					x = person1[i-1].x;
					y = person1[i-1].y+1;
				}
				else if(dir == 4)//аб
				{
					x = person1[i-1].x-1;
					y = person1[i-1].y;
				}
				else	//(dir == 0)
				{
					x = person1[i-1].x;
					y = person1[i-1].y;
				}
				person1[i] = new Person(x, y);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++)
			{
				int dir = Integer.parseInt(st.nextToken());
				int x, y;
				if(dir == 1)	//╩С
				{
					x = person2[i-1].x;
					y = person2[i-1].y-1;
				}
				else if(dir == 2)//©Л
				{
					x = person2[i-1].x+1;
					y = person2[i-1].y;
				}
				else if(dir == 3)//го
				{
					x = person2[i-1].x;
					y = person2[i-1].y+1;
				}
				else if(dir == 4)//аб
				{
					x = person2[i-1].x-1;
					y = person2[i-1].y;
				}
				else	//(dir == 0)
				{
					x = person2[i-1].x;
					y = person2[i-1].y;
				}
				person2[i] = new Person(x, y);
			}
			
			int matrix[][][] = new int[A][11][11];
			for(int i=0; i<A; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				for(int j=1; j<11; j++)
				{
					for(int k=1; k<11; k++)
					{
						int x_dist = Math.abs(x-k);
						int y_dist = Math.abs(y-j);
						if(x_dist+y_dist <= c)
							matrix[i][k][j] = p;	
					}
				}
			}
			
			int sum = 0;
			
			for(int i=0; i<=M; i++)
			{
				int val1, val2;
				int max = 0;
				
				for(int j=0; j<A; j++)
				{
					int temp = 0;
					val1 = matrix[j][person1[i].x][person1[i].y];
					
					for(int k=0; k<A; k++)
					{
						val2 = matrix[k][person2[i].x][person2[i].y];
						temp = val1+val2;
						if(j==k && (val1!=0)&&(val2!=0))	temp/=2;
						if(temp > max)	max = temp;
					}
				}			
				sum += max;
			}
			
			System.out.println("#"+ii+" "+sum);
		}
	}

}

class Person{
	int x;
	int y;
	Person(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
