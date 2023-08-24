package co.yedam.practice.mailing;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import co.yedam.common.SendMail;

public class MainExe {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				playWave();
			}
		});
		
		boolean run = true;
		
		while (run) {
			System.out.println("1.추가 2.목록 3.메일 4.종료");
			System.out.println("선택 >>");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
				case 1:
					System.out.println("추가합니다..");
					break;
				case 2:
					System.out.println("목록보기입니다..");
					break;
				case 3:
					send();
					break;
				case 4:
					System.out.println("프로세스를 종료합니다.");
					run = false;
					break;
				default:
			}
		}
		
	}

	static void playWave() {
		try {
			File file = new File("src/co/yedam/audio/sample.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
//			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void send() {
		System.out.println("수신자 이메일 : ");
		String to = scn.nextLine();
		
		System.out.println("제목 : ");
		String title = scn.nextLine();
		
		System.out.println("내용 : ");
		String content = scn.nextLine();
		
		SendMail sendMail = new SendMail();
		sendMail.sendMail(to, title, content);
	}
	
}
