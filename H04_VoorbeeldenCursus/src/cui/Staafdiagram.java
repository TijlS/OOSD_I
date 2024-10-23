package cui;

//tag::mainStaafdiagram[]
public class Staafdiagram {
	public static void main(String[] args) {
		new Staafdiagram().toonStaafdiagram();
	}

	private void toonStaafdiagram() {
		int[] verdeling = { 8, 0, 6, 7, 11, 9, 13, 5, 17, 2, 1 };

		System.out.println("Verdeling examenresultaten:");

		for (int index = 0; index < verdeling.length; index++) { // <.>
			if (index == verdeling.length - 1) // <.>
				System.out.printf("%5d: ", index * 10);
			else
				System.out.printf("%02d-%02d: ", index * 10, index * 10 + 9);

			tekenStaafje(verdeling[index]); // <.>

			System.out.println();
		}
	}

	private void tekenStaafje(int lengte) {
		for (int sterretje = 1; sterretje <= lengte; sterretje++) {
			System.out.print("*");
		}
	}
}
//end::mainStaafdiagram[]

//	Verdeling examenresultaten:
//	00-09: ********
//	10-19: 
//	20-29: ******
//	30-39: *******
//	40-49: ***********
//	50-59: *********
//	60-69: *************
//	70-79: *****
//	80-89: *****************
//	90-99: **
//  100: *

//	Verdeling examenresultaten:
//	00-09: *****
//	10-19: ********
//     20: **
