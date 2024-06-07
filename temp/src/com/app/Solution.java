package com.app;

import java.util.Scanner;

public class Solution {

	 public static void main(String[] args) throws Exception {
	        Scanner scanner = new Scanner(System.in);
	        int Q = scanner.nextInt(); // Number of queries
	        
	        for (int i = 0; i < Q; i++) {
	            int l = scanner.nextInt(); // Start of range
	            int r = scanner.nextInt(); // End of range
	            
	            int count = countEmployees(l, r);
	            System.out.println(count);
	        }
	        scanner.close();
	    }
	    
	    // Function to count the number of employees who are kept by the company
	    static int countEmployees(int l, int r) {
	        int count = 0;
	        for (int n = l; n < r; n++) { // O(r - l)
	            for (int x = 1; x*x <= n && x*x < r; x++) { // O(sqrt(r))
	                if (n % x == 0 && n >= x*x && n < (x+1)*(x+1)) { // Constant time
	                    count++;
	                    break;
	                }
	            }
	        }
	        return count;
	    }
}
