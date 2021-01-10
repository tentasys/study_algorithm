import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		int idx = 0;
		int count = 0;
		
		while(idx < str.length) {
			//다음 문자를 비교하려면 비교 가능한 다음 문자가 있어야 하므로 
			if(idx < str.length-1) {
				if(str[idx] == 'c') {
					if(str[idx+1] == '=' || str[idx+1] == '-') {
						idx++;
					}
				}
				else if(str[idx] == 'd') {
					if(str[idx+1] == '-'){
						idx++;
					}
					else if(idx < str.length-2) {
						if(str[idx+1] == 'z' && str[idx+2] == '=') {
							idx += 2;
						}
					}
				}
				else if(str[idx] == 'l' || str[idx] == 'n') {
					if(str[idx+1] == 'j') {
						idx++;
					}
				}
				else if(str[idx] == 's' || str[idx] == 'z') {
					if(str[idx+1] == '=') {
						idx++;
					}
				}
			}
			
			count++;
			idx++;
		}
		
		System.out.println(count);
	}
}