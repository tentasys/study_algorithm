import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<str.length; i++) {
			list.add(str[i] - '0');
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length; i++) {
			sb.append(list.get(str.length-1-i));
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}
}