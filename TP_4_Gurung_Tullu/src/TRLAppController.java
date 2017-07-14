import java.util.Calendar;
//import java.util.Date;
public class TRLAppController 
{
	private String studentID;
	private String copyID;

	
	
	public void setCopyID(String copyId)
	{
		this.copyID = copyId;
	}
	public TRLAppController(String studentID)
	{
		this.studentID = studentID;
		//this.copyID = copyID;
	}
	
	
	public String checkHold()
	{
		return LibraryDB.getPatron(this.studentID).getHold();
	}
	
	public Patron checkCopyOut()
	{
		Patron P1 = LibraryDB.getPatron(this.studentID);
		Copy c1 = LibraryDB.getCopy(copyID);
		P1.checkCopyOut(c1);
		return P1;
	}
	
	public String returnDate()
	{
		Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 120);
				
	
		return cal.getTime().toString();
	}
	
	public Patron CheckOutComplete()
	{
		
					return checkCopyOut();
					
			
	}
	
	

	public static void main(String[] args) 
	{
	
		

	}

}
