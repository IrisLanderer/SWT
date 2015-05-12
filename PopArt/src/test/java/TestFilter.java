import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.ipd.swt1.jmjrst.popart.filter.BlurFilter;
import edu.kit.ipd.swt1.jmjrst.popart.filter.GrayScaleFilter;
import edu.kit.ipd.swt1.jmjrst.popart.filter.RGBShift;
import edu.kit.ipd.swt1.jmjrst.popart.filter.RGBShift.Channel;
import edu.kit.ipd.swt1.jmjrst.popart.filter.SepiaFilter;

public class TestFilter {

	BufferedImage image;
	BufferedImage originalImage;
	Channel red = Channel.RED;
	Channel green = Channel.GREEN;
	Channel blue = Channel.BLUE;

	@Before
	public void setUp() throws IOException {
		File file = new File("src/test/resources/image.png");

		ImageInputStream iis = ImageIO.createImageInputStream(file);
		ImageReader reader = ImageIO.getImageReadersByFormatName("png").next();
		reader.setInput(iis, true);
		ImageReadParam params = reader.getDefaultReadParam();
		image = reader.read(0, params);
		originalImage = reader.read(0, params);

	}

	@After
	public void clean() throws IOException {

		File file = new File("src/test/resources/image.png");

		ImageInputStream iis = ImageIO.createImageInputStream(file);
		ImageReader reader = ImageIO.getImageReadersByFormatName("png").next();
		reader.setInput(iis, true);
		ImageReadParam params = reader.getDefaultReadParam();
		originalImage = reader.read(0, params);
	}

