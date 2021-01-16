import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		
		int max_len = Math.max(A.length, B.length);
		char[] str_a = new char[max_len];
		char[] str_b = new char[max_len];
		
		int idx_a = 0;
		int idx_b = 0;
		
		for(int i=0; i<max_len; i++) {
			if(max_len-i > A.length)
				str_a[i] = '0';
			else
				str_a[i] = A[idx_a++];
			
			if(max_len-i > B.length)
				str_b[i] = '0';
			else
				str_b[i] = B[idx_b++];
		}
		
		char[] sum = new char[max_len];
		boolean flag = false;
		
		for(int i=0; i<max_len; i++) {
			int temp = 0;
			
			if(flag == true)
				temp = 1;
			else
				temp = 0;
			
			temp += (str_a[max_len-i-1]-'0') + (str_b[max_len-i-1]-'0');
			if(temp >= 10)
			{
				flag = true;
				sum[max_len-i-1] = (char)(temp%10 + '0');
			}
			else {
				flag = false;
				sum[max_len-i-1] = (char)(temp + '0');
			}
		}
		
		if(flag == true)
			System.out.print(1);
		for(int i=0; i<max_len; i++)
			System.out.print(sum[i]);
	}

}
