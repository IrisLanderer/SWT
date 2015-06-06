public class ExerciseInstructor {
	private String name;

	public ExerciseInstructor(String name) {
		this.name = name;
	}

	public void test(Student student) {
		if (student.answer()) {
			System.out.println("Der Student " + student.getName()
					+ " hat den Übungsschein von " + this.getName()
					+ " erhalten :)");
		} else
			System.out.println("Der Student " + this.getName()
					+ " hat den Übungsschein von " + this.getName()
					+ " nicht erhalten :(");
	}

	public String getName() {
		return this.name;
	}
}
