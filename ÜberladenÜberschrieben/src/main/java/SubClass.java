public class SubClass extends SuperClass {

	@Override
	public void overload() {
		String string = "Ich �berschreibe.";
		System.out.println(string);
	}

	public void overload(String first, String last) {
		System.out.println(first + last);
	}
}
