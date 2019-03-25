public class Main {
	static int a, b;
	static double c;
	public static void main(String[] args) {
		try {
			a = System.in.read()-'0';
			System.in.skip(1);
			b = System.in.read()-'0';
			c = (double)a/(double)b;
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.print(c);
	}
}