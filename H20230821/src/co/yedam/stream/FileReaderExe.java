package co.yedam.stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExe {
	public static void main(String[] args) {
		
		try {
			
			File file = new File("src/co/yedam/stream/data.txt");
			FileReader fr = new FileReader(file);
			
			char[] buf = new char[100];
			
			while(true) {
				int val = fr.read(buf); // 원래는 2Bytes씩 처리함(문자 단위이므로)
				if(val == -1) {
					break;
				}
				//출력은 이런식으로 해주면 됨
				for (int i = 0; i < val; i++) {
					System.out.print(buf[i]);
				}	
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
