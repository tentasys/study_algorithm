import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int iii=0; iii<T; iii++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<Germ> list = new ArrayList<Germ>();
			
			for(int i=0; i<K; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				list.add(new Germ(x, y, num, dir));
			}
			
			for(int i=0; i<M; i++)
			{
				
				Germ matrix[][] = new Germ[N][N];
				int maxarr[][] = new int[N][N];
				
				ArrayList<Germ> del1 = new ArrayList<Germ>();
				
				for(int j=0; j<list.size(); j++)
				{
					Germ g = list.get(j);
					
					g.Move();

					if(matrix[g.x][g.y] == null)
					{
						matrix[g.x][g.y] = g;
						maxarr[g.x][g.y] = g.num;
					}
					else {
						if(g.num > maxarr[g.x][g.y])
						{
							int t = matrix[g.x][g.y].num;
							
							del1.add(matrix[g.x][g.y]);
							maxarr[g.x][g.y] = g.num;
							matrix[g.x][g.y] = g;
							g.num += t;
						}
						else
						{
							matrix[g.x][g.y].num += g.num;
							del1.add(g);
						}
					}
				}
				
				for(Germ g : del1)
				{
					list.remove(g);
				}
				
				ArrayList<Germ> del2 = new ArrayList<Germ>();
				for(int j=0; j<list.size(); j++)
				{
					Germ g = list.get(j);
					if(g.x == 0) {
						g.dir = 2;
						g.num /= 2;
					}
					else if(g.x == N-1) {
						g.dir = 1;
						g.num /= 2;
					}
					else if(g.y == 0) {
						g.dir = 4;
						g.num /= 2;
					}
					else if(g.y == N-1) {
						g.dir = 3;
						g.num /= 2;
					}
					
					if(g.num == 0)
						del2.add(g);
				}
				for(Germ g : del2)
				{
					list.remove(g);
				}
			}
			
			int sum = 0;
			for(Germ g : list) {
				sum += g.num;
			}
			
			System.out.println("#"+(iii+1)+" "+sum);
		}
	}
}

class Germ{
	int x;
	int y;
	int num;
	int dir;
	
	Germ(){};
	Germ(int x, int y, int num, int dir){
		this.x = x;
		this.y = y;
		this.num = num;
		this.dir = dir;
	};
	
	void Move(){
		if(dir == 1)		this.x--;
		else if(dir == 2) 	this.x++;
		else if(dir == 3) 	this.y--;
		else				this.y++;
	}
}
