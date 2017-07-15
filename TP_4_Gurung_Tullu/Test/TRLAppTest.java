import static org.junit.Assert.*;

import org.junit.Test;



public class TRLAppTest {

	@Test
	public void testPatron() {
		Patron P1 = new Patron("A1", "Amar");
		assertEquals("Amar",P1.getName());
		assertEquals("A1", P1.getId());
		
		
	}
	
	@Test
	public void testCopy()
	{
		Copy C1 = new Copy("C1", "The Deathly Hallows");
		assertEquals("C1", C1.getCopyID());
		assertEquals("The Deathly Hallows",C1.getTitle());
	}
	
	@Test
	public void testCopyCheckOut()
	{
		Patron P1 = new Patron("A1", "Amar");
		Copy C1 = new Copy("C1", "The Deathly Hallows");
		C1.setOutTo(P1);
		assertEquals(P1, C1.getOutTo());
	}
	
	
	@Test
	public void testCopyCheckInOut()
	{
		Patron P1 = new Patron("A1", "Amar");
		Copy C1 = new Copy("C1", "The Deathly Hallows");
		
		//CheckingOut
		P1.checkCopyOut(C1);
		assertEquals(P1, C1.getOutTo());
		
		
		
		//CheckingIn
		P1.checkCopyIn(C1);
		assertEquals(null,C1.getOutTo());
		
		
	}
	
	
	
	
	@Test
	public void testEventCheckIn()
	{
		Responder R1 = new Responder();
		R1.copyCheckedIn("C3", "U3", "W1");
	}
	
	@Test
	public void testEventCheckOut()
	{
		Responder R1 = new Responder();
		R1.copyCheckedOut("C3", "U3", "W1");
	}
	

	@Test
	public void testEventCheckOut1()
	{
		Responder R1 = new Responder();
		R1.copyCheckedOut("C3", "U3", "W1");
	}
	
	@Test
	public void testReturnDate()
	{
		TRLAppController T1= new TRLAppController("P1", "W1");
		assertEquals("2017-11-12" ,T1.getReturnDate());
	}
	
	@Test
	public void InsertData()
	{
		DataHandler H1 = new DataHandler();
		H1.insertData("A1", "B1", "2017-11-11");
		
	}
	
	@Test
	public void retrieveData()
	{
		DataHandler H1 = new DataHandler();
		
		assertEquals("", H1.retreiveHold("P1"));
	}
	
	/*@Test
	public void addHold()
	{
		DataHandler H1 = new DataHandler();
		H1.addHold("A1", "Hold");
		assertEquals("Hold", H1.retreiveHold("A1"));
	}*/
	
	@Test
	public void deleteHold()
	{
		DataHandler H1 = new DataHandler();
		H1.deleteHold("A1");
		assertEquals("", H1.retreiveHold("A1"));
	}
	
	
	@Test
	public void getDate()
	{
		DataHandler H1 = new DataHandler();
		assertEquals("2017-11-11",H1.retrieveReturnDate("P1", "C2"));
	}
	
	@Test
	public void dynamicPath()
	{
		String path = System.getProperty("user.dir");
		assertEquals("C:\\Users\\aguru\\TP-4-Gurung-Tullu\\TP_4_Gurung_Tullu",path );
	}


}
