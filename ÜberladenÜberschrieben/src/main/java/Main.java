public class Main {

	public static void main(String[] args) {
		SuperClass superclass = new SuperClass();
		SubClass subclass = new SubClass();
		superclass.overload("Ich überlade.");
		subclass.overload();
		subclass.overload("Ich überlade eine überschriebene Methode", ".");
		superclass.overload();
	}

}
