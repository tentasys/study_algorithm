import java.io.*;

//4분 56초 
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char a[] = br.readLine().toCharArray();
		char b[] = br.readLine().toCharArray();
		
		int cnt_a[] = new int[26];
		int cnt_b[] = new int[26];
		for(int i=0; i<a.length; i++) {
			cnt_a[a[i]-'a']++;
		}
		for(int i=0; i<b.length; i++) {
			cnt_b[b[i]-'a']++;
		}
		
		int result = 0;
		for(int i=0; i<26; i++) {
			result += Math.abs(cnt_a[i]-cnt_b[i]);
		}
		
		System.out.println(result);
		
		br.close();
	}

}