import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int ii=0; ii<T; ii++)
		{
			int k = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[4][8];
			for(int i=0; i<4; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			for(int i=0; i<k; i++)
			{
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
			
				boolean flag[] = new boolean[4];
				int wise[] = new int[4];
				
				switch(n)
				{
				case 1:
					flag[0] = true;		wise[0] = 1;
					if(arr[0][2] != arr[1][6])
					{
						flag[1] = true;	wise[1] = -1;
					}
					else	break;
					if(arr[1][2] != arr[2][6])
					{
						flag[2] = true;	wise[2] = 1;
					}
					else	break;
					if(arr[2][2] != arr[3][6])
					{
						flag[3] = true;	wise[3] = -1;
					}
					break;
				case 2:
					flag[1] = true;		wise[1] = 1;
					if(arr[0][2] != arr[1][6])
					{
						flag[0] = true;	wise[0] = -1;
					}
					if(arr[1][2] != arr[2][6])
					{
						flag[2] = true;	wise[2] = -1;
					}
					else	break;
					if(arr[2][2] != arr[3][6])
					{
						flag[3] = true;	wise[3] = 1;
					}
					break;
				case 3:
					flag[2] = true;		wise[2] = 1;
					if(arr[3][6] != arr[2][2])
					{
						flag[3]	= true;	wise[3] = -1;
					}
					if(arr[2][6] != arr[1][2])
					{
						flag[1] = true;	wise[1] = -1;
					}
					else	break;
					if(arr[1][6] != arr[0][2])
					{
						flag[0] = true;	wise[0] = 1;
					}
					break;
				case 4:
					flag[3] = true;		wise[3] = 1;
					if(arr[3][6] != arr[2][2])
					{
						flag[2] = true;	wise[2] = -1;
					}
					else	break;
					if(arr[2][6] != arr[1][2])
					{
						flag[1] = true;	wise[1] = 1;
					}
					else	break;
					if(arr[1][6] != arr[0][2])
					{
						flag[0] = true;	wise[0] = -1;
					}
					break;
				}
				
				for(int j=0; j<4; j++)
				{
					if(flag[j] == true)
						rotate(r*wise[j], arr[j]);
				}
			}
			
			int sum = arr[0][0]*1 + arr[1][0]*2 + arr[2][0]*4 + arr[3][0]*8;
			System.out.println("#" + (ii+1) + " " + sum);
		}
	}
	
	static void rotate(int r, int arr[])
	{
		if(r==1)
			clockwise(arr);
		else
			counter_clockwise(arr);
	}
	
	static void clockwise(int arr[])
	{
		int temp = arr[arr.length-1];
		for(int i=arr.length-1; i>0; i--)
			arr[i] = arr[i-1];
		arr[0] = temp;
	}
	
	static void counter_clockwise(int arr[])
	{
		int temp = arr[0];
		for(int i=0; i<arr.length-1; i++)
			arr[i] = arr[i+1];
		arr[arr.length-1] = temp;
	}

}