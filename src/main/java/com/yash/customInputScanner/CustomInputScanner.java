package com.yash.customInputScanner;

import java.util.Scanner;

public class CustomInputScanner {
	
	final Scanner scanner = new Scanner(System.in);
	

	public Integer getInput(String message) {
		return scanner.nextInt();
	}
	
}
