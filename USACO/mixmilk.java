import java.io.*;
import java.util.*;

public class mixmilk {
	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		String next() { // reads in the next string
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() { // reads in the next int
			return Integer.parseInt(next());
		}
		public long nextLong() { // reads in the next long
			return Long.parseLong(next());
		}
		public double nextDouble() { // reads in the next double
			return Double.parseDouble(next());
		}
	}
	static InputReader r = new InputReader(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws FileNotFoundException {
        File file = new File("mixmilk.in");
        InputReader r = new InputReader(new FileInputStream(file));
        PrintWriter pw = new PrintWriter("mixmilk.out");

        int[][] cmArr = new int[3][2];
        cmArr[0][0] = r.nextInt();
        cmArr[0][1] = r.nextInt();
        cmArr[1][0] = r.nextInt();
        cmArr[1][1] = r.nextInt();
        cmArr[2][0] = r.nextInt();
        cmArr[2][1] = r.nextInt();

        if(cmArr[0][1] == 0 && cmArr[1][1] == 0 && cmArr[2][1] == 0) {
            pw.println(cmArr[0][1]);
            pw.println(cmArr[1][1]);
            pw.println(cmArr[2][1]);
            return;
        }

        for(int i=1; i<=100; i++){
            if(cmArr[(i-1)%3][1] + cmArr[i%3][1] <= cmArr[i%3][0]) {
                cmArr[i%3][1] += cmArr[(i-1)%3][1];
                cmArr[(i-1)%3][1] = 0;
            }
            else { // bucket i overflows
                cmArr[(i-1)%3][1] = cmArr[(i-1)%3][1] + cmArr[i%3][1] - cmArr[i%3][0];
                cmArr[i%3][1] = cmArr[i%3][0];
            }
        }
        pw.println(cmArr[0][1]);
        pw.println(cmArr[1][1]);
        pw.println(cmArr[2][1]);

		pw.close(); // flushes the output once printing is done
	}
}
