import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[3][2];
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int x;	int y;
		
		if(arr[0][0] == arr[1][0])
			x = arr[2][0];
		else if(arr[0][0] == arr[2][0])
			x = arr[1][0];
		else
			x = arr[0][0];
		
		if(arr[0][1] == arr[1][1])
			y = arr[2][1];
		else if(arr[0][1] == arr[2][1])
			y = arr[1][1];
		else
			y = arr[0][1];
		
		System.out.println(x+" "+y);
		
	}
}