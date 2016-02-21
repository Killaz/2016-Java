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
		Scanner in, file;
		String name = "";
		if (args.length > 1)
			in = new Scanner(args[1]);
		else
			in = new Scanner(new FileReader("input.txt"));
		while (in.hasNext()) {
			byte strOfFile[] = new byte[4], tmp[];
			char c;
			int len = 0, maxlen = 4;
			name = in.next();
			file = new Scanner(new FileReader(name));
			file.useDelimiter("");      // read char-s
			while (file.hasNext()) {
				c = in.next().charAt(0);
				if (len == maxlen) {
					tmp = strOfFile;
					strOfFile = new byte[maxlen * 2];
					for (int i = 0; i < len; i++)
						strOfFile[i] = tmp[i];
					maxlen *= 2;
					tmp = null;
				}
				System.out.println("Lol)) " + c);
				strOfFile[len] = (byte) c;
				len++;
				
			}
			file.close();

			MessageDigest md = MessageDigest.getInstance("MD5");
/*			Path path = Paths.get(sc.nextLine());
			byte[] data = Files.readAllBytes(path);
			md.update(data, 0, data.length); */
			md.update(strOfFile, 0, strOfFile.length);
			System.out.println(DatatypeConverter.printHexBinary(md.digest()));
		}
		in.close();
	}
}
