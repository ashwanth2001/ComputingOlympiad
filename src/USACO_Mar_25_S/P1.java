package USACO_Mar_25_S;

import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/USACO_Mar_25_s/test1.txt"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/USACO_Mar_25_s/test2.txt")));
		//BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		for(int i = 0 ; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		int len = arr.length;
		long temp;
		long ans = 0;
		
		boolean sorted = false;
        while(!sorted) {
        	sorted = true;
        ans++;
            for (int j = 0; j < len-1; j++) {
                if (arr[j] > arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    sorted = false;
                }
            }
        }
        
		pw.print(ans);
		pw.close();
	}
}
