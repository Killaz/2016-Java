import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class CalcMD5 {
	public static void main (String[] args) throws Exception {
		Scanner in;
		String name = "";
		if (args.length > 1)
			in = new Scanner(args[1]);
		else
			in = new Scanner(new FileReader("input.txt"));
		while (in.hasNext()) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			name = in.nextLine();

			Path file = Paths.get(name);
			byte[] strOfFile = Files.readAllBytes(file);
			md.update(strOfFile, 0, strOfFile.length);

			System.out.println(DatatypeConverter.printHexBinary(md.digest()));
		}
		in.close();
	}
}
