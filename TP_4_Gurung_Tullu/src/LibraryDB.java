import java.util.HashMap;
import java.util.Map;

public class LibraryDB 
{
	private static Map<String,Patron> patronStore;
	private static Map<String,Copy> copyStore;
	
	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();
		copyStore = new HashMap<String,Copy>();
		
		patronStore.put("P1", new Patron("P1", "Eric", ""));
		patronStore.put("P2", new Patron("P2", "Amar", ""));
		patronStore.put("P3", new Patron("P3", "Abebe", "Over Due"));
		
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		copyStore.put("C3", new Copy("C3", "Even More Fun with Objects"));
		
	}

	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	
	public static Copy getCopy(String copyID)
	{
		return copyStore.get(copyID);
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
}
