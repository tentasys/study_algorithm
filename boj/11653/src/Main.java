import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		//문제 조건 : 1일 경우 아무것도 출력하지 않음 
		//1을 써야 하는 상황이라면 고려해서 프로그래밍 하자!
		
		//이건 시간복잡도가 더 높다 
//		while(num != 1) {
//			for(int i=2; i<=num; i++) {
//				if(num%i == 0) {
//					System.out.println(i);
//					num /= i;
//					break;
//				}
//			}
//		}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			while(num%i == 0) {
				System.out.println(i);
				num /= i;
			}			
		}
		//그 자체가 소수일 때  
		if(num != 1)
			System.out.println(num);

	}
}