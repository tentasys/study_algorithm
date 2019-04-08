import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//---------------�ʱ�ȭ �Ϸ�
		
		int total = 0;		//���� ��
		
		//-----���ι������� Ž��
		for(int i=0; i<N; i++)
		{
			int count = 1;				//������ �󸶳� ���ӵǾ��ֳ�
			boolean flag = true;
			boolean downflag = false;

			int prev = map[i][0];
			int cur;
			
			//������ �Ǵ�
			for(int j=1; j<N; j++)
			{
				cur = map[i][j];
				if(Math.abs(prev-cur) > 1)	//���̰� 2 �̻��̸� Ż��
				{
					flag = false;
					break;
				}
				else if(prev-cur == -1)	//�ö󰡴� ���
				{
					if(count < L || downflag == true)	//������ ���κ��� �۴ٸ� + �ٿ��÷��������� ��
					{
						flag = false;					//���� �÷��� ����� Ż��
						break;
					}
					count = 1;		//���� ���¼� �ʱ�ȭ
					prev = cur;
					continue;
				}
					
				if(prev-cur == 1)	//�������� ���
				{		
					if(downflag == true)
					{
						flag = false;
						break;
					}
					count = 0;
					downflag = true;
				}

				count++;
				if(downflag == true && count == L)
				{
					downflag = false;
					count = 0;
				}
				
				prev = cur;
			}
			
			if(downflag == true)	flag = false;
			if(flag == true)	total++;				//�̹����� �ִ��� �Ǵ�
		}//---���ι��� ��
		
		//-----���ι������� Ž��
		for(int i=0; i<N; i++)
		{
			int count = 1;				//������ �󸶳� ���ӵǾ��ֳ�
			boolean flag = true;
			boolean downflag = false;

			int prev = map[0][i];
			int cur;
			
			//������ �Ǵ�
			for(int j=1; j<N; j++)
			{
				cur = map[j][i];
				if(Math.abs(prev-cur) > 1)	//���̰� 2 �̻��̸� Ż��
				{
					flag = false;
					break;
				}
				else if(prev-cur == -1)	//�ö󰡴� ���
				{
					if(count < L || downflag == true)	//������ ���κ��� �۴ٸ� + �ٿ��÷��������� ��
					{
						flag = false;					//���� �÷��� ����� Ż��
						break;
					}
					count = 1;		//���� ���¼� �ʱ�ȭ
					prev = cur;
					continue;
				}
					
				if(prev-cur == 1)	//�������� ���
				{	
					if(downflag == true)
					{
						flag = false;
						break;
					}
					count = 0;
					downflag = true;
				}

				count++;
				if(downflag == true && count == L)
				{
					downflag = false;
					count = 0;
				}
				
				prev = cur;
			}
			
			if(downflag == true)	flag = false;
			if(flag == true)	total++;				//�̹����� �ִ��� �Ǵ�
		}//---���ι��� ��
		
		System.out.print(total);
	}

}
