import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][N];
		
		//�迭 �ʱ�ȭ
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//�߰���� ������Ʈ
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				for(int k=0; k<N; k++)
					if(arr[j][i] == 1 && arr[i][k] == 1)	arr[j][k] = 1;
			}
		}
		
		//��� ���
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
		br.close();
	}
}
