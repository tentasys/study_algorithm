import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//밭 크기
		int M = Integer.parseInt(st.nextToken());	//초기 나무 수
		int K = Integer.parseInt(st.nextToken());	//년 수
		
		int A[][] = new int[N][N];			//고정된 양분
		int map[][] = new int[N][N];		//나무가 먹을것
		
		//양분 입력받기
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			Arrays.fill(map[i], 5); 		//양분은 처음에 5로 초기화되어있다
			
			for(int j=0; j<N; j++)			//고정양분 입력
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//나무 입력받기
		ArrayList<Tree> temp_list = new ArrayList<Tree>();
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());

			int temp_r = Integer.parseInt(st.nextToken())-1;
			int temp_c = Integer.parseInt(st.nextToken())-1;
			int temp_age = Integer.parseInt(st.nextToken());
			
			temp_list.add(new Tree(temp_r, temp_c, temp_age));
		}
		//----입력 끝	
		
		//나이순 정렬
		Collections.sort(temp_list, new Ascending());
		
		Deque<Tree> list = new LinkedList<Tree>();		//덱
		for(Tree t : temp_list)
		{
			list.addLast(t);
		}
		
		//시뮬레이션 시작
		int years = 0;
		while(years < K)
		{	
			Deque<Tree> next_list = new LinkedList<Tree>();		//나중에 복사하기 위함
			Queue<Tree> drop_list = new LinkedList<Tree>();
			
			//봄
			while(!list.isEmpty())
			{
				Tree temp = list.pollFirst();	//가장 어린나무 빼기
				
				if(map[temp.r][temp.c] < temp.age)		//현재 땅의 양분이 나이보다 적다면
				{
					drop_list.add(temp);	//버릴 리스트에 넣자
				}
				else
				{
					map[temp.r][temp.c] -= temp.age;	//양분 감소
					temp.age++;
					next_list.addLast(temp); 			//트리 리스트에 추가
				}
			}
			////////////////////////////////////////////////////////////////////////////////////
			//여름
			while(!drop_list.isEmpty())
			{
				Tree temp = drop_list.poll();		//꺼내기	
				map[temp.r][temp.c] += temp.age/2;	//양분 추가
			}
			
			////////////////////////////////////////////////////////////////////////////////////
			//가을
			
			int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
			int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};

			while(!next_list.isEmpty())
			{
				Tree cur = next_list.pollFirst();
				
				if(cur.age %5 == 0)	//5의 배수이면 번식
				{
					for(int j=0; j<8; j++)	//8방향으로 번식
					{
						int dest_r = cur.r+dr[j];
						int dest_c = cur.c+dc[j];
						
						if(dest_r < 0 || dest_c < 0 || dest_r >= N || dest_c >= N)
							continue;
						
						list.addFirst(new Tree(dest_r, dest_c, 1));		//나무 추가
					}
				}
				
				list.addLast(cur); 		//그냥 나무는 맨뒤에다가 넣는다
 			}
			
			////////////////////////////////////////////////////////////////////////////////////
			//겨울
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
					map[i][j] += A[i][j];		//지도에 양분 추가
			}
			
			years++;
		}
		
		System.out.println(list.size());
	}

}

class Tree implements Comparable<Tree>{
	int r;	int c;	int age;
	Tree(){};
	Tree(int r, int c, int age)
	{
		this.r = r;	this.c = c;	this.age = age;
	}
	
	@Override
	public int compareTo(Tree o)
	{
		return this.age-o.age;
	}
}

//나이순으로 정렬
class Ascending implements Comparator<Tree>{

	@Override
	public int compare(Tree arg0, Tree arg1) {
		return arg0.compareTo(arg1);
	}
}