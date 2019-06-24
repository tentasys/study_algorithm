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
			int arr[] = new int[tmp.length()];	//숫자를 배열에 저장
			
			for(int i=0; i<tmp.length(); i++)
				arr[i] = tmp.charAt(i)-'0';		//숫자화
			//----입력 끝
			
			int idx = 0;
			while(change > 0)
			{
				if(idx != arr.length-2)
				{
					int max = arr[idx];		//인덱스부터
					int max_idx = idx;
					
					for(int i=idx+1; i<arr.length; i++)
					{
						if(arr[i] >= max)
						{
							max = arr[i];
							max_idx = i;
						}
					}
				
					if(max_idx == idx)		//최대값이 현재값이면 스킵
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
			
			//--출력 시작
			System.out.print("#"+ii+" ");
			for(int a: arr)
				System.out.print(a);
			System.out.println();
		}
		
		br.close();
	}

}
