public class Main {

	public static void main(String[] args) {
		SuperClass superclass = new SuperClass();
		SubClass subclass = new SubClass();
		superclass.overload("Ich �berlade.");
		subclass.overload();
		subclass.overload("Ich �berlade eine �berschriebene Methode", ".");
		superclass.overload();
	}

}
