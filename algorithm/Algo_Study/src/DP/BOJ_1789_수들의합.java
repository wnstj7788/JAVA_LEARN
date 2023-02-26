package DP;

import java.util.Scanner;

public class BOJ_1789_수들의합 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long num = scan.nextLong();
		long sum = 0;
		int count = 0;
		
		for(int i=1; ; i++) {
			if(sum > num)	break;
			sum += i;
			count ++;
		}
		System.out.println(count-1);
		scan.close();
	}

}