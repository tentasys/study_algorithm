import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = br.readLine().split(" ");
		int arr_int[] = new int[3];
		
		for(int i=0; i<3; i++) {
			arr_int[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(arr_int);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(arr_int[1]+"\n");
		bw.flush();
	}

}
