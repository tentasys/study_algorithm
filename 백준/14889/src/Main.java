import java.util.*;
import java.io.*;

public class Main {
	
	static int S[][];			//능력치 정보 저장
	static int N;				//사람 수
	static boolean visit[];		//완전탐색을 위한 방문 여부를 체크할 배열
	static int min = Integer.MAX_VALUE;	//차이의 최소값을 체크할 변수

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//초기화 및 생성
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visit = new boolean[N];
		
		//입력 받기
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> start = new ArrayList<Integer>();
		DFS(0, 0, start);
		
		System.out.print(min);
		br.close();
	}

	//완전탐색 함수
	public static void DFS(int count, int idx, ArrayList<Integer> start)		//n이 N이 아닌 경우에 정상 작동
	{
		//합 구하기
		if(count == N/2)
		{
			ArrayList<Integer> link = new ArrayList<Integer>();		//링크팀 배열 생성
			
			//돌면서 스타트팀 아닌애들을 링크에다가 추가
			for(int i=0; i<N; i++)
			{
				if(visit[i] == false)
					link.add(i);
			}
			
			int start_sum = 0;
			int link_sum = 0;
			
			for(int i=0; i<start.size(); i++)
			{
				for(int j=i+1; j<start.size(); j++)
				{
					start_sum += S[start.get(i)][start.get(j)];
					start_sum += S[start.get(j)][start.get(i)];
					link_sum += S[link.get(i)][link.get(j)];
					link_sum += S[link.get(j)][link.get(i)];
				}
			}
			
			min = Math.min(min, Math.abs(start_sum-link_sum));
			return;
		}
		
		//조합 구하기
		for(int i=idx; i<N; i++)
		{
			if(visit[i] == false)
			{
				visit[i] = true;					//방문 체크
				start.add(i);						//스타트팀에 추가
				DFS(count+1, i+1, start);					//탐색
				start.remove(start.size()-1);
				visit[i] = false;
			}
		}

	}
}
