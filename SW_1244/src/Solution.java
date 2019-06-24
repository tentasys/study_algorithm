import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String tmp = st.nextToken();
			int change = Integer.parseInt(st.nextToken());
			int arr[] = new int[tmp.length()];	//���ڸ� �迭�� ����
			
			for(int i=0; i<tmp.length(); i++)
				arr[i] = tmp.charAt(i)-'0';		//����ȭ
			//----�Է� ��
			
			int idx = 0;
			while(change > 0)
			{
				if(idx != arr.length-2)
				{
					int max = arr[idx];		//�ε�������
					int max_idx = idx;
					
					for(int i=idx+1; i<arr.length; i++)
					{
						if(arr[i] >= max)
						{
							max = arr[i];
							max_idx = i;
						}
					}
				
					if(max_idx == idx)		//�ִ밪�� ���簪�̸� ��ŵ
					{
						idx++;
						continue;
					}
					
					int temp = arr[idx];
					arr[idx] = arr[max_idx];
					arr[max_idx] = temp;
					change--;
					idx++;
				}
				else
				{
					int temp = arr[idx];
					arr[idx] = arr[idx+1];
					arr[idx+1] = temp;
					change--;
				}
				
				
			}
			
			//--��� ����
			System.out.print("#"+ii+" ");
			for(int a: arr)
				System.out.print(a);
			System.out.println();
		}
		
		br.close();
	}

}
