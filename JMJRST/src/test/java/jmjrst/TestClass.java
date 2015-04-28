package jmjrst;

import org.junit.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;

import org.jis.generator.Generator;


public class TestClass {

	private Generator generator;
	BufferedImage image;
	BufferedImage rotated;
    
	
	@Before
	public void setUp() throws IOException {
		generator = new Generator(null, 0);
		File file = new File("src/test/resources/picture.jpg");
		
		
	      ImageInputStream iis = ImageIO.createImageInputStream(file);
	      ImageReader reader = ImageIO.getImageReadersByFormatName("jpg").next();
	      reader.setInput(iis, true);
	      ImageReadParam params = reader.getDefaultReadParam();
	      image = reader.read(0, params);

	    
	    
	}
	
	@After
	public void tearDown() throws IOException {
		if (rotated != null) {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss_SSS");
		String date = dateFormat.format(today);
		File outputfile = new File("target/testData/rotatedPicture_" + date + ".jpg");
		ImageIO.write(rotated, "jpg", outputfile);
		}
	}
	
	@Test
	public void testImageNull() {
		Assert.assertEquals(generator.rotateImage(null, 0.0), null);
	}
	
	@Test
	public void testImage(){
		BufferedImage testImage = new BufferedImage(10,10,5);
		Assert.assertEquals(generator.rotateImage(testImage, 0.0),testImage);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		generator.rotateImage(image, 1.0);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testNullPointerException() {
		generator.rotateImage(null, 1.0);
	}
	
	@Test
	public void testRotate90degree() {
	    rotated = generator.rotateImage(image, Math.PI*90/180);
		Assert.assertEquals(rotated.getHeight(), image.getWidth());
		Assert.assertEquals(rotated.getWidth(), image.getHeight());		
		Assert.assertEquals(rotated.getColorModel(),image.getColorModel());
		Assert.assertEquals(rotated.getAlphaRaster(), image.getAlphaRaster());
	}
	
	@Test
	public void testRotate270degree() {
		rotated = generator.rotateImage(image, Math.PI*270/180);
		Assert.assertEquals(rotated.getHeight(), image.getWidth());
		Assert.assertEquals(rotated.getWidth(), image.getHeight());		
		Assert.assertEquals(rotated.getColorModel(),image.getColorModel());
		Assert.assertEquals(rotated.getAlphaRaster(), image.getAlphaRaster());
	}
}
