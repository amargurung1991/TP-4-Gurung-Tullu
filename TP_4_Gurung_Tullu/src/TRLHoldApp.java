import java.util.Scanner;

public class TRLHoldApp {
	//Add or remove holds to different Patrons
	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);	
	System.out.println("Please enter 1 for entering holds and 2 for deleting holds.");
	int task = scanner.nextInt();
	System.out.println("Please enter Worker ID: options (W1)");
	String workerID = scanner.next();
	System.out.println("Please enter student ID: options (P1 , P2, P3)");
	String studentID = scanner.next();
	TRLAppController T1 = new TRLAppController(studentID, workerID);
	
	if(task == 1)//adding hold
	{
		System.out.println("Please enter the hold:(option: overdue)");
		String hold = scanner.next();
		T1.setHold(hold);
		T1.addHolds();
		
	}
	
	else
	{
		T1.removeHold();
	}
	
	}

}
