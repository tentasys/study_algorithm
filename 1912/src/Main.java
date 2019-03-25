import java.util.*;
//https://www.acmicpc.net/problem/1912
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)			//배열에 값넣기
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;		//합의 최대값
		
		for(int i=0; i<N; i++)
		{	
			int S = arr[i];
			
			for(int j=i+1; j<N; j++)	//선택한 인덱스(i) 뒤로 연속하는 수 합해가기
			{
				if(S+arr[j] < S)	break;
				S += arr[j];
				j++;
			}
		}
		
		System.out.print(max);
	}

}
