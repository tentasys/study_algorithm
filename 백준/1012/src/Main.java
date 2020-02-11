import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean visit[][], matrix[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//initialize 
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			visit = new boolean[w+1][h+1];
			matrix = new boolean[w+1][h+1];
			
			int count = 0;
			
			for(int j=0; j<k; j++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				matrix[x][y] = true;
			}
			
			for(int j=0; j<=w; j++)
			{
				for(int l=0; l<=h; l++)
					if(visit[j][l] == false && matrix[j][l] == true)
					{
						f(j, l, w, h);
						count++;
					}
			}
			
			System.out.println(count);
		}
	}
	
	static public void f(int x, int y, int w, int h) {
		if(matrix[x][y] == false || visit[x][y] == true)
			return;
		
		visit[x][y] = true;
		
		if(y-1>=0)	f(x, y-1, w, h);
		if(x-1>=0)	f(x-1, y, w, h);
		if(y+1<=h)	f(x, y+1, w, h);
		if(x+1<=w)	f(x+1, y, w, h);	
	}
}