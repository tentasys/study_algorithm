//택시 기하학 참고 : https://terms.naver.com/entry.nhn?docId=3567439&cid=58944&categoryId=58970
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		
		//유클리드 기하학 
		System.out.println(Math.PI*Math.pow(R, 2));
		//택시 기하학 
		System.out.println(2*R*R);
	}
}