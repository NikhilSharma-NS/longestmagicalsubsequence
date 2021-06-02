package com.java.code;

import java.util.Scanner;

public class LongestSubsequence {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		System.out.println(longestSubsequence(input));
		sc.close();
	}
	static int longestSubsequence(String inputstring) {
        if (inputstring.length() < 5) {
            return 0;
        } 
        int i = 0;
        while (i < inputstring.length() && inputstring.charAt(i) != 'a') i++;
        while (i < inputstring.length() && inputstring.charAt(i) != 'e') i++;
        while (i < inputstring.length() && inputstring.charAt(i) != 'i') i++;
        while (i < inputstring.length() && inputstring.charAt(i) != 'o') i++;
        while (i < inputstring.length() && inputstring.charAt(i) != 'u') i++;
        if (i > inputstring.length() - 1) return 0;
        int[][] mem = new int[inputstring.length()][5];
        for (i = 0; i < inputstring.length(); i++) 
            for (int j = 0; j < 5; j++) 
                mem[i][j] = -1;
        int result = longestSubsequence(inputstring, "aeiou", mem);
        return result;

    }
	static int longestSubsequence(String inputstring, String searchStr, int[][] mem) { 
        int i = 0;
        int maxCnt = 0;
        if (searchStr == null || inputstring == null) return 0;        
        if (inputstring.length() == 0 || searchStr.length() == 0) return 0;   
        if (mem[inputstring.length() - 1][searchStr.length() - 1] != -1) return mem[inputstring.length() - 1][searchStr.length() - 1];
        while (i < inputstring.length()) {
            while (i < inputstring.length() && inputstring.charAt(i) != searchStr.charAt(0)) i++;
            if (i < inputstring.length()) {   
                int maxCnt2 = longestSubsequence(inputstring.substring(i+1), searchStr.substring(1), mem) + 1;    
                if (inputstring.length() > 1 && searchStr.length() > 1 && maxCnt2 == 0) {
                    return Integer.MIN_VALUE;
                }
                int maxCnt1 = longestSubsequence(inputstring.substring(++i), searchStr, mem) + 1;
                if (inputstring.length() > 1 && maxCnt1 == 0) {
                    return Integer.MIN_VALUE;
                }
                maxCnt = Math.max(maxCnt, Math.max(maxCnt1, maxCnt2));                 
            } 
        }
        mem[inputstring.length() - 1][searchStr.length() - 1] = maxCnt;
        return maxCnt;

    }
}
