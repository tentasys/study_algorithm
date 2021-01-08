import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] arr1 = st.nextToken().toCharArray();
		char[] arr2 = st.nextToken().toCharArray();
		
		int A = arr1[0]-'0' + (arr1[1]-'0')*10 + (arr1[2]-'0')*100;
		int B = arr2[0]-'0' + (arr2[1]-'0')*10 + (arr2[2]-'0')*100;
		
		System.out.println(Math.max(A, B));
	}

}