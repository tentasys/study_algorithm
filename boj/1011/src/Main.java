import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long T = Long.parseLong(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int sub = y-x;	//목표 거리 
			int n = 0;		//이동 횟수 n 
			int dist = 0;	//n번 이동했을 때 갈 수 있는 최대 거리 
			
			//목표 거리가 n번 이동했을 때 갈 수 있는 최대 거리에 해당하는 시점을 찾으면 된다 
			while(dist < sub) {
				n++;
				
				//일반항은 노가다로 찾음....
				//홀수일 때 : ((n+1)/2)^2 
				if(n%2 == 1) {
					dist = ((n+1)/2) * ((n+1)/2);
				}
				//짝수일 때 ; ((n+2)/2)^2 - (n+2)/2
				else {
					dist = ((n+2)/2)*((n+2)/2) - ((n+2)/2);
				}
				
			}
			
			System.out.println(n);
		}
	}

}