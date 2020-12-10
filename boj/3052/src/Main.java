import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mod[] = new int[42];
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			mod[n%42]++;
		}
		
		int result = 0;
		for(int a : mod) {
			if(a != 0)	result++;
		}
		
		System.out.println(result);
	}
}