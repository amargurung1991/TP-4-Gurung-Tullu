import java.util.Scanner; 
public class TRLApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter from following options: \rEnter 1 to check book out \rEnter 2 to check book in \rEnter 3 for Help");
		int task = scanner.nextInt();
		System.out.println("Please enter Worker ID:");
		String workerID = scanner.next();
		
		if(task == 1)//Checking book out 
		{
			
			System.out.println("Please enter student ID:");
			String studentID = scanner.next();
			TRLAppController T1 = new TRLAppController(studentID, workerID);
			if(T1.checkHold().equals(""))// check for Hold in the database
			{
				
				
				for(int i=0; i<10; i++)// checking out more than 1 books. Loops up to 10 with the understanding that no student will check out more than 10 books at a time. 
				{	
					System.out.println("Please enter copy ID:");
					String copyID = scanner.next();
					T1.setCopyID(copyID);
					Patron P = T1.checkCopyOut();
					System.out.println("Please enter 1 to check out another copy and 2 to check In books");//whether to exit or check more copies out
					int option = scanner.nextInt();
					if(option == 2)
					{	
						
						break;
						
					}
				}
				
			
	}
			else System.out.println("Patron has a hold: " + T1.checkHold());// Print the hold 
			
			
		}
		
		if(task == 2) //Check Book In
			
			System.out.println("Please enter student ID:");
			String studentID = scanner.next();
			TRLAppController T1 = new TRLAppController(studentID, workerID);
			if(T1.checkHold().equals(""))// check for Hold in the database
			{
				
				
				for(int i=0; i<10; i++)// checking in more than 1 books. Loops up to 10 with the understanding that no student will check out more than 10 books at a time. 
				{	
					System.out.println("Please enter copy ID:");
					String copyID = scanner.next();
					T1.setCopyID(copyID);
					Patron P = T1.checkCopyIn();
					System.out.println("Please enter 1 to check out another copy and 2 to check In books");//whether to exit or check more copies out
					int option = scanner.nextInt();
					if(option == 2)
					{	
						
						break;
						
					}
				}
				
			
			}
			else System.out.println("Patron has a hold: " + T1.checkHold());// Print the hold 
			
			
		}
		
		

	}


