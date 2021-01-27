import java.io.*;

public class Main {

	static public int primecount[] = new int[(123456*2)+1];
	static public int count = 0;
	
	public static void main(String[] args) throws Exception{	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		setPrime();

		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0)
				break;			
			
			System.out.println(primecount[num*2]-primecount[num]);
		}
	}
	public static void setPrime() {
		
		for(int i=0; i<primecount.length; i++) {
			if(i == 0 || i == 1){
				count = 0;
				primecount[i] = count;
			}
			else if(i == 1) {
				count = 1;
			}
			else {
				boolean flag = true;
				for(int j=2; j<=Math.sqrt(i); j++) {
					if(i%j == 0) {
						flag = false;
						break;
					}
				}				
				if(flag == true)	count++;
			}
			
			primecount[i] = count;
		}
	}
}