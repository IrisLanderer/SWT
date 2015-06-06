//package edu.kit.ipd.swt1.jmjrst.popart;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import org.apache.commons.cli.BasicParser;
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.Option;
//import org.apache.commons.cli.Options;
//import org.apache.commons.cli.ParseException;
//
//import edu.kit.ipd.swt1.jmjrst.popart.filter.BlurFilter;
//import edu.kit.ipd.swt1.jmjrst.popart.filter.GrayScaleFilter;
//import edu.kit.ipd.swt1.jmjrst.popart.filter.RGBShift;
//import edu.kit.ipd.swt1.jmjrst.popart.filter.RGBShift.Channel;
//import edu.kit.ipd.swt1.jmjrst.popart.filter.SepiaFilter;
//
///**
// * Hauptklasse
// * 
// * @author Iris
// *
// */
//public class Main {
//	private static final String CMD_OPTION_SOURCE_FILE = "s";
//	private static final String CMD_OPTION_DEST_FILE = "d";
//	private static final String CMD_OPTION_PATTERN = "p";
//
//	/**
//	 * Privater Konstruktor verhindert Instanziierung
//	 */
//	private Main() {
//	}
//
//	/**
//	 * Main-Methode: Liest Kommandozeilenargumente ein und ruft
//	 * kit.edu.ipd.swt1.SimpleColorReduction entsprechend auf.
//	 * 
//	 * @param args
//	 *            Kommandozeilenargumente vom Benutzer
//	 */
//	public static void main(String[] args) {
//		CommandLine cmd = null;
//		try {
//			cmd = doCommandLineParsing(args);
//		} catch (ParseException exception) {
//			System.err
//					.println("Mit den Kommandozeilenargumenten stimmt etwas nicht: "
//							+ exception.getMessage());
//			System.exit(1);
//		}
//
//		try {
//			BufferedImage image = ImageIO.read(new File(cmd
//					.getOptionValue(CMD_OPTION_SOURCE_FILE)));
//			int width = image.getWidth();
//			int height = image.getHeight();
//			int type = image.getType();
//			int deltaX = 0;
//			int deltyY = 0;
//			String pattern = cmd
//					.getOptionValue(CMD_OPTION_PATTERN, "osgw12345");
//			BufferedImage collage = null;
//			if (pattern.length() == 4) {
//				collage = new BufferedImage(width * 2, height * 2, type);
//			} else if (pattern.length() == 9) {
//				collage = new BufferedImage(width * 3, height * 3, type);
//			}
//			for (char c : pattern.toCharArray()) {
//				Channel red = Channel.RED;
//				Channel green = Channel.GREEN;
//				Channel blue = Channel.BLUE;
//				image = ImageIO.read(new File(cmd
//						.getOptionValue(CMD_OPTION_SOURCE_FILE)));
//				switch (c) {
//				case 'o':
//					// Originalbild
//					break;
//				case 's':
//					image = new SepiaFilter().applyFilter(image);
//					break;
//				case 'g':
//					image = new GrayScaleFilter().applyFilter(image);
//					break;
//				case 'w':
//					image = new BlurFilter().applyFilter(image);
//					break;
//				case '1':
//					image = new RGBShift(green, blue, red).applyFilter(image);
//					break;
//				case '2':
//					image = new RGBShift(blue, red, green).applyFilter(image);
//					break;
//				case '3':
//					image = new RGBShift(red, blue, green).applyFilter(image);
//					break;
//				case '4':
//					image = new RGBShift(green, red, blue).applyFilter(image);
//					break;
//				case '5':
//					image = new RGBShift(blue, green, red).applyFilter(image);
//					break;
//				default:
//					break;
//				}
//				// wenn noch nicht die Weite erreicht wurde, zeichne das Bild in
//				// dieselbe Spalte
//				// ansonsten wechsel in die nächste Spalte und wieder beginne
//				// ganz links
//				if (deltaX < collage.getWidth()) {
//					collage.createGraphics().drawImage(image, deltaX, deltyY,
//							null);
//					deltaX += width;
//				} else {
//					deltaX = 0;
//					deltyY += height;
//					collage.createGraphics().drawImage(image, deltaX, deltyY,
//							null);
//					deltaX += width;
//				}
//
////			}
//			ImageIO.write(collage, "jpg",
//					new File(cmd.getOptionValue(CMD_OPTION_DEST_FILE)));
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * Prüft Kommandozeilenargumente auf Gültigkeit
//	 * 
//	 * @param args
//	 *            Kommandozeilenargumente vom Benutzer
//	 * @return Bei Erfolg: CommandLine-Objekt mit den Werten der Optionen (und
//	 *         verbleibenden Argumente)
//	 * @throws ParseException
//	 *             Wird ausgelöst, wenn etwas mit den Kommandozeilenargumenten
//	 *             nicht stimmt.
//	 */
//	static CommandLine doCommandLineParsing(String[] args)
//			throws ParseException {
//		Options options = new Options();
//		Option opt;
//
//		opt = new Option(CMD_OPTION_SOURCE_FILE, "sourceFile", true,
//				"Die Ausgangsdatei");
//		opt.setRequired(true);
//		opt.setType(String.class);
//		options.addOption(opt);
//
//		opt = new Option(CMD_OPTION_DEST_FILE, "destFile", true,
//				"Die Zieldatei");
//		opt.setRequired(true);
//		opt.setType(String.class);
//		options.addOption(opt);
//
//		opt = new Option(CMD_OPTION_PATTERN, "pattern", true,
//				"Das Muster (default: osgw12345)");
//		opt.setRequired(false);
//		opt.setType(String.class);
//		options.addOption(opt);
//
//		CommandLineParser parser = new BasicParser();
//		CommandLine line = null;
//		line = parser.parse(options, args);
//
//		return line;
//	}
//}

