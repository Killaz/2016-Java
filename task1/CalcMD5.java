import java.io.*;
import java.util.Scanner;
import java.DigestUtils.MD5;

class CalcMD5 {
	public static void main (String[] args) throws Exception {
		Scanner in, file;
		String name = "", strOfFile;
		if (args.length > 1)
			in = new Scanner(args[1]);
		else
			in = new Scanner(new FileReader("input.txt"));
		while (in.hasNext()) {
			name = in.next();
			file = new Scanner(new FileReader(name));
			file.useDelimiter("");      // read char-s
			strOfFile = "";
			while (file.hasNext())
				strOfFile += file.next();
			file.close();
			System.out.println(DigestUtils.md5Hex(strOfFile));
//			System.out.println(strOfFile);
			
		}
	}
}
