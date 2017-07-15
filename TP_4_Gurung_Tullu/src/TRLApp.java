import java.util.ArrayList;
import java.util.Scanner; 
public class TRLApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter from following options: \rEnter 1 to check book out. \rEnter 2 to check book in. \rEnter 3 for Help.");
		int task = scanner.nextInt();
		
		
		
		if(task == 1)//Checking Book Out 
		{
			System.out.println("Please enter Worker ID: options (W1)");
			String workerID = scanner.next();
			System.out.println("Please enter student ID: options (P1 , P2, P3)");
			String studentID = scanner.next();
			TRLAppController T1 = new TRLAppController(studentID, workerID);
			checkHoldOut(scanner, T1);
		}
		
		else if(task == 2) //Check Book In
		{	
			System.out.println("Please enter Worker ID:option (W1)");
			String workerID = scanner.next();
			System.out.println("Please enter student ID:option(P1, P2, P3)");
			String studentID = scanner.next();
			TRLAppController T1 = new TRLAppController(studentID, workerID);
			checkHoldIn(scanner, T1);
			
			
		}
		
		
		else 
		{
			System.out.println();
			System.out.println("Welcome to Helper");
			System.out.println("Press 1 and enter to check out a book and Press 2 and enter to check in a book when the application starts. \rYou will be asked for worker id and student id and copy id.");
			System.out.println("Worker id can be W1 as we have only one worker in the current system. Workerid helps track events.");
			System.out.println("For student id you have options: P1, P1 and P3.");
			System.out.println("For copy id you have options: C1, C2 and C3.");
			System.out.println("Follow the steps and when done the screen will print out the information on books still checked out by the patron or any holds of the patron.");
			System.out.println("To check for events, check for file TRLevent under folder Events.");
			System.out.println("Restart the application and Good Luck.");
		}
		
		

	}

	private static void checkHoldIn(Scanner scanner, TRLAppController T1) {
		if(T1.checkHold().equals("none") || T1.checkHold().equals(""))// check for Hold in the database
		{
			
			
			checkCopyIn(scanner, T1);
			
		
		}
		else System.out.println("Patron has a hold: " + T1.checkHold());// Print the hold 
	}

	private static void checkCopyIn(Scanner scanner, TRLAppController T1) {
		for(int i=0; i<10; i++)// checking in more than 1 books. Loops up to 10 with the understanding that no student will check out more than 10 books at a time. 
		{	
			ArrayList<String> allCopies = T1.getCopiesCheckedOut();
			System.out.println("Copies checked out: " + allCopies.toString());
			System.out.println("Please enter copy ID: options(C1, C2, C3)");
			String copyID = scanner.next();
			T1.setCopyID(copyID);
			ArrayList<String> copies = T1.checkCopyIn();
			System.out.println("Please enter 1 to check out another copy and 2 to exit");//whether to exit or check more copies out
			int option = scanner.nextInt();
			if(option == 2)
			{	
				System.out.println("Copies checked out: " + copies.toString());
				break;
				
			}
		}
	}

	private static void checkHoldOut(Scanner scanner, TRLAppController T1) {
		if(T1.checkHold().equals("none") || T1.checkHold().equals(""))// check for Hold in the database
		{
			
			
			checkoutCopies(scanner, T1);
			
		}
		else System.out.println("Patron has a hold: " + T1.checkHold());// Print the hold 
		
	}

	private static void checkoutCopies(Scanner scanner, TRLAppController T1) {
		for(int i=0; i<10; i++)// checking out more than 1 books. Loops up to 10 with the understanding that no student will check out more than 10 books at a time. 
		{	
			System.out.println("Please enter copy ID:");
			String copyID = scanner.next();
			T1.setCopyID(copyID);
			Patron P = T1.checkCopyOut();
			System.out.println("Please enter 1 to check out another copy and 2 to exit");//whether to exit or check more copies out
			int option = scanner.nextInt();
			if(option == 2)
			{	
				System.out.println(P);
				break;
				
			}
		}
	}
}


