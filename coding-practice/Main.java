import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new File("input.txt"));

			int a = in.nextInt();
			int b = in.nextInt();
			PrintWriter out = new PrintWriter("output.txt");
			out.println(a + b);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}

