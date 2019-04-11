import java.util.*;
import java.io.*;

public class Main {

	static HashMap<String, ArrayList<Atom>> map;	//key: x,c, value: ����
	static int atomic_counter;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			//----�Է� ����
			int N = Integer.parseInt(br.readLine());		
			map = new HashMap<String, ArrayList<Atom>>();
			
			for(int i=0; i<N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				Atom atom = new Atom(dir, energy);		//���� ����
				
				ArrayList<Atom> new_list = new ArrayList<Atom>();	//�ؽøʿ� �߰��ϱ� ����
				new_list.add(atom);
				map.put(x+","+y, new_list);				//�ؽøʿ� �ֱ�
				
				atomic_counter++;			//�ؽø� ���� ���� ī����
			}
			//----�Է� ��
			
			System.out.println("#"+ii+" "+Crash());	//TC ��� ���
		}
	}
	
	//�浹
	static int Crash()
	{
		int result = 0;
			
		while(atomic_counter > 0)		//���ڰ� ������ ����
		{
			boolean crash_flag = false;			//�浹 ���� �÷���. ������ �浹��
			HashMap<String, ArrayList<Atom>> temp_map = new HashMap<String, ArrayList<Atom>>();			//���Ƴ��� ��
			//����� ������ ���� ���� �Ѳ����� ó���Ѵ�
			for(String key : map.keySet())
			{
//				System.out.println(key);
				
				ArrayList<Atom> togetAtom = map.get(key);	//����Ʈ �޾ƿ� ������ ù��Ҹ� ���Ŷ�
				Atom atom = togetAtom.get(0);	//���� �޾ƿ�
				
				if(atom.alive == false)		//�̹� �׾����� ���� �� �ʿ�� ����
					continue;
				
				//key���� ������ x��ǥ�� y��ǥ�� �޾ƿ�
				StringTokenizer st = new StringTokenizer(key);
				int x = Integer.parseInt(st.nextToken(", "));
				int y = Integer.parseInt(st.nextToken(", "));			
				
				//�� ���ڰ� �̵��� ��ġ
				int nX = next_x(atom.dir, x);
				int nY = next_y(atom.dir, y);
				
				/////////////////////////////////////////////////////////////////////
				
				//���� 1 : ��ǥ�� ���밪�� 1001 �̻��̸� ������ ��Ƴ��� �� == ������ ���� ���� �״´�
				if(Math.abs(nX) > 1000 || Math.abs(nY) > 1000)
				{
					atom.alive = false;
					atomic_counter--;
					continue;
				}
				
				//���� 2 : �̵� �� ��ġ�� ���� �ݴ������ ���ڰ� �����Ѵ�
				if(map.containsKey(nX+","+nY))	//�̵��� ��ġ�� �������� �����Ѵ�
				{
					Atom other = map.get(nX+","+nY).get(0);	//�� ��ġ�� ���� ��������
					if(isCounter(atom, other) == true)	//���� �ݴ�����̸�
					{
						if(atom.alive == true)
						{
							result += atom.energy;
							atom.alive = false;
							atomic_counter--;
						}
						if(other.alive == true)
						{
							result += other.energy;
							other.alive = false;
							atomic_counter--;
						}
						
						continue;	//�浹�ϸ� for�� ��������
					}
				}//�����ص� �浹���� ������ �Ʒ��� ����
				
				String temp_key = nX+","+nY;		//���� �̵��� ��ġ�� Ű������ ��
				
				if(temp_map.containsKey(temp_key) == false)		//Ű���� ���ٸ� ���� �ֱ�
				{
					ArrayList<Atom> add_list = new ArrayList<Atom>();
					add_list.add(atom);
					temp_map.put(temp_key, add_list);
				}
				//���� 3 : �̵� �� ��ġ�� �ٸ� ���ڵ��� ������ �����̴�
				else			//Ű���� ������ �ش��ϴ� ����Ʈ �ڿ� ���̱�
				{
					temp_map.get(temp_key).add(atom);
					crash_flag = true;
				}		
			}
			
			//���� ����Ʈ�� �ִ� ���ڵ��� �Ҹ��Ų�� = ����ִ� ���ڸ� �����
			if(crash_flag == false)		//�浹���� ������ �ϴ� ���� �Ѿ�� ��
				map = temp_map;
			else
			{
				map = new HashMap<String, ArrayList<Atom>>();
				for(String key : temp_map.keySet())
				{
					if(temp_map.get(key).size() >1)		//�ؽø� ���� ����Ʈ ����� 1���� ũ�� �浹�� �Ͼ ���̴�
					{
						for(Atom a : temp_map.get(key))
						{
							result += a.energy;
							atomic_counter--;
						}
					}
					else		//�׷��� ������ �浹�� ����
					{
						Atom add_atom = temp_map.get(key).get(0);		//�ӽù迭���� ���� ������
						ArrayList<Atom> no_more_temp = new ArrayList<Atom>();	//��ũ�帮��Ʈ �߰��ؾ���
						no_more_temp.add(add_atom);
						map.put(key, no_more_temp);
					}
				}
			}
	
		}
		
		return result;
	}
	
	static int next_x(int dir, int x)
	{
		if(dir == 0 || dir == 1)	//����
			return x;
		else if(dir == 2)			//��
			return x-1;
		else						//��
			return x+1;
	}
	static int next_y(int dir, int y)
	{
		if(dir == 0)				//��
			return y+1;
		else if(dir == 1)			//��
			return y-1;
		else						//�¿�
			return y;
	}
	static boolean isCounter(Atom a, Atom b)
	{
		if((a.dir==0 && b.dir==1) || (a.dir==1 && b.dir==0) || (a.dir==2 && b.dir==3) || (a.dir==3 && b.dir==2))
			return true;
		else
			return false;
	}
}

class Atom{
	int dir;
	int energy;
	boolean alive;
	
	Atom(){};
	Atom(int dir, int energy)
	{
		this.dir = dir;		this.energy = energy; 	alive = true;
	}
}