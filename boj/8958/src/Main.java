import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {

			int score = 0;
			int cur = 0;
			int count = 1;
			boolean flag = false;
			
			for(int ch : br.readLine().getBytes()) {
				if(ch == 'O') {
					cur += count++;
					flag = true;
				} 
				//X일때 - 모든 값 초기화 
				else {
					score += cur;
					count = 1;
					cur = 0;
					flag = false;
				}
			}
			
			//X일 때만 값을 더해주는데 마지막이 O로 끝난 경우 값을 안더해주므로 해당 경우 처리 
			if(flag == true)	score += cur;
			
			System.out.println(score);
		}
		
	}
}