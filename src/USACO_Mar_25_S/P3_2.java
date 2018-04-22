package USACO_Mar_25_S;

import java.io.*;
import java.util.*;

public class P3_2 {
	ArrayList<Integer> ret = new ArrayList<Integer>();
	int num = 0;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("src/USACO_Mar_25_s/test1.txt"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/USACO_Mar_25_s/test2.txt")));
		BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[][] board = new long[n][n];
		boolean[][] check = new boolean[n][n];
		
		int[] list1 = new int[1000000];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				board[i][j] = Long.parseLong(st.nextToken());
				list1[(int) board[i][j]] = (int) board[i][j];
			}
		}
		
		P3_2 p = new P3_2();
		ArrayList<Integer> save;
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		int max = 1;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!check[i][j]) {
					p.method1(check, board, i, j);
					save = p.getArrayList();
					if(save.size()>0) {
						lists.add(save);
						max = Math.max(max, save.size()/2);
					}
					check[i][j] = true;
				}
			}
		}
		
		pw.print(max + "\n");
		//System.out.println(max);
		
		Collections.sort(lists, new Comparator<ArrayList>(){
		    public int compare(ArrayList a1, ArrayList a2) {
		        return a2.size() - a1.size(); // assumes you want biggest to smallest
		    }
		});
		
		long a = 0;
		long b = 0;
		int max1 = 2;
		int s1 = 0;
		
		for(int i = 0; i<list1.length; i++) {
			a = list1[i];
			for(int j = i+1; j<lists.size(); j++) {
				check = new boolean[n][n];
				b = list1[j];
				//fix next line
				p.method2(check, board, a, b, lists.get(j).get(0), lists.get(j).get(1));
				s1 = p.getNum();
				max1 = Math.max(max1, s1);
				if(max == n*n)
					break;
				p.clear();
			}
			if(max == n*n)
				break;
		}
		
		//System.out.println(max1);
		pw.print(max1);
		pw.close();
	}
	
	public void method1(boolean[][] check, long[][] board, int x, int y) {
		int i = -1;
		int j = 0;
		if(x+i>=0&&x+i<check.length&&check[x+i][y+j] == false&&board[x+i][y+j]==board[x][y]) {
			check[x+i][y+j] = true;
			ret.add(x+i);
			ret.add(y+j);
			method1(check, board,x+i,y+j);
		}
		
		i+=2;
		if(x+i>=0&&x+i<check.length&&check[x+i][y+j] == false&&board[x+i][y+j]==board[x][y]) {
			check[x+i][y+j] = true;
			ret.add(x+i);
			ret.add(y+j);
			method1(check, board,x+i,y+j);
		}
		
		i--;
		j--;
		if(y+j>=0&&y+j<check.length&&check[x+i][y+j] == false&&board[x+i][y+j]==board[x][y]) {
			check[x+i][y+j] = true;
			ret.add(x+i);
			ret.add(y+j);
			method1(check, board,x+i,y+j);
		}
		
		j+=2;
		if(y+j>=0&&y+j<check.length&&check[x+i][y+j] == false&&board[x+i][y+j]==board[x][y]) {
			check[x+i][y+j] = true;
			ret.add(x+i);
			ret.add(y+j);
			method1(check, board,x+i,y+j);
		}
	}
	
	public void method2(boolean[][] check, long[][] board, long a, long b, int x, int y) {
		int i = -1;
		int j = 0;
		if(x+i>=0&&x+i<check.length&&check[x+i][y+j] == false&&(board[x+i][y+j]==a||board[x+i][y+j]==b)) {
			check[x+i][y+j] = true;
			num++;
			method2(check, board, a, b, x+i,y+j);
		}
		
		i+=2;
		if(x+i>=0&&x+i<check.length&&check[x+i][y+j] == false&&(board[x+i][y+j]==a||board[x+i][y+j]==b)) {
			check[x+i][y+j] = true;
			num++;
			method2(check, board, a, b, x+i,y+j);
		}
		
		i--;
		j--;
		if(y+j>=0&&y+j<check.length&&check[x+i][y+j] == false&&(board[x+i][y+j]==a||board[x+i][y+j]==b)) {
			check[x+i][y+j] = true;
			num++;
			method2(check, board, a, b, x+i,y+j);
		}
		
		j+=2;
		if(y+j>=0&&y+j<check.length&&check[x+i][y+j] == false&&(board[x+i][y+j]==a||board[x+i][y+j]==b)) {
			check[x+i][y+j] = true;
			num++;
			method2(check, board, a, b, x+i,y+j);
		}
	}
	
	public ArrayList<Integer> getArrayList(){
		ArrayList<Integer> save = ret;
		ret = new ArrayList<Integer>();
		return save;
	}
	
	public int getNum() {
		return num;
	}
	
	public void clear() {
		num = 0;
	}
}
