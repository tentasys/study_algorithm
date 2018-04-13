import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int ii=0; ii<T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int matrix[][] = new int[W][D];
			for(int i=0; i<D; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++)
					matrix[j][i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println("#"+(ii+1)+" ");
		}
	}

}
