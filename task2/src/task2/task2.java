package task2;

import java.util.Scanner;
import java.util.Random;

public class task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		
		while(true)
		{
			System.out.println("가위 바위 보!>>");
			String user = scan.nextLine();
			
			if(user.equals("그만"))
			{
				System.out.println("게임을 종료합니다...");
				break;
			}
			
			int computerint = random.nextInt(2);
			String computer;
			
			if(computerint==0)
				computer = "가위";
			else if(computerint==1)
				computer = "바위";
			else
				computer="보";
			
			System.out.print("사용자 = "+user +", 컴퓨터 = "+computer+", ");
			
			if(user.equals("가위"))
			{
				if(computer=="가위")
					System.out.println("비겼습니다.");
				else if(computer=="바위")
					System.out.println("사용자가 졌습니다.");
				else
					System.out.println("사용자가 이겼습니다.");
			}
			else if(user.equals("바위"))
			{
				if(computer=="가위")
					System.out.println("사용자가 이겼습니다.");
				else if(computer=="바위")
					System.out.println("비겼습니다.");
				else
					System.out.println("사용자가 졌습니다.");
			}
			else if(user.equals("보"))
			{
				if(computer=="가위")
					System.out.println("사용자가 졌습니다.");
				else if(computer=="바위")
					System.out.println("사용자가 이겼습니다.");
				else
					System.out.println("비겼습니다.");
			}
			else
				System.out.println("잘못입력하였습니다.");
		}	
		
		scan.close();
	}

}
