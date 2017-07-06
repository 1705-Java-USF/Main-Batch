package com.revature.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIOExample {
	FileOutputStream fos; // deals with bytes at a time (8 bit)
	FileInputStream fis;
	FileReader fr; // deals with characters at a time (16 bit)
	FileWriter fw;
	BufferedReader br; // deals with reading on a custom buffered limit, or by line basis
	BufferedWriter bw;

	static final String FILENAME = "fosOutputFile.txt";
	/*
	 * FileInput/OutputStreams streams on byte by byte basic. It writes/reads 8
	 * bits at a time. This transaction can become costly for a computer when
	 * you are dealing upwards of kilobytes.
	 * 
	 * ALWAYS CLOSE YOUR STREAMS to avoid data leaks. (Though Java by itself
	 * does a great job closing them for you, but why risk it?!)
	 */

	public static void main(String[] args) {
		FileIOExample fioe = new FileIOExample();

		try {
			fioe.writeFile(FILENAME);
			fioe.readFile(FILENAME);
			fioe.readFileViaFR(FILENAME);
			fioe.bufferedReadWrite(FILENAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeFile(String filename) throws IOException {

		char rand;
		try {
			fos = new FileOutputStream(filename);

			// For generating 'j' amount of lines of 'i' amount of random
			// letters
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 30; i++) {
					rand = (char) ((Math.random() * 26) + 65);
					fos.write((byte) rand);
				}
				fos.write('\n');
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			// Finally ALWAYS runs*, use it to close possible open streams
			if (fos != null) {
				fos.close();
			}
		}

	}

	public void readFile(String filename) throws IOException {

		try {
			fis = new FileInputStream(filename);

			// If you read a letter past the end of the file, you get -1
			/*
			 * Remember, FileInputStreams read 1 8bit (1byte) at a time. When
			 * calling read(), you will recieve the first letter, then the point
			 * where you read will be moved forward by one letter.
			 */

			/*
			 * System.out.println((char)fis.read());
			 * System.out.println((char)fis.read());
			 * System.out.println((char)fis.read());
			 * System.out.println((char)fis.read());
			 * System.out.println((char)fis.read());
			 * System.out.println((char)fis.read());
			 */

			byte in;
			while ((in = (byte) fis.read()) != -1) {
				System.out.print(in);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}

	public void readFileViaFR(String filename) throws IOException {
		try {
			/*
			 * FileReader/Writer reads characters at a time, (16 bits) This
			 * provides a faster means for read/writing to a file
			 */
			fr = new FileReader(filename);
			fw = new FileWriter("FWFile.txt");

			int in;
			while ((in = fr.read()) != -1) {

				if (in == 10)
					fw.write((char) (in)); // Makes each letter lowercase.
				else
					fw.write((char) (in + 32)); // Makes each letter lowercase.

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				fr.close();
			}
			if (fw != null) {
				fw.close();
			}
		}
	}
	
	public void bufferedReadWrite(String filename) throws IOException{
		System.out.println("\n==============================");
		try {
			br = new BufferedReader(new FileReader(filename));
			bw = new BufferedWriter(new FileWriter("PWFile.txt"));
			/*
			 * Readline works just like read(), except it pulls entire strings at a time.
			 * And instead of a numeric -1 saying we've reached end, we get a null string instead.
			 */
			String s = "";
			while((s = br.readLine())!=null){ 
				
				s += '\n';
				bw.write(s);
				

				
			}
			/*
			StringTokenizer st = new StringTokenizer("bob bob tom bob","o ");
			
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if( br != null){
				br.close();
			}
			if( bw != null){
				bw.close();
			}
		}
	}

}
