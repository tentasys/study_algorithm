import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int ii=0; ii<N; ii++) {
			char[] str = br.readLine().toCharArray();
			int arr[] = new int[26];		//각 알파벳의 마지막 인덱스를 담을 배열 
			boolean flag = true;
			
			for(int i=0; i<str.length; i++) {
				int cur_idx = arr[str[i]-'a'];
				
				if(cur_idx == 0) {
					arr[str[i]-'a'] = i+1;
				}
				else if(i+1 - cur_idx > 1){ //가장 마지막 인덱스 값이 엉뚱한데 있으면 그룹단어 아님 
					flag = false;
					break;
				}
				else {
					arr[str[i]-'a'] = i+1;
				}
			}
			
			if(flag == true)				count++;
		}
		
		System.out.println(count);
	}
}