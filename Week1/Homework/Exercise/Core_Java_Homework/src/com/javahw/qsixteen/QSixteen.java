package com.javahw.qsixteen;

public class QSixteen {

	public static void main(String[] args) {
		int count = 0;
		
		//Count the amount of characters for each string in args
		for(String str : args){
			for(int i = 0; i < str.length(); i++){
				count++;
			}
		}
		System.out.println(count);
	}
}
