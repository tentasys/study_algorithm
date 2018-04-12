import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;
	static int w, h;
	static int matrix[][];
	static int dist[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		matrix = new int[w][h];
		dist = new int[w][h];
		
		int r_x = 0, r_y = 0;
		int b_x = 0, b_y = 0;
		int o_x = 0, o_y = 0;
		
		for(int i=0; i<h; i++)
		{
			String str = br.readLine();
			for(int j=0; j<w; j++)
			{
				switch(str.charAt(j))
				{
					case '#':	matrix[j][i] = 1;			break;
					case 'R':	r_y = i;	r_x = j;		break;
					case 'B':	b_y = i;	b_x = j; 		break;
					case 'O':	o_y = i;	o_x = j;		break;
				}
			}
		}
		
		f(r_x, r_y, b_x, b_y, o_x, o_y);
		
		if(dist[o_x][o_y] > 10 || dist[o_x][o_y] == 0)
			System.out.println("-1");
		else
			System.out.println(dist[o_x][o_y]);
	}

	static void f(int r_x, int r_y, int b_x, int b_y, int o_x, int o_y)
	{
		int red_arr[] = new int[4];
		int blue_arr[] = new int[4];

		for(int i=r_y-1; i>=0; i--)
			if(matrix[r_x][i] == 1)		{	red_arr[0] = i+1;	break;	}			//up
		for(int i=r_y+1; i<h; i++)
			if(matrix[r_x][i] == 1)		{	red_arr[1] = i-1;	break;	}			//down
		for(int i=r_x+1; i<w; i++)
			if(matrix[i][r_y] == 1)		{	red_arr[2] = i-1;	break;	}			//right
		for(int i=r_x-1; i>=0; i--)
			if(matrix[i][r_y] == 1)		{	red_arr[3] = i+1;	break;	}			//left
		for(int i=b_y-1; i>=0; i--)
			if(matrix[b_x][i] == 1)		{	blue_arr[0] = i+1;	break;	}	
		for(int i=b_y+1; i<h; i++)
			if(matrix[b_x][i] == 1)		{	blue_arr[1] = i-1;	break;	}
		for(int i=b_x+1; i<w; i++)
			if(matrix[i][b_y] == 1)		{	blue_arr[2] = i-1;	break;	}
		for(int i=b_x-1; i>=0; i--)
			if(matrix[i][b_y] == 1)		{	blue_arr[3] = i+1;	break;	}
		
		for(int i=0; i<2; i++)		//up & down	: move y
		{
			if((r_x == b_x) && (red_arr[i] == blue_arr[i]))
				continue;
			if(o_x == b_x)
			{
				if((i == 0) && (blue_arr[i] >= o_y))		continue;
				else if ((i == 1) && (blue_arr[i] <= o_y))	continue;
			}
			
			if(r_x == o_x)
			{
				if(((i == 0) && (red_arr[i] >= o_y)) || ((i == 1) && (red_arr[i] <= o_y)))
				{
					dist[o_x][o_y] = dist[r_x][r_y] + 1;
					return;
				}
			}
			
			dist[r_x][red_arr[i]] = dist[r_x][r_y] + 1;
			f(r_x, red_arr[i], b_x, blue_arr[i], o_x, o_y);
		}
		for(int i=2; i<4; i++)		//left & right	: move x
		{
			if((r_y == b_y) && (red_arr[i] == blue_arr[i]))
				continue;
			if(o_y == b_y)
			{
				if((i == 2) && (blue_arr[i] <= o_x))		continue;
				else if ((i == 3) && (blue_arr[i] >= o_x))	continue;
			}
			
			if(r_y == o_y)
			{
				if(((i == 2) && (red_arr[i] <= o_x)) || ((i == 3) && (red_arr[i] >= o_x)))
				{
					dist[o_x][o_y] = dist[r_x][r_y] + 1;
					return;
				}
			}
			
			dist[red_arr[i]][r_y] = dist[r_x][r_y] + 1;
			f(red_arr[i], r_y, blue_arr[i], b_y, o_x, o_y);
		}
	}
	
}