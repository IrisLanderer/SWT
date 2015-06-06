public class JuniorExerciseInstructor extends ExerciseInstructor {

	public JuniorExerciseInstructor(String name) {
		super(name);
	}

	public void test(PartyStudent partyStudent) {
		partyStudent.learn();
		this.test((Student) partyStudent);
	}
}
