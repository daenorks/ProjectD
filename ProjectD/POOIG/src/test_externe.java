
public class test_externe {
	public static void main (String []args) {
		test.C2.action();
		essai(test.C2);
	}
	
	public static void essai(test T1) {
		switch(T1) {
		case C2:
			System.out.println(" Bonjour");
			break;
		}
	}
}
