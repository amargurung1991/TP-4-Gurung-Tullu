import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TRLAppController 
{
	private String studentID;
	private String copyID;
	private String workerID;
	private String hold;
	
	public void setHold(String hold)
	{
		this.hold = hold;
	}
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
		DataHandler D1 = new DataHandler();
		return D1.retreiveHold(studentID);
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
	
	public ArrayList<String> checkCopyIn()
	{
		DataHandler H1 = new DataHandler();
		H1.removeData(this.studentID, this.copyID);
		Responder R1 = new Responder();
		R1.copyCheckedIn(copyID, this.studentID, this.workerID);
		ArrayList<String> copies = H1.getCopies(this.studentID);
		return copies;
	}
	
	public ArrayList<String> getCopiesCheckedOut()
	{
		DataHandler H1 = new DataHandler();
		ArrayList<String> copies = H1.getCopies(this.studentID);
		return copies;
	}
	
	public void addHolds()
	{
		DataHandler H1 = new DataHandler();
		H1.addHold(this.studentID, this.hold);
		Responder R1 = new Responder();
		R1.addHold(studentID, workerID, hold);
	}
	
	public void removeHold()
	{
		DataHandler H1 = new DataHandler();
		H1.deleteHold(this.studentID);
		Responder R1 = new Responder();
		R1.removeHold(studentID, workerID);
	}
	
	
	
	

	public static void main(String[] args) 
	{
	
		

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
	
}
