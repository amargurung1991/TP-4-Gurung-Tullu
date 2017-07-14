import java.util.Calendar;

public class TRLAppController 
{
	private String studentID;
	private String copyID;
	private String workerID;

	
	
	public void setCopyID(String copyId)
	{
		this.copyID = copyId;
	}
	public TRLAppController(String studentID, String workerID)
	{
		this.studentID = studentID;
		this.workerID = workerID;
		
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
		Responder R1 = new Responder();
		R1.copyCheckedOut(copyID, this.studentID, this.workerID);
		return P1;
	}
	
	public Patron checkCopyIn()
	{
		Patron P1 = LibraryDB.getPatron(this.studentID);
		Copy c1 = LibraryDB.getCopy(copyID);
		if(P1.getId().equals(c1.getOutTo().getId()))
		{
			P1.checkCopyIn(c1);
		}
		Responder R1 = new Responder();
		R1.copyCheckedIn(copyID, this.studentID, this.workerID);
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
