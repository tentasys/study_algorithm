import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	//줄 입력 
			StringBuilder sb = new StringBuilder();						//결과 
			int c = Integer.parseInt(st.nextToken()); 					//몇번 반복할지 
			for(int ch : st.nextToken().getBytes()) {
				for(int j=0; j<c; j++) {
					sb.append((char)ch);
				}
			}
			System.out.println(sb);
			
			//string의 경우 tochararray를 통해 array화도 가능하다! 
		}
	}
}