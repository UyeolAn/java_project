package co.yedam.practice.thread;

public class BeepPrintExe {
	public static void main(String[] args) {
		
		Thread beep;
		
		// Thread 를 상속하는 클래스를 작성하여 생성하는 방식
		beep = new WorkThread();
		
		// Runable 구현체를 Thread 생성자 매개변수로 넣어서 사용하는 방식
		beep = new Thread(new BeepTask()); // 만들어진 구현체를 넣음
		beep = new Thread(new Runnable() { // 익명 클래스 형태로 넣음
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		beep.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("텍스트");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
