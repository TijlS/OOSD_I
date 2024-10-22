package cui;

public class ConditionalOperator {

	public static void main(String[] args) {
		ConditionalOperator co = new ConditionalOperator();

		co.show();

	}

	private void show() {
		int students = 10;

		System.out.printf("Student%s", students == 1 ? "" : "en");
	}

}
