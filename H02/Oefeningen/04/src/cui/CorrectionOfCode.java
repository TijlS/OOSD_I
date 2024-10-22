package cui;

public class CorrectionOfCode {

	public static void main(String[] args) {
		CorrectionOfCode coc = new CorrectionOfCode();

		coc.correct();
	}

	private void correct() {
		int age = 55;

//		Code to be corrected:
//		if(age>=65);{
//			System.out.println("Age greater than or equal to 65");
//		}else
//			System.out.println("Age is less than 65 )";

		if (age >= 65) {
			System.out.println("Age greater than or equal to 65");
		} else
			System.out.println("Age is less than 65");
		;
	}

}
