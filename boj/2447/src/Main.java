import java.io.*;
public class Main {

	public static char star[][] = new char[3000][3000]; 
	public static void main(String[] args) throws Exception{
		//배열 초기화 
		for(int i=0; i<star.length; i++) {
			for(int j=0; j<star.length; j++)
				star[i][j] = ' ';
		}
		
		//입력 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		makeStar(N, 0, 0);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sb.append(star[i][j]);
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}

	//별을 배열에 찍는 함수 
	public static void makeStar(int N, int r, int c) {
		if(N == 3) {
			star[r][c] = '*';
			star[r][c+1] = '*';
			star[r][c+2] = '*';
			
			star[r+1][c] = '*';
			star[r+1][c+2] = '*';
			
			star[r+2][c] = '*';
			star[r+2][c+1] = '*';
			star[r+2][c+2] = '*';
		}
		else {
			makeStar(N/3, r, c);
			makeStar(N/3, r, c+N/3);
			makeStar(N/3, r, c+N/3+N/3);
			
			makeStar(N/3, r+N/3, c);
			makeStar(N/3, r+N/3, c+N/3+N/3);
			
			makeStar(N/3, r+N/3+N/3, c);
			makeStar(N/3, r+N/3+N/3, c+N/3);
			makeStar(N/3, r+N/3+N/3, c+N/3+N/3);
		}
	}
}