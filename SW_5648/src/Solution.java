import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			int N = Integer.parseInt(br.readLine());
			ArrayList<Atom> list[] = new ArrayList[4];		//방향별로 구분해서 원자를 담을것. 0123 상하좌우
			for(int i=0; i<4; i++)
				list[i] = new ArrayList<Atom>();
			
			for(int i=0; i<N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken())*2);
				int y = (Integer.parseInt(st.nextToken())*2);
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken())
				
				list[dir].add(new Atom(x, y, energy));
			}
			
			int total = 0;
			//위로 움직이는 원자들
			for(Atom cur : list[0])
			{
				int min = Integer.MAX_VALUE;
				Atom check_down = null;
				Atom check_left = null;
				Atom check_right = null;
				
				//아래로 움직이는 원자 체크
				for(Atom down : list[1])
				{
					if(down.crashed == true)	continue;
					
					if(cur.y < down.y && cur.x == down.x)	//현재 원자보다 위에 있고 x좌표가 동일하면 충돌
					{
						int temp = distance(cur, down);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_down = down;
						}
					}
				}
				//왼쪽으로 움직이는 원자 체크
				for(Atom left : list[2])
				{
					if(left.crashed == true)	continue;
					
					if(cur.y < left.y && cur.x < left.x && (left.y-cur.y == left.x-cur.x))	//해당 좌표 조건을 만족하고 기울기가 1
					{
						int temp = distance(cur, left);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_down = null;
							check_left = left;
						}
						else if(temp == min)
						{
							check_left = left;
						}
					}
				}	
				//오른쪽으로 움직이는 원자 체크
				for(Atom right : list[3])
				{
					if(right.crashed == true)	continue;
					
					if(cur.y < right.y && cur.x > right.x && (right.y-cur.y == (right.x-cur.x)*(-1)))	//해당 좌표 조건을 만족하고 기울기가 1
					{
						int temp = distance(cur, right);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_down = null;
							check_left = null;
							check_right = right;
						}
						else if(temp == min)
						{
							check_right = right;
						}
					}
				}
				
				if(check_down != null || check_left != null || check_right != null)
				{
					total += cur.energy;
					cur.crashed = true;
				}		
				if(check_down != null)
				{
					total += check_down.energy;
					check_down.crashed = true;
				}
				if(check_left != null)
				{
					total += check_left.energy;
					check_left.crashed = true;
				}
				if(check_right != null)
				{
					total += check_right.energy;
					check_right.crashed = true;
				}
			}
			/////////////////////////////////////////////////////////////
			//아래로 움직이는 원자들
			for(Atom cur : list[1])
			{
				int min = Integer.MAX_VALUE;
				Atom check_up = null;
				Atom check_left = null;
				Atom check_right = null;
				
				//위로 움직이는 원자 체크
				for(Atom up : list[0])
				{
					if(up.crashed == true)	continue;
					if(cur.y > up.y && cur.x == up.x)	//현재 원자보다 위에 있고 x좌표가 동일하면 충돌
					{
						int temp = distance(cur, up);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = up;
						}
					}
				}
				//왼쪽으로 움직이는 원자 체크
				for(Atom left : list[2])
				{
					if(left.crashed == true)	continue;
					if(cur.y > left.y && cur.x < left.x && (left.y-cur.y == (left.x-cur.x)*(-1)))	
					{
						int temp = distance(cur, left);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = null;
							check_left = left;
						}
						else if(temp == min)
						{
							check_left = left;
						}
					}
				}	
				//오른쪽으로 움직이는 원자 체크
				for(Atom right : list[3])
				{
					if(right.crashed == true)	continue;
					if(cur.y > right.y && cur.x > right.x && (right.y-cur.y == right.x-cur.x))
					{
						int temp = distance(cur, right);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = null;
							check_left = null;
							check_right = right;
						}
						else if(temp == min)
						{
							check_right = right;
						}
					}
				}
				if(check_up != null || check_left != null || check_right != null)
				{
					total += cur.energy;
					cur.crashed = true;
				}		
				if(check_up != null)
				{
					total += check_up.energy;
					check_up.crashed = true;
				}
				if(check_left != null)
				{
					total += check_left.energy;
					check_left.crashed = true;
				}
				if(check_right != null)
				{
					total += check_right.energy;
					check_right.crashed = true;
				}
			}		
			///////////////////////////////////////////////////////////////////////////////
			//왼쪽으로 움직이는 원자들
			for(Atom cur : list[2])
			{
				int min = Integer.MAX_VALUE;
				Atom check_up = null;
				Atom check_down = null;
				Atom check_right = null;
				
				//위로 움직이는 원자 체크
				for(Atom up : list[0])
				{
					if(up.crashed == true)	continue;
					if(cur.y > up.y && cur.x > up.x && (up.y-cur.y == up.x-cur.x))
					{
						int temp = distance(cur, up);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = up;
						}
					}
				}
				//아래쪽으로 움직이는 원자 체크
				for(Atom down : list[1])
				{
					if(down.crashed == true)	continue;
					if(cur.y < down.y && cur.x > down.x && (down.y-cur.y == (down.x-cur.x)*(-1)))	
					{
						int temp = distance(cur, down);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = null;
							check_down = down;
						}
						else if(temp == min)
						{
							check_down = down;
						}
					}
				}	
				//오른쪽으로 움직이는 원자 체크
				for(Atom right : list[3])
				{
					if(right.crashed == true)	continue;
					if(cur.y == right.y && cur.x > right.x)
					{
						int temp = distance(cur, right);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = null;
							check_down = null;
							check_right = right;
						}
						else if(temp == min)
						{
							check_right = right;
						}
					}
				}
				if(check_up != null || check_down != null || check_right != null)
				{
					total += cur.energy;
					cur.crashed = true;
				}		
				if(check_up != null)
				{
					total += check_up.energy;
					check_up.crashed = true;
				}
				if(check_down != null)
				{
					total += check_down.energy;
					check_down.crashed = true;
				}
				if(check_right != null)
				{
					total += check_right.energy;
					check_right.crashed = true;
				}
			}					
			///////////////////////////////////////////////////////////////////
			//오른쪽으로 움직이는 원자들
			for(Atom cur : list[3])
			{
				int min = Integer.MAX_VALUE;
				Atom check_up = null;
				Atom check_down = null;
				Atom check_left = null;
				
				//위로 움직이는 원자 체크
				for(Atom up : list[0])
				{
					if(up.crashed == true)	continue;
					if(cur.y > up.y && cur.x < up.x && (up.y-cur.y == (up.x-cur.x)*(-1)))
					{
						int temp = distance(cur, up);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = up;
						}
					}
				}
				//아래쪽으로 움직이는 원자 체크
				for(Atom down : list[1])
				{
					if(down.crashed == true)	continue;
					if(cur.y < down.y && cur.x < down.x && (down.y-cur.y == down.x-cur.x))	
					{
						int temp = distance(cur, down);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = null;
							check_left = down;
						}
						else if(temp == min)
						{
							check_left = down;
						}
					}
				}	
				//왼쪽으로 움직이는 원자 체크
				for(Atom left : list[2])
				{
					if(left.crashed == true)	continue;
					if(cur.y == left.y && cur.x < left.x)
					{
						int temp = distance(cur, left);
						if(temp < min)		//가장 가까운 점 찾기
						{
							min = temp;
							check_up = null;
							check_down = null;
							check_left = left;
						}
						else if(temp == min)
						{
							check_left = left;
						}
					}
				}
				if(check_up != null || check_down != null || check_left != null)
				{
					total += cur.energy;
					cur.crashed = true;
				}		
				if(check_up != null)
				{
					total += check_up.energy;
					check_up.crashed = true;
				}
				if(check_down != null)
				{
					total += check_down.energy;
					check_down.crashed = true;
				}
				if(check_left != null)
				{
					total += check_left.energy;
					check_left.crashed = true;
				}
			}					
			
			System.out.println("#"+ii+" "+total);
		}
		
		br.close();
	}
	
	static int distance(Atom a1, Atom a2)
	{
		return Math.abs(a2.y-a1.y)+Math.abs(a2.x-a1.x);
	}
}

class Atom{
	int x;	int y;	int dir;	int energy;		boolean crashed;
	Atom(){};
	Atom(int x, int y, int energy)
	{
		this.x = x;	this.y = y;	this.energy = energy;	crashed = false;
	}
	Atom(int x, int y, int dir, int energy)
	{
		this.x = x;	this.y = y;	this.dir = dir;	this.energy = energy;
	}
}