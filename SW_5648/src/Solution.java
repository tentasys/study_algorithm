import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			int N = Integer.parseInt(br.readLine());
			ArrayList<Atom> list[] = new ArrayList[4];		//���⺰�� �����ؼ� ���ڸ� ������. 0123 �����¿�
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
			//���� �����̴� ���ڵ�
			for(Atom cur : list[0])
			{
				int min = Integer.MAX_VALUE;
				Atom check_down = null;
				Atom check_left = null;
				Atom check_right = null;
				
				//�Ʒ��� �����̴� ���� üũ
				for(Atom down : list[1])
				{
					if(down.crashed == true)	continue;
					
					if(cur.y < down.y && cur.x == down.x)	//���� ���ں��� ���� �ְ� x��ǥ�� �����ϸ� �浹
					{
						int temp = distance(cur, down);
						if(temp < min)		//���� ����� �� ã��
						{
							min = temp;
							check_down = down;
						}
					}
				}
				//�������� �����̴� ���� üũ
				for(Atom left : list[2])
				{
					if(left.crashed == true)	continue;
					
					if(cur.y < left.y && cur.x < left.x && (left.y-cur.y == left.x-cur.x))	//�ش� ��ǥ ������ �����ϰ� ���Ⱑ 1
					{
						int temp = distance(cur, left);
						if(temp < min)		//���� ����� �� ã��
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
				//���������� �����̴� ���� üũ
				for(Atom right : list[3])
				{
					if(right.crashed == true)	continue;
					
					if(cur.y < right.y && cur.x > right.x && (right.y-cur.y == (right.x-cur.x)*(-1)))	//�ش� ��ǥ ������ �����ϰ� ���Ⱑ 1
					{
						int temp = distance(cur, right);
						if(temp < min)		//���� ����� �� ã��
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
			//�Ʒ��� �����̴� ���ڵ�
			for(Atom cur : list[1])
			{
				int min = Integer.MAX_VALUE;
				Atom check_up = null;
				Atom check_left = null;
				Atom check_right = null;
				
				//���� �����̴� ���� üũ
				for(Atom up : list[0])
				{
					if(up.crashed == true)	continue;
					if(cur.y > up.y && cur.x == up.x)	//���� ���ں��� ���� �ְ� x��ǥ�� �����ϸ� �浹
					{
						int temp = distance(cur, up);
						if(temp < min)		//���� ����� �� ã��
						{
							min = temp;
							check_up = up;
						}
					}
				}
				//�������� �����̴� ���� üũ
				for(Atom left : list[2])
				{
					if(left.crashed == true)	continue;
					if(cur.y > left.y && cur.x < left.x && (left.y-cur.y == (left.x-cur.x)*(-1)))	
					{
						int temp = distance(cur, left);
						if(temp < min)		//���� ����� �� ã��
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
				//���������� �����̴� ���� üũ
				for(Atom right : list[3])
				{
					if(right.crashed == true)	continue;
					if(cur.y > right.y && cur.x > right.x && (right.y-cur.y == right.x-cur.x))
					{
						int temp = distance(cur, right);
						if(temp < min)		//���� ����� �� ã��
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
			//�������� �����̴� ���ڵ�
			for(Atom cur : list[2])
			{
				int min = Integer.MAX_VALUE;
				Atom check_up = null;
				Atom check_down = null;
				Atom check_right = null;
				
				//���� �����̴� ���� üũ
				for(Atom up : list[0])
				{
					if(up.crashed == true)	continue;
					if(cur.y > up.y && cur.x > up.x && (up.y-cur.y == up.x-cur.x))
					{
						int temp = distance(cur, up);
						if(temp < min)		//���� ����� �� ã��
						{
							min = temp;
							check_up = up;
						}
					}
				}
				//�Ʒ������� �����̴� ���� üũ
				for(Atom down : list[1])
				{
					if(down.crashed == true)	continue;
					if(cur.y < down.y && cur.x > down.x && (down.y-cur.y == (down.x-cur.x)*(-1)))	
					{
						int temp = distance(cur, down);
						if(temp < min)		//���� ����� �� ã��
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
				//���������� �����̴� ���� üũ
				for(Atom right : list[3])
				{
					if(right.crashed == true)	continue;
					if(cur.y == right.y && cur.x > right.x)
					{
						int temp = distance(cur, right);
						if(temp < min)		//���� ����� �� ã��
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
			//���������� �����̴� ���ڵ�
			for(Atom cur : list[3])
			{
				int min = Integer.MAX_VALUE;
				Atom check_up = null;
				Atom check_down = null;
				Atom check_left = null;
				
				//���� �����̴� ���� üũ
				for(Atom up : list[0])
				{
					if(up.crashed == true)	continue;
					if(cur.y > up.y && cur.x < up.x && (up.y-cur.y == (up.x-cur.x)*(-1)))
					{
						int temp = distance(cur, up);
						if(temp < min)		//���� ����� �� ã��
						{
							min = temp;
							check_up = up;
						}
					}
				}
				//�Ʒ������� �����̴� ���� üũ
				for(Atom down : list[1])
				{
					if(down.crashed == true)	continue;
					if(cur.y < down.y && cur.x < down.x && (down.y-cur.y == down.x-cur.x))	
					{
						int temp = distance(cur, down);
						if(temp < min)		//���� ����� �� ã��
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
				//�������� �����̴� ���� üũ
				for(Atom left : list[2])
				{
					if(left.crashed == true)	continue;
					if(cur.y == left.y && cur.x < left.x)
					{
						int temp = distance(cur, left);
						if(temp < min)		//���� ����� �� ã��
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