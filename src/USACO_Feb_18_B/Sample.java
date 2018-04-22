package USACO_Feb_18_B;

import java.io.*;
import java.util.*;

public class Sample {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("replace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("replace.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		pw.print(n1);
		pw.close();
	}
}
