package jmjrst;

import org.jis.Main;
import org.jis.generator.Generator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GeneratorTest {

	private Generator generator;

	@Before
	public void init() {

		Main mainMock = Mockito.mock(Main.class);
		this.generator = new Generator(mainMock, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rotateNullFile() {
		this.generator.rotate(null, 0);
	}

	// @Ignore
	// public void rotateImageWithAngle0() {
	// File fileToRotate = new File("/icons/folder.png");
	// this.generator.rotate(fileToRotate, 0);
	// }
}