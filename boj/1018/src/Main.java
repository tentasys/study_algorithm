import java.io.*;
import java.util.*;

public class Main {

	public static int min = Integer.MAX_VALUE;
	
	//0번은 흰색 시작 정답 배열, 1번은 검은색 시작 정답 배열 
	public static int colored_arr[][][] = {
			{
				{0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}
			},
			{
				{1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}
			}
	};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//배열 초기화 
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			char str[] = br.readLine().toCharArray(); 
			for(int j=0; j<M; j++) {
				if(str[j] == 'W')	arr[i][j] = 0;
				else				arr[i][j] = 1;
			}		
		}
		
		//8*8로 잘라서 비교하기 
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				cal(i, j, i+8, j+8, arr, 0);
				cal(i, j, i+8, j+8, arr, 1);
			}
		}
		
		//결과 출력 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(min+"\n");
		bw.flush();
	}

	//정답 배열과 비교해서 틀리면 개수 세기 
	public static void cal(int start_r, int start_c, int end_r, int end_c, int arr[][], int color) {
		int count = 0;
		for(int i=start_r, r=0; i<end_r; i++, r++) {
			for(int j=start_c, c=0; j<end_c; j++, c++) {
				if(arr[i][j] != colored_arr[color][r][c])		count++;
				if(count > Math.min(min, count))				return;		//최소값을 넘어버리면 비교할 필요가 없음 
			}
		}
		
		min = Math.min(min, count);
	}
}