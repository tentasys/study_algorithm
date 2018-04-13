import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
		//-----setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int matrix[][] = new int[w][h];
		int dist[][] = new int[w][h];
		
		c bid = new c();

		int o_x = 0, o_y = 0;
		
		
		
		for(int i=0; i<h; i++)
		{
			String str = br.readLine();
			for(int j=0; j<w; j++)
			{
				switch(str.charAt(j))
				{
					case '#':	matrix[j][i] = 1;					break;
					case 'R':	bid.r_y = i;	bid.r_x = j;		break;
					case 'B':	bid.b_y = i;	bid.b_x = j; 		break;
					case 'O':	o_y = i;	o_x = j;				break;
				}
			}
		}
	
		
		dist[o_x][o_y] = Integer.MAX_VALUE;
		//----end setting

		//----searching	
		c arr[] = new c[4];
		Queue<c> q = new LinkedList<c>();
		
		q.offer(bid);
		
		while(!q.isEmpty())
		{
			c temp = q.poll();
			for(int i=0; i<4; i++)
			{
				arr[i] = new c(temp.r_x, temp.r_y, temp.b_x, temp.b_y);
			}
				
			for(int i=temp.r_y-1; i>=0; i--)
				if(matrix[temp.r_x][i] == 1)		{	arr[0].r_y = i+1;	break;	}			//up		
			for(int i=temp.r_y+1; i<h; i++)
				if(matrix[temp.r_x][i] == 1)		{	arr[1].r_y = i-1;	break;	}			//down	
			for(int i=temp.r_x+1; i<w; i++)
				if(matrix[i][temp.r_y] == 1)		{	arr[2].r_x = i-1;	break;	}			//right		
			for(int i=temp.r_x-1; i>=0; i--)
				if(matrix[i][temp.r_y] == 1)		{	arr[3].r_x = i+1;	break;	}			//left			
			for(int i=temp.b_y-1; i>=0; i--)
				if(matrix[temp.b_x][i] == 1)		{	arr[0].b_y = i+1;	break;	}			//up	
			for(int i=temp.b_y+1; i<h; i++)
				if(matrix[temp.b_x][i] == 1)		{	arr[1].b_y = i-1;	break;	}			//down
			for(int i=temp.b_x+1; i<w; i++)
				if(matrix[i][temp.b_y] == 1)		{	arr[2].b_x = i-1;	break;	}			//right
			for(int i=temp.b_x-1; i>=0; i--)
				if(matrix[i][temp.b_y] == 1)		{	arr[3].b_x = i+1;	break;	}			//left
			
			for(int i=0; i<2; i++)		//up & down	: move y
			{
				if((temp.r_x == temp.b_x) && (arr[i].r_y == arr[i].b_y))
					continue;
				if(o_x == temp.b_x)
				{
					if((i == 0) && (arr[i].b_y >= o_y))		continue;
					else if ((i == 1) && (arr[i].b_y <= o_y))	continue;
				}
				
				if(temp.r_x == o_x)
				{
					if(((i == 0) && (arr[i].r_y <= o_y) && (o_y <= temp.r_y)) || ((i == 1) && (arr[i].r_y >= o_y)) && (o_y >= temp.r_y))
					{
						if(dist[o_x][o_y] > dist[arr[i].r_x][arr[i].r_y] + 1)
							dist[o_x][o_y] = dist[arr[i].r_x][arr[i].r_y] + 1;
					}
				}
				
				if(dist[arr[i].r_x][arr[i].r_y] == 0)
				{
					q.offer(arr[i]);
					if(arr[i].r_y != temp.r_y)
						dist[arr[i].r_x][arr[i].r_y] = dist[temp.r_x][temp.r_y] + 1;
				}
				
			}
			for(int i=2; i<4; i++)		//left & right	: move x
			{
				if((temp.r_y == temp.b_y) && (arr[i].r_x == arr[i].b_x))
					continue;
				if(o_y == temp.b_y)
				{
					if((i == 2) && (arr[i].b_x <= o_x))		continue;
					else if ((i == 3) && (arr[i].b_x >= o_x))	continue;
				}
				
				if(temp.r_y == o_y)
				{
					if(((i == 2) && (arr[i].r_x >= o_x)) && (o_x >= temp.r_x) || ((i == 3) && (arr[i].r_x <= o_x) &&(o_x <= temp.r_x)))
					{
						if(dist[o_x][o_y] > dist[arr[i].r_x][arr[i].r_y] + 1)
							dist[o_x][o_y] = dist[arr[i].r_x][arr[i].r_y] + 1;
					}
				}
				
				if(dist[arr[i].r_x][temp.r_y] == 0)
				{
					q.offer(arr[i]);
					if(arr[i].r_x != temp.r_x)
						dist[arr[i].r_x][temp.r_y] = dist[temp.r_x][temp.r_y] + 1;
				}	
			}
		}
		
		
		
		//--------------------------------------------------------
		if(dist[o_x][o_y] > 10 || dist[o_x][o_y] == 0)
			System.out.println("-1");
		else
			System.out.println(dist[o_x][o_y]);
	}
	
}

class c{
	int r_x;
	int r_y;
	int b_x;
	int b_y;

	c(){
		
	}
	c(int a, int b, int c, int d){
		this.r_x = a;
		this.r_y = b;
		this.b_x = c;
		this.b_y = d;
	}

}