import java.util.*;
import java.io.*;

public class Main {

	static int N, M, D;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int enemy[] = new int[M];	//행별 적의 수
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1)	enemy[j]++;
			}
		}
		
		max = Integer.MIN_VALUE;
		
		Combination(enemy, new int[3], 0, 0);
		System.out.println(max);
		
		br.close();
	}

	public static void Combination(int[] enemy, int[] arr, int idx, int count) {
		if(count == 3)
		{
			boolean clear[] = new boolean[M];	//적들이 다 죽었는지 확인
			int sum = 0;
			
			for(int i=0; i<3; i++)
			{
				int cur = arr[i];
				//고른 열에 있는 적은 무조건 죽일 수 있다
				if(clear[cur] == false)
				{
					sum += enemy[cur];
					clear[cur] = true;
				}
				
				//좌우로 D-1거리만큼을 체크
				//좌
				for(int j=cur-1; j>cur-D; j--)
				{
					if(j < 0)	break;		//바운더리
					if(clear[j] == true)	continue;	//체크한데는 재방문 안함
					
					clear[j] = true;
					sum += enemy[j];
				}
				
				//우
				for(int j=cur+1; j<cur+D; j++)
				{
					if(j >= M)	break;		//바운더리
					if(clear[j] == true)	continue;	//체크한데는 재방문 안함
					
					clear[j] = true;
					sum += enemy[j];
				}
			}
			
			max = Math.max(max, sum);
			
			return;
		}
		for(int i=idx; i<M; i++)
		{
			arr[count] = i;
			Combination(enemy, arr, i+1, count+1);
		}
	}
}
