import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			int K = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[5][8];	//���� ���ϰ� ������ 1~4 ���. �ڼ� ������ ���� �迭
			
			//�ڼ� ���� �Է�
			for(int i=1; i<=4; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());

			}//�ڼ� ���� �Է� ��
			
			//K�� �ݺ��ϸ� �ڼ� ȸ��
			for(int i=0; i<K; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());		//���� �ڼ�
				int dir = Integer.parseInt(st.nextToken());		//�ڼ� ���� ����
				
				//�ڼ����� �´�� �κ� : 1�ڼ� 2 - 2�ڼ� 6 / 2�ڼ� 2 - 3�ڼ� 6 / 3�ڼ� 2 - 4�ڼ� 6
				//1-3, 2-4���� ���� �������� ȸ���ϰ�, �� �׷��� ���� �ݴ� �������� ȸ��
				int flag[] = new int[5];	//ȸ�� ����. 0�̸� ȸ�� ���ϰ�, 1�̳� -1�̸� ȸ��
				
				switch(num)
				{
				case 1:
					flag[1] = dir;			//1�� ȸ������ ����
					
					if(arr[1][2] == arr[2][6])	break;	//2���� ���� �ؼ��̸� Ż��
					flag[2] = dir*(-1);		//�ٸ� �ؼ��̸� 1�� �ݴ�������� ȸ��
					
					if(arr[2][2] == arr[3][6])	break;
					flag[3] = dir;
					
					if(arr[3][2] == arr[4][6])	break;
					flag[4] = dir*(-1);			break;
					
				case 2:
					flag[2] = dir;
					
					if(arr[2][6] != arr[1][2])	flag[1] = dir*(-1);	//1 üũ
					
					if(arr[2][2] == arr[3][6])	break;
					flag[3] = dir*(-1);
					
					if(arr[3][2] == arr[4][6])	break;
					flag[4] = dir;				break;
					
				case 3:
					flag[3] = dir;
					
					if(arr[3][2] != arr[4][6])	flag[4] = dir*(-1);	//4 üũ
					
					if(arr[2][2] == arr[3][6])	break;
					flag[2] = dir*(-1);
					
					if(arr[1][2] == arr[2][6])	break;
					flag[1] = dir;				break;
					
				case 4:
					flag[4] = dir;			//1�� ȸ������ ����
					
					if(arr[4][6] == arr[3][2])	break;	//2���� ���� �ؼ��̸� Ż��
					flag[3] = dir*(-1);		//�ٸ� �ؼ��̸� 1�� �ݴ�������� ȸ��
					
					if(arr[3][6] == arr[2][2])	break;
					flag[2] = dir;
					
					if(arr[2][6] == arr[1][2])	break;
					flag[1] = dir*(-1);			break;
				}
				
				//ȸ�� ������ ���� ȸ��
				for(int j=1; j<=4; j++)
				{
					if(flag[j] != 0)
						rotate(flag[j], arr[j]);
				}
			}
			
			//��� ���
			int sum = 0;
			for(int i=1; i<=4; i++)
				sum += Math.pow(2, (i-1)) * arr[i][0];
			
			System.out.println("#"+ii+" "+sum);
		}
	}
	
	//���⿡ ���� ȸ��
	static public void rotate(int dir, int arr[])
	{
		if(dir == 1)
			clockwise(arr);
		else
			counterClockwise(arr);
	}
	//�迭 �ð���� ȸ��
	static public void clockwise(int[] arr)
	{
		int temp = arr[7];
		for(int i=7; i>0; i--)
			arr[i] = arr[i-1];
		arr[0] = temp;

	}
	//�迭 �ݽð���� ȸ��
	static public void counterClockwise(int[] arr)
	{
		int temp = arr[0];
		for(int i=0; i<7; i++)
			arr[i] = arr[i+1];
		arr[7] = temp;
	}
}