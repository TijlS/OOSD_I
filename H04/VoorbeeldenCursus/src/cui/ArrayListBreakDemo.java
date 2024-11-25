package cui;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBreakDemo {
	public static void main(String[] args) {
		new ArrayListBreakDemo().toonBreakStatement();
	}

	private void toonBreakStatement() {
		List<Integer> integerList = new ArrayList<>();
		integerList.add(5);
		integerList.add(8);
		integerList.add(12);
		integerList.add(20);
		integerList.add(3);

		int indexEersteGetalGroterDan10 = 0;
		for (int i : integerList) {
			if (i > 10) { // <.>
				break; // <.>
			}
			indexEersteGetalGroterDan10++;
		}
		if (indexEersteGetalGroterDan10 != integerList.size())
			System.out.printf("Het eerste element groter dan 10 zit op index %d", indexEersteGetalGroterDan10);
		else
			System.out.println("De lijst bevat geen element groter dan 10");
	}
}