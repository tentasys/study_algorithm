import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int iiiii=0; iiiii<t; iiiii++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int matrix[][] = new int[n][n];
			boolean visit [][] = new boolean[n][n];
			int count = 0;
			boolean flag;
			
			for(int j=0; j<n; j++)
			{
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<n; i++)
					matrix[j][i] = Integer.parseInt(st.nextToken());
			}		
			
			//vertical
			for(int h=0; h<n; h++)
			{
				flag = true;
				
				for(int w=1; w<n; w++)
				{
					if(Math.abs(matrix[w][h]-matrix[w-1][h]) > 1)
					{
						flag = false;
						break;
					}
					else if(matrix[w][h]-matrix[w-1][h] == 1)
					{
						if(w-x < 0)
						{
							flag = false;
							break;
						}
						int num = matrix[w-1][h];
						for(int k=w-1; k>w-x-1; k--)
						{
							if((num != matrix[k][h]) || (visit[k][h] == true))
							{
								flag = false;
								break;
							}
							visit[k][h] = true;
						}
							
					}
					else if(matrix[w-1][h]-matrix[w][h] == 1)
					{
						if(w+x > n)
						{
							flag = false;
							break;
						}
						int num = matrix[w][h];
						for(int k=w; k<w+x; k++)
						{
							if((num != matrix[k][h]) || (visit[k][h] == true))
							{
								flag = false;
								break;
							}
							visit[k][h] = true;
						}		
					}
				}
				if(flag == true)
					count++;
			}
			
			for(int i=0; i<n; i++)
				Arrays.fill(visit[i], false);
			
			//horizontal
			for(int w=0; w<n; w++)
			{
				flag = true;
				
				for(int h=1; h<n; h++)
				{
					if(Math.abs(matrix[w][h]-matrix[w][h-1]) > 1)
					{
						flag = false;
						break;
					}
					else if(matrix[w][h]-matrix[w][h-1] == 1)
					{
						if(h-x < 0)
						{
							flag = false;
							break;
						}
						int num = matrix[w][h-1];
						for(int k=h-1; k>h-x-1; k--)
						{
							if((num != matrix[w][k]) || (visit[w][k] == true))
							{
								flag = false;
								break;
							}
							visit[w][k] = true;
						}
							
					}
					else if(matrix[w][h-1]-matrix[w][h] == 1)
					{
						if(h+x > n)
						{
							flag = false;
							break;
						}
						int num = matrix[w][h];
						for(int k=h; k<h+x; k++)
						{
							if((num != matrix[w][k]) || (visit[w][k] == true))
							{
								flag = false;
								break;
							}
							visit[w][k] = true;
						}
							
					}
				}
				if(flag == true)
					count++;
			}			
			System.out.println("#" + (iiiii+1) + " " + count);
		}
	}

}
