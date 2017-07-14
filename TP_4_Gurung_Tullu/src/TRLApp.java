import java.util.Scanner; 
public class TRLApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 1 for Checking book out and 2 for checking book in:");
		int task = scanner.nextInt();
		
		if(task == 1)
		{
			System.out.println("Please enter student ID:");
			String studentID = scanner.next();
			TRLAppController T1 = new TRLAppController(studentID);
			if(T1.checkHold().equals(""))
			{
				for(int i=0; i<100; i++)
				{
					System.out.println("Please enter copy ID:");
					String copyID = scanner.next();
					T1.setCopyID(copyID);
					T1.checkCopyOut();
					System.out.println("Please 1 to enter another copy ID and 2 to exit");
					int option = scanner.nextInt();
					if(option == 2)
					{
						break;
					}
				}
				System.out.println(T1.checkCopyOut());
				System.out.println("Due Date: " + T1.returnDate());
				
				
				
			}
			else System.out.println("Patron has a hold: " + T1.checkHold());
			
			
		}
		
		
		

	}

}
