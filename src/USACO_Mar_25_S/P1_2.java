package USACO_Mar_25_S;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/USACO_Mar_25_s/test1.txt"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/USACO_Mar_25_s/test2.txt")));
		//BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		long[] sorted = new long[n];
		for(int i = 0 ; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			sorted[i] = arr[i];
		}
		long ans;
		
		if(n<25000) {
			int len = arr.length;
			long temp;
			ans = 0;
			
			boolean sorts = false;
	        while(!sorts) {
	        	sorts = true;
	        ans++;
	            for (int j = 0; j < len-1; j++) {
	                if (arr[j] > arr[j+1])
	                {
	                    temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                    sorts = false;
	                }
	            }
	        }
		}
		else {
			Arrays.sort(sorted);
			boolean[] taken = new boolean[n];
			ans = 0;
			int ind = 0;
		
			for(int i = 0; i<n; i++) {
				ind = binarySearch(sorted, 0, n-1, arr[i]);
				while(true) {
					if(ind == 0||sorted[ind-1]!=arr[i]) {
						break;
					}
					ind--;
				}
				while(true) {
					if(!taken[ind]) {
						taken[ind] = true;
						break;
					}
					ind++;
				}
				ans = Math.max(ans, Math.abs(ind-i));
			}
			ans++;
		}
		
		pw.print(ans);
		pw.close();
	}
	
	public static int binarySearch(long arr[], int l, int r, long x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            
            if (arr[mid] == x)
               return mid;
            
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
            
            return binarySearch(arr, mid+1, r, x);
        }
 
        return -1;
    }
}
