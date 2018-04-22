package USACO_Feb_18_B;

import java.io.*;
import java.util.*;

public class P2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] pos = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int x = 0; x<n; x++) {
			pos[x] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pos);
		int balls = 0;
		int[] d = new int[n];
		d[0] = 1;
		d[n-1] = -1;
		
		for(int j = 1; j<n-1; j++) {
			int l = pos[j]-pos[j-1];
			int r = pos[j+1]-pos[j];
			if(l<=r) {
				d[j] = -1;
			}
			else {
				d[j] = 1;
			}
		}
		
		for(int k = 0; k<n-1; k++) {
			if(d[k]==1&&d[k+1]==-1) {
				if(k<n-2&&k>0) {
					if(d[k-1] == d[k]&&d[k+1] == d[k+2]) {
						balls+=2;
					}
					else {
						balls+=1;
					}
				}
				else if(k==0||k==n-2) {
					balls++;
				}
			}
		}
		
		pw.print(balls);
		pw.close();
	}
}
