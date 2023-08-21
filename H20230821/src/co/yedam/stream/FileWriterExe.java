package co.yedam.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//FileWriter : 문자열 기반 파일 출력 스트림
public class FileWriterExe {
	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			FileWriter fw = new FileWriter("src/co/yedam/stream/data.txt");
			
			System.out.println("start");
			while (true) {
				String line = sc.nextLine();
				if (line.equals("quit")) {
					break;
				}
				fw.write(line + '\n');
			}
			System.out.println("end");
			
			fw.flush();
			fw.close();
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
