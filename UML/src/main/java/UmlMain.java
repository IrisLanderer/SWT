public class UmlMain {

	public static void main(String[] args) {
		Student student = new Student("Iris");
		PartyStudent partyStudent = new PartyStudent("Max");
		ExerciseInstructor instructor = new ExerciseInstructor("Blersch");
		JuniorExerciseInstructor junior = new JuniorExerciseInstructor(
				"Landh‰uﬂer");
		instructor.test(student);
		instructor.test(partyStudent);
		junior.test(student);
		junior.test(partyStudent);
	}

}
