import java.util.*;
import java.io.*;

public class Main {

	static HashMap<String, ArrayList<Atom>> map;	//key: x,c, value: 원자
	static int atomic_counter;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			//----입력 시작
			int N = Integer.parseInt(br.readLine());		
			map = new HashMap<String, ArrayList<Atom>>();
			
			for(int i=0; i<N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				Atom atom = new Atom(dir, energy);		//원자 생성
				
				ArrayList<Atom> new_list = new ArrayList<Atom>();	//해시맵에 추가하기 위함
				new_list.add(atom);
				map.put(x+","+y, new_list);				//해시맵에 넣기
				
				atomic_counter++;			//해시맵 종료 조건 카운터
			}
			//----입력 끝
			
			System.out.println("#"+ii+" "+Crash());	//TC 결과 출력
		}
	}
	
	//충돌
	static int Crash()
	{
		int result = 0;
			
		while(atomic_counter > 0)		//원자가 존재할 동안
		{
			boolean crash_flag = false;			//충돌 여부 플래그. 있으면 충돌함
			HashMap<String, ArrayList<Atom>> temp_map = new HashMap<String, ArrayList<Atom>>();			//갈아끼울 맵
			//사라질 조건을 정해 놓고 한꺼번에 처리한다
			for(String key : map.keySet())
			{
//				System.out.println(key);
				
				ArrayList<Atom> togetAtom = map.get(key);	//리스트 받아옴 어차피 첫요소만 쓸거라서
				Atom atom = togetAtom.get(0);	//원자 받아옴
				
				if(atom.alive == false)		//이미 죽었으면 굳이 돌 필요는 없음
					continue;
				
				//key에서 원자의 x좌표와 y좌표를 받아옴
				StringTokenizer st = new StringTokenizer(key);
				int x = Integer.parseInt(st.nextToken(", "));
				int y = Integer.parseInt(st.nextToken(", "));			
				
				//이 원자가 이동할 위치
				int nX = next_x(atom.dir, x);
				int nY = next_y(atom.dir, y);
				
				/////////////////////////////////////////////////////////////////////
				
				//조건 1 : 좌표의 절대값이 1001 이상이면 무조건 살아남은 것 == 에너지 방출 없이 죽는다
				if(Math.abs(nX) > 1000 || Math.abs(nY) > 1000)
				{
					atom.alive = false;
					atomic_counter--;
					continue;
				}
				
				//조건 2 : 이동 후 위치에 나와 반대방향의 원자가 존재한다
				if(map.containsKey(nX+","+nY))	//이동후 위치에 누군가가 존재한다
				{
					Atom other = map.get(nX+","+nY).get(0);	//그 위치의 원자 가져오기
					if(isCounter(atom, other) == true)	//서로 반대방향이면
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
						
						continue;	//충돌하면 for문 빠져나감
					}
				}//존재해도 충돌하지 않으면 아래꺼 수행
				
				String temp_key = nX+","+nY;		//새로 이동한 위치를 키값으로 함
				
				if(temp_map.containsKey(temp_key) == false)		//키값이 없다면 새로 넣기
				{
					ArrayList<Atom> add_list = new ArrayList<Atom>();
					add_list.add(atom);
					temp_map.put(temp_key, add_list);
				}
				//조건 3 : 이동 후 위치에 다른 원자들이 도착할 예정이다
				else			//키값이 있으면 해당하는 리스트 뒤에 붙이기
				{
					temp_map.get(temp_key).add(atom);
					crash_flag = true;
				}		
			}
			
			//죽은 리스트에 있는 원자들을 소멸시킨다 = 살아있는 원자만 남긴다
			if(crash_flag == false)		//충돌난게 없으면 일단 빨리 넘어가야 함
				map = temp_map;
			else
			{
				map = new HashMap<String, ArrayList<Atom>>();
				for(String key : temp_map.keySet())
				{
					if(temp_map.get(key).size() >1)		//해시맵 내부 리스트 사이즈가 1보다 크면 충돌이 일어난 것이다
					{
						for(Atom a : temp_map.get(key))
						{
							result += a.energy;
							atomic_counter--;
						}
					}
					else		//그렇지 않으면 충돌이 없다
					{
						Atom add_atom = temp_map.get(key).get(0);		//임시배열에서 원자 가져옴
						ArrayList<Atom> no_more_temp = new ArrayList<Atom>();	//링크드리스트 추가해야함
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
		if(dir == 0 || dir == 1)	//상하
			return x;
		else if(dir == 2)			//좌
			return x-1;
		else						//우
			return x+1;
	}
	static int next_y(int dir, int y)
	{
		if(dir == 0)				//상
			return y+1;
		else if(dir == 1)			//하
			return y-1;
		else						//좌우
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