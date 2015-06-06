public class PartyStudent extends Student {

	private boolean isClever;

	public PartyStudent(String name) {
		super(name);
		this.isClever = false;
	}

	public void learn() {
		isClever = true;
	}

	@Override
	public boolean answer() {
		if (isClever)
			return true;
		return false;
	}

	public boolean getIsClever() {
		return this.isClever;
	}
}
