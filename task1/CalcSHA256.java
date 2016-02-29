import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

public class CalcSHA256 {
	public static void main (String[] args) throws Exception {
		Scanner in;
		String name = "";
		if (args.length > 0) {
			in = new Scanner(new FileReader(args[0]));
		} else {
			in = new Scanner(new FileReader("input.txt"));
		}
		while (in.hasNextLine()) {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
//			System.out.println("Line was   =     " + name);
			name = in.nextLine();
//			System.out.println("Line       =     " + name);

			Path file = Paths.get(name);
			byte[] strOfFile = Files.readAllBytes(file);
			md.update(strOfFile);

			System.out.println(DatatypeConverter.printHexBinary(md.digest()));
		}
		in.close();
	}
}
