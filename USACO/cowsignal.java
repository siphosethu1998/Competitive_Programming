import java.io.*;
import java.util.*;

public class cowsignal {
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

	public static void main(String[] args) throws FileNotFoundException{
        File file = new File("cowsignal.in");
        InputReader r = new InputReader(new FileInputStream(file));
        PrintWriter pw = new PrintWriter("cowsignal.out");
        int m = r.nextInt();
        int n = r.nextInt();
        int k = r.nextInt();
        String line;

        for(int i=0; i<m; i++){
            line = r.next();
            for(int row=0; row<k; row++){
                for(int j=0; j<line.length(); j++){
                    if(line.charAt(j) == 'X'){
                        for(int l=0; l<k; l++){
                            pw.print('X');
                        }
                    }
                    else { // (r.nextInt() == '.'){
                        for(int l=0; l<k; l++){
                            pw.print('.');
                        }
                    }
                }
                pw.println();
            }
        }

		pw.close(); // flushes the output once printing is done
	}
}
