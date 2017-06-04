package com.revature.question18;

public class QuestionEighteen{

		//class that runs the things implemented in questioneighteens
		public static void main(String[] args) {
			QuestionEighteenA qe = new QuestionEighteenS();
			System.out.println(qe.changeUpperCase("Hello World"));
			System.out.println(qe.checkUpperCase("hello world"));
			qe.convertToNumber("hello world");
		}

	}