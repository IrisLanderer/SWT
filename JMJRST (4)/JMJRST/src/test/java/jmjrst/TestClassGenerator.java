//package jmjrst;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.imageio.ImageIO;
//import javax.imageio.ImageReadParam;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;
//
//import org.jis.generator.Generator;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class TestClassGenerator {
//
//	private Generator generator;
//	BufferedImage image;
//	BufferedImage rotated;
//	File file = new File("src/test/resources/picture.jpg");
//    
//	
//	@Before
//	public void setUp() throws IOException {
//		generator = new Generator(null, 0);
//		
//		
//		
//	      ImageInputStream iis = ImageIO.createImageInputStream(file);
//	      ImageReader reader = ImageIO.getImageReadersByFormatName("jpg").next();
//	      reader.setInput(iis, true);
//	      ImageReadParam params = reader.getDefaultReadParam();
//	      image = reader.read(0, params);
//
//	    
//	    
//	}
//	
////	@After
////	public void tearDown() throws IOException {
////		if (rotated != null) {
////		Date today = new Date();
////		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss_SSS");
////		String date = dateFormat.format(today);
////		File outputfile = new File("target/testData/rotatedPicture_" + date + ".jpg");
////		ImageIO.write(rotated, "jpg", outputfile);
////		}
////	}
//	
//	@Test
//	public void testGenerateSingle() {
//		Assert.assertEquals(generator.generateSingle(file, image), image);
//	}
//	
//	@Test
//	public void testGenerateImage() {
//		Assert.assertEquals(generator.generateImage(file, file, print, width, height, praefix), image);
//	}
//}
