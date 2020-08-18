public class Main {

	static int a, b;
	public static void main(String[] args) throws Exception{
		try {
			a = System.in.read() - '0';
			System.in.read();
			b = System.in.read() - '0';
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.print(a+b);
	}

}
