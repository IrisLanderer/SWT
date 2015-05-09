package edu.kit.ipd.swt1.jmjrst.popart;
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
		
		
		System.out.println(cmd.getOptionValue(CMD_OPTION_PATTERN, "osgw12345"));
		System.out.println(cmd.getOptionValue(CMD_OPTION_SOURCE_FILE));
		System.out.println(cmd.getOptionValue(CMD_OPTION_DEST_FILE));
		
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

		opt = new Option(CMD_OPTION_SOURCE_FILE, "sourceFile", true, "Die Ausgangsdatei");
		opt.setRequired(true);
		opt.setType(String.class);
		options.addOption(opt);

		opt = new Option(CMD_OPTION_DEST_FILE, "destFile", true, "Die Zieldatei");
		opt.setRequired(true);
		opt.setType(String.class);
		options.addOption(opt);

		opt = new Option(CMD_OPTION_PATTERN, "pattern", true, "Das Muster (default: osgw12345)");
		opt.setRequired(false);
		opt.setType(String.class);
		options.addOption(opt);


		CommandLineParser parser = new BasicParser();
		CommandLine line = null;
		line = parser.parse(options, args);

		return line;
	}
}
