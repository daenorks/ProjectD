
public enum test {
	C1(1),
	C2(2),
	C3(3);
	
	int y;
	
	test(int y){
		this.y=y;
	}
	
	public void action() {
		switch (this) {
		case C1:
			System.out.print("C1");
			break;
		case C2:
			System.out.print("C2");
			break;
		case C3:
			System.out.print("C3");
			break;
		}
	}
	
	public static void main(String []args) {
		C1.action();
	}
	
}
