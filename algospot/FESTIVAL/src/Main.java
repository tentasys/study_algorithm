import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());	//테스트케이스 수
		
		for(int ii=0; ii<C; ii++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//공연장 대여 일
			int L = Integer.parseInt(st.nextToken());	//공연 팀 수
			
			//비용 입력
			st = new StringTokenizer(br.readLine());
			int cost[] = new int[N+1];
			
			//인덱스 1부터 넣는다
			for(int i=0; i<N; i++) {
				cost[i+1] = Integer.parseInt(st.nextToken());
			}
			
			double min = Double.MAX_VALUE;	//최대값
			//최소 대여일 : L, 최대 대여일 : N
			for(int i=L; i<=N; i++) {	//선택해야할 수
				for(int j=i; j<=N; j++) {	//내부 인덱스
					int tempsum = 0;
					for(int k=0; k<i; k++) {	//더하는 곳
//						System.out.print(cost[j-k]+" ");
						tempsum += cost[j-k];
					}
						
//					System.out.println();
					double tempret = (double)tempsum/i;
					if(min > tempret)
						min = tempret;
				}
			}
			System.out.println(min);
		}
		
		
		
	}

}