	@Test
	public void testBlurFilter() {

		BlurFilter filter = new BlurFilter();
		filter.applyFilter(image);

		int width = image.getWidth();
		int height = image.getHeight();
		int[][] oldPixel = new int[width][height];
		int[][] newPixel = new int[width][height];
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				oldPixel[i][j] = originalImage.getRGB(i, j);
				newPixel[i][j] = image.getRGB(i, j);

			}
		}
		Assert.assertNotEquals(oldPixel, newPixel);
	}

	@Test
	public void testSepiaFilter() {

		SepiaFilter filter = new SepiaFilter();
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] oldPixel = new int[width][height];
		int[][] newPixel = new int[width][height];
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				oldPixel[i][j] = originalImage.getRGB(i, j);
				newPixel[i][j] = image.getRGB(i, j);

			}
		}
		Assert.assertNotEquals(oldPixel, newPixel);
	}

	@Test
	public void testGrayScaleFilter() {

		GrayScaleFilter filter = new GrayScaleFilter();
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] oldPixel = new int[width][height];
		int[][] newPixel = new int[width][height];
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				oldPixel[i][j] = originalImage.getRGB(i, j);
				newPixel[i][j] = image.getRGB(i, j);

			}
		}
		Assert.assertNotEquals(oldPixel, newPixel);
	}

	@Test
	public void testBlueRedGreen() {
		RGBShift filter = new RGBShift(green, blue, red);
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int pixel = originalImage.getRGB(i, j);
				int oldAlpha = (pixel >> 24) & 0xff;
				int oldRed = (pixel >> 16) & 0xff;
				int oldGreen = (pixel >> 8) & 0xff;
				int oldBlue = (pixel) & 0xff;

				pixel = image.getRGB(i, j);
				int newAlpha = (pixel >> 24) & 0xff;
				int newRed = (pixel >> 16) & 0xff;
				int newGreen = (pixel >> 8) & 0xff;
				int newBlue = (pixel) & 0xff;

				Assert.assertEquals(oldAlpha, newAlpha);
				Assert.assertEquals(oldGreen, newRed);
				Assert.assertEquals(oldBlue, newGreen);
				Assert.assertEquals(oldRed, newBlue);
			}
		}
	}

	@Test
	public void testGreenBlueRed() {
		RGBShift filter = new RGBShift(green, blue, red);
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int pixel = originalImage.getRGB(i, j);
				int oldAlpha = (pixel >> 24) & 0xff;
				int oldRed = (pixel >> 16) & 0xff;
				int oldGreen = (pixel >> 8) & 0xff;
				int oldBlue = (pixel) & 0xff;

				pixel = image.getRGB(i, j);
				int newAlpha = (pixel >> 24) & 0xff;
				int newRed = (pixel >> 16) & 0xff;
				int newGreen = (pixel >> 8) & 0xff;
				int newBlue = (pixel) & 0xff;

				Assert.assertEquals(oldAlpha, newAlpha);
				Assert.assertEquals(oldGreen, newBlue);
				Assert.assertEquals(oldBlue, newRed);
				Assert.assertEquals(oldRed, newGreen);
			}
		}
	}

	@Test
	public void testRedBlueGreen() {
		RGBShift filter = new RGBShift(green, blue, red);
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int pixel = originalImage.getRGB(i, j);
				int oldAlpha = (pixel >> 24) & 0xff;
				int oldRed = (pixel >> 16) & 0xff;
				int oldGreen = (pixel >> 8) & 0xff;
				int oldBlue = (pixel) & 0xff;

				pixel = image.getRGB(i, j);
				int newAlpha = (pixel >> 24) & 0xff;
				int newRed = (pixel >> 16) & 0xff;
				int newGreen = (pixel >> 8) & 0xff;
				int newBlue = (pixel) & 0xff;

				Assert.assertEquals(oldAlpha, newAlpha);
				Assert.assertEquals(oldGreen, newBlue);
				Assert.assertEquals(oldBlue, newBlue);
				Assert.assertEquals(oldRed, newRed);
			}
		}
	}

	@Test
	public void testGreenRedBlue() {
		RGBShift filter = new RGBShift(green, blue, red);
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int pixel = originalImage.getRGB(i, j);
				int oldAlpha = (pixel >> 24) & 0xff;
				int oldRed = (pixel >> 16) & 0xff;
				int oldGreen = (pixel >> 8) & 0xff;
				int oldBlue = (pixel) & 0xff;

				pixel = image.getRGB(i, j);
				int newAlpha = (pixel >> 24) & 0xff;
				int newRed = (pixel >> 16) & 0xff;
				int newGreen = (pixel >> 8) & 0xff;
				int newBlue = (pixel) & 0xff;

				Assert.assertEquals(oldAlpha, newAlpha);
				Assert.assertEquals(oldGreen, newRed);
				Assert.assertEquals(oldBlue, newBlue);
				Assert.assertEquals(oldRed, newGreen);
			}
		}
	}

	@Test
	public void testBlueGreenRed() {
		RGBShift filter = new RGBShift(green, blue, red);
		filter.applyFilter(image);
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int pixel = originalImage.getRGB(i, j);
				int oldAlpha = (pixel >> 24) & 0xff;
				int oldRed = (pixel >> 16) & 0xff;
				int oldGreen = (pixel >> 8) & 0xff;
				int oldBlue = (pixel) & 0xff;

				pixel = image.getRGB(i, j);
				int newAlpha = (pixel >> 24) & 0xff;
				int newRed = (pixel >> 16) & 0xff;
				int newGreen = (pixel >> 8) & 0xff;
				int newBlue = (pixel) & 0xff;

				Assert.assertEquals(oldAlpha, newAlpha);
				Assert.assertEquals(oldGreen, newGreen);
				Assert.assertEquals(oldBlue, newRed);
				Assert.assertEquals(oldRed, newBlue);
			}
		}
	}

	@Test
	public void testBlur() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new BlurFilter().applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testSepia() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new SepiaFilter().applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testGray() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new GrayScaleFilter().applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testRgbRgb() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new RGBShift().applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testRgbBrg() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new RGBShift(Channel.BLUE, Channel.RED,
				Channel.GREEN).applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testRgbRbg() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new RGBShift(Channel.RED, Channel.BLUE,
				Channel.GREEN).applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testRgbGrb() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new RGBShift(Channel.GREEN, Channel.RED,
				Channel.BLUE).applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}

	@Test
	public void testRgbBgr() throws Exception {
		BufferedImage oldImage = ImageIO.read(new File(
				"src/test/resources/image.png"));
		BufferedImage newImage = new RGBShift(Channel.BLUE, Channel.GREEN,
				Channel.RED).applyFilter(oldImage);
		ImageIO.write(newImage, "png", new File("src/test/resources/image.png"));
	}
}