package edu.kit.ipd.swt1.jmjrst.popart;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
	private static final String CMD_OPTION_SOURCE_FILE = "s";
	private static final String CMD_OPTION_DEST_FILE = "d";
	private static final String CMD_OPTION_PATTERN = "p";

	/**
	 * Privater Konstruktor verhindert Instanziierung
	 */
	private Main() {
	}

	/**
	 * Main-Methode: Liest Kommandozeilenargumente ein und ruft
	 * kit.edu.ipd.swt1.SimpleColorReduction entsprechend auf.
	 * 
	 * @param args
	 *            Kommandozeilenargumente vom Benutzer
	 */
	public static void main(String[] args) {
		CommandLine cmd = null;
		try {
			cmd = doCommandLineParsing(args);
		} catch (ParseException exception) {
			System.err
					.println("Mit den Kommandozeilenargumenten stimmt etwas nicht: "
							+ exception.getMessage());
			System.exit(1);
		}
		try {
			BufferedImage image = ImageIO.read(new File(cmd
					.getOptionValue(CMD_OPTION_SOURCE_FILE)));
			String optionValue = cmd.getOptionValue(CMD_OPTION_PATTERN,
					"osgw12345");
			BufferedImage collage = new SimplePopArtCollage().getCollage(image,
					optionValue);
			ImageIO.write(collage, "jpg",
					new File(cmd.getOptionValue(CMD_OPTION_DEST_FILE)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// try {
		// BufferedImage image = ImageIO.read(new File(cmd
		// .getOptionValue(CMD_OPTION_SOURCE_FILE)));
		// int width = image.getWidth();
		// int height = image.getHeight();
		// int type = image.getType();
		// int deltaX = 0;
		// int deltyY = 0;
		// String pattern = cmd
		// .getOptionValue(CMD_OPTION_PATTERN, "osgw12345");
		// BufferedImage collage = null;
		// if (pattern.length() == 4) {
		// collage = new BufferedImage(width * 2, height * 2, type);
		// } else if (pattern.length() == 9) {
		// collage = new BufferedImage(width * 3, height * 3, type);
		// }
		// for (char c : pattern.toCharArray()) {
		// image = ImageIO.read(new File(cmd
		// .getOptionValue(CMD_OPTION_SOURCE_FILE)));
		// switch (c) {
		// case 'o':
		// // Originalbild
		// break;
		// case 's':
		// image = new SepiaFilter().applyFilter(image);
		// break;
		// case 'g':
		// case 'w':
		// case '1':
		// case '2':
		// case '3':
		// case '4':
		// case '5':
		// break;
		// default:
		// break;
		// }
		//
		// // wenn noch nicht die Weite erreicht wurde, zeichne das Bild in
		// // dieselbe Spalte
		// // ansonsten wechsel in die nächste Spalte und wieder beginne
		// // ganz links
		// if (deltaX < collage.getWidth()) {
		// collage.createGraphics().drawImage(image, deltaX, deltyY,
		// null);
		// deltaX += width;
		// } else {
		// deltaX = 0;
		// deltyY += height;
		// collage.createGraphics().drawImage(image, deltaX, deltyY,
		// null);
		// deltaX += width;
		// }
		// }
		// ImageIO.write(collage, "jpg",
		// new File(cmd.getOptionValue(CMD_OPTION_DEST_FILE)));
		// } catch (IOException e) {
		// throw new RuntimeException(e);
		// }
	}

	/**
	 * Prüft Kommandozeilenargumente auf Gültigkeit
	 * 
	 * @param args
	 *            Kommandozeilenargumente vom Benutzer
	 * @return Bei Erfolg: CommandLine-Objekt mit den Werten der Optionen (und
	 *         verbleibenden Argumente)
	 * @throws ParseException
	 *             Wird ausgelöst, wenn etwas mit den Kommandozeilenargumenten
	 *             nicht stimmt.
	 */
	static CommandLine doCommandLineParsing(String[] args)
			throws ParseException {
		Options options = new Options();
		Option opt;

		opt = new Option(CMD_OPTION_SOURCE_FILE, "sourceFile", true,
				"Die Ausgangsdatei");
		opt.setRequired(true);
		opt.setType(String.class);
		options.addOption(opt);

		opt = new Option(CMD_OPTION_DEST_FILE, "destFile", true,
				"Die Zieldatei");
		opt.setRequired(true);
		opt.setType(String.class);
		options.addOption(opt);

		opt = new Option(CMD_OPTION_PATTERN, "pattern", true,
				"Das Muster (default: osgw12345)");
		opt.setRequired(false);
		opt.setType(String.class);
		options.addOption(opt);

		CommandLineParser parser = new BasicParser();
		CommandLine line = null;
		line = parser.parse(options, args);

		return line;
	}
}
