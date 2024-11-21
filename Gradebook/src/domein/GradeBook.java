package domein;

public class GradeBook {
	private String courseName;
	private int[][] grades;

	public GradeBook(String courseName, int[][] grades) {
		setCourseName(courseName);
		this.grades = grades;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	// het slechtste examen zoeken
	public int searchMinimum() {
		// initialisatie: eerste element is het slechtste examen
		int lowGrade = grades[0][0];

		// de rijen van de array doorlopen
		for (int[] studentGrades : grades) // de kolommen per rij doorlopen
		{
			for (int grade : studentGrades)
			// Controleren of huidige punt van examen kleiner is dan "lowGrade"
			// Zoja, huidig punt toekennen aan "lowGrade"
			{
				if (grade < lowGrade) {
					lowGrade = grade;
				}
			}
		}
		return lowGrade; // geeft het slechtste examen terug
	}

	// het beste examen zoeken
	public int searchMaximum() {
		// initialisatie: eerste element is het beste examen
		int highGrade = grades[0][0];

		// de rijen van de array doorlopen
		for (int[] studentGrades : grades) // de kolommen per rij doorlopen
		{
			for (int grade : studentGrades)
			// Controleren als huidige punt van examen groter is dan “highGrade”.
			// Zoja, huidig punt toekennen aan “highGrade”.
			{
				if (grade > highGrade) {
					highGrade = grade;
				}
			}
		}
		return highGrade; // geeft het beste examen terug
	}

	// de gemiddelde punten van een student bepalen
	public double calculateAverage(int setOfGrades[]) {
		int total = 0; // total initialiseren op nul

		// som van de punten van één student
		for (int grades : setOfGrades) {
			total += grades;
		}
		// geeft de gemiddelde punten terug
		return (double) total / setOfGrades.length;
	}

	// output string opvullen
	public String buildOutput() {
		String output = buildOutputGrades();

		output += String.format("%n%s %d%n%s %d%n%n", "Lowest grade in the grade book is", searchMinimum(),
				"Highest grade in the grade book is", searchMaximum()); // <.>

		output += buildOutputBarChart();
		return output;
	} 

	// output the contents of the grades array
	public String buildOutputGrades() {
		String output = "The grades are:%n%n";
		output += "            "; // align column heads

		// create a column heading for each of the tests
		for (int test = 0; test < grades[0].length; test++) {
			output += String.format("Test %d  ", test + 1);
		}

		output += "Average%n"; // student average column heading

		// create rows/columns of text representing array grades
		for (int student = 0; student < grades.length; student++) {
			output += String.format("Student %2d", student + 1);

			for (int test : grades[student]) // output student's grades
			{
				output += String.format("%8d", test);
			}

			// call method getAverage to calculate student's average grade;
			// pass row of grades as the argument to getAverage
			double average = calculateAverage(grades[student]);
			output += String.format("%9.2f%n", average);
		}
		return output;
	}

	public String buildOutputBarChart() {
		String output = "Overall grade distribution:";

		// stores frequency of grades in each range of 10 grades
		int[] frequency = new int[11];

		// for each grade in GradeBook, increment the appropriate frequency
		for (int[] studentGrades : grades) {
			for (int grade : studentGrades) {
				++frequency[grade / 10];
			}
		}

		// for each grade frequency, print bar in chart
		for (int count = 0; count < frequency.length; count++) {
			// output bar label ("00-09: ", ..., "90-99: ", "100: ")
			if (count == 10) {
				output += String.format("%5d: ", 100);
			} else {
				output += String.format("%02d-%02d: ", count * 10, count * 10 + 9);
			}

			// print bar of asterisks
			for (int stars = 0; stars < frequency[count]; stars++) {
				output += "*";
			}
			output += "%n";
		}
		return output;
	}
	
}