import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		DataHandler H1 = new DataHandler();
		H1.insertData(this.studentID, this.copyID, getReturnDate());
		Responder R1 = new Responder();
		R1.copyCheckedOut(copyID, this.studentID, this.workerID);
		return P1;
	}
	
	public Patron checkCopyIn()
	{
		Patron P1 = LibraryDB.getPatron(this.studentID);
		DataHandler H1 = new DataHandler();
		H1.removeData(this.studentID, this.copyID);
		Responder R1 = new Responder();
		R1.copyCheckedIn(copyID, this.studentID, this.workerID);
		return P1;
	}
	
	
	
	public Patron CheckOutComplete()
	{
		
					return checkCopyOut();
					
			
	}
	
	public String getReturnDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, +120);
				 Date todate1 = cal.getTime();    
			        String returnDate = dateFormat.format(todate1);
				return  returnDate;
	}
	
	

	public static void main(String[] args) 
	{
	
		

	}

}
