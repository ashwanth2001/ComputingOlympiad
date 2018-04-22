package USACO_Mar_25_S;

import java.io.*;
import java.util.*;

public class P2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/USACO_Mar_25_s/test1.txt"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/USACO_Mar_25_s/test2.txt")));
		//BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] cows = new long[n];
		for(int i = 0; i<n; i++) {
			cows[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(cows);
		long ans = n;
		for(int i = n-1; i>=0; i--) {
			if(cows[i]<(n-1)-i) {
				ans = (n-1)-i;
				break;
			}
		}
		
		pw.print(ans);
		pw.close();
	}
}
