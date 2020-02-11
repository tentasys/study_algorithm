import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());	//�׽�Ʈ���̽� ��
		
		for(int ii=0; ii<C; ii++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//������ �뿩 ��
			int L = Integer.parseInt(st.nextToken());	//���� �� ��
			
			//��� �Է�
			st = new StringTokenizer(br.readLine());
			int cost[] = new int[N+1];
			
			//�ε��� 1���� �ִ´�
			for(int i=0; i<N; i++) {
				cost[i+1] = Integer.parseInt(st.nextToken());
			}
			
			double min = Double.MAX_VALUE;	//�ִ밪
			//�ּ� �뿩�� : L, �ִ� �뿩�� : N
			for(int i=L; i<=N; i++) {	//�����ؾ��� ��
				for(int j=i; j<=N; j++) {	//���� �ε���
					int tempsum = 0;
					for(int k=0; k<i; k++) {	//���ϴ� ��
//						System.out.print(cost[j-k]+" ");
						tempsum += cost[j-k];
					}
						
//					System.out.println();
					double tempret = (double)tempsum/i;
					if(min > tempret)
						min = tempret;
				}
			}
			System.out.println(min);
		}
		
		
		
	}

}
