package USACO_Feb_18_B;

import java.io.*;
import java.util.*;

public class P3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] cal = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int x = 0; x<n; x++) {
			cal[x] = Integer.parseInt(st.nextToken());
		}
		
		int[] fin = new int[n];
		fin[0] = 1;
		boolean ret = true;
		
		for(int i = 1; i<n; i++) {
			int num = cal[i];
			if(num!=-1) {
				for(int j = 0; j<num; j++) {
					if(fin[i-j]==1) {
						ret = false;
						break;
					}
					fin[i-j] = -1;
				}
				fin[i-num] = 1;
			}
		}
		
		int min = 0;
		int max = 0;
		
		for(int k = 0; k<n; k++) {
			if(fin[k] == 0) {
				max++;
			}
			if(fin[k] == 1) {
				min++;
				max++;
			}
		}
		
		if(ret) {
			pw.print(min + " " + max);
		}
		else {
			pw.print(-1);
		}
		pw.close();
	}
}
