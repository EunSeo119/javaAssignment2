import java.util.Scanner;

class Seat{
	private String seat[];
	
	public Seat() {
		seat = new String[10];
		for(int i=0; i<10;i++) {
			seat[i]="---";
		}
	}
	
	public void PrintSeat() {
		for(int i=0;i<10;i++) {
			System.out.print(seat[i]+" ");
		}
		System.out.println();
	}
	
	public void Push(String name, int num) {
		if(num>10)
			System.out.println("없는 좌석이므로 예약하실 수 없습니다.");
		else
			seat[num-1] = name;
	}
	
	public int rePush(String name) {
		for(int i=0;i<10;i++) {
			if(name.equals(seat[i])) {
				seat[i]="---";
				return 1;
			}
		}
		return 0;
	}
}

class Menu{
	Scanner scan = new Scanner(System.in);
	private Seat s[];
	private String seatLevel[]= {"S", "A", "B"};
	
	public Menu() {
		s = new Seat[3];
		for(int i=0; i<3;i++) {
			s[i] = new Seat();
		}
	}
	
	public void runMenu() {
		int menuNum;
		while(true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			menuNum = scan.nextInt();
			
			switch(menuNum) {
			case 1:
				Reserve();
				break;
			
			case 2:
				Show();
				break;
			
			case 3:
				Cancel();
				break;
			
			case 4:
				return;
				
			default:
				System.out.println("없는 메뉴입니다. 다시 입력하여주세요.");
				
			}
		}
	}
	
	public void Reserve() {
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int level = scan.nextInt();
		if(level>3)
			System.out.println("없는 좌석이므로 예약하실 수 없습니다.");
		else {
			System.out.print(seatLevel[level-1]+">>");
			s[level-1].PrintSeat();
			
			System.out.print("이름>>");
			String name = scan.next();
			System.out.print("번호>>");
			int num = scan.nextInt();
			s[level-1].Push(name, num);			
		}
	}
	
	public void Show() {
		for(int i=0;i<3;i++) {
			System.out.print(seatLevel[i]+">>");
			s[i].PrintSeat();
		}
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	public void Cancel() {
		System.out.print("좌석 S:1, A:2, B:3>>");
		int level = scan.nextInt();
		System.out.print(seatLevel[level-1]+">>");
		s[level-1].PrintSeat();
		
		System.out.print("이름>>");
		String name = scan.next();
		
		int result = s[level-1].rePush(name);
		if(result == 0)
			System.out.println("존재하지 않는 이름이므로 취소할 수 없습니다.");
	}
	
}

public class ConcertSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		Menu m = new Menu();
		m.runMenu();
	}

}
