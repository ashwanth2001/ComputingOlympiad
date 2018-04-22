package USACO_Feb_18_B;

import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d1 = Math.abs(b-a);
		int d2 = Math.abs(x-a)+Math.abs(b-y);
		int d3 = Math.abs(x-b)+Math.abs(a-y);
		int fin = Math.min(d1,Math.min(d2, d3));
		pw.print(fin);
		pw.close();
	}
}
