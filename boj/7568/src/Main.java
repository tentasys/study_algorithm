import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int person[][] = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int order[] = new int[N];
		for(int i=0; i<N; i++) {
			int count = 0;
			for(int j=0; j<N; j++) {
				if(i==j)	continue;
				
				if(person[i][0] < person[j][0] && person[i][1] < person[j][1])
					count++;
			}
			order[i] = count+1;
		}
		
		for(int i=0; i<N; i++)
			System.out.print(order[i]+" ");
	}
}