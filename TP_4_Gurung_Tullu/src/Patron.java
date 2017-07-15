
import java.util.ArrayList;
import java.util.Calendar;


	public class Patron
	{
		private String name;
		private String patronID;
		
		private ArrayList<Copy> copiesOut = new ArrayList<Copy>();
		

		public Patron(String id, String name)
		{
			this.name = name;
			this.patronID = id;
			
			
			
		}
		
		public String getName() {
			return name;
		}

		public String getId()
		{
			return patronID;
		}
		
		
		
		public void checkCopyOut(Copy c)
		{
			// finish this
	        c.setOutTo(this);
			copiesOut.add(c);
			
		}

		
		public boolean checkCopyIn(Copy c)
		{
			c.setOutTo(null);
			if (copiesOut.contains(c))
			{
				copiesOut.remove(c);
				return true;
			}
			else
			return false;
		}

		public String returnDate()
		{
			Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, 120);
					
		
			return cal.getTime().toString();
		}
		@Override
		public boolean equals(Object o)
		{
			// two are equals iff same patron ID
			if (this == o) {
	            return true;
	        } else if (o == null) {
	            return false;
	        } else if (o instanceof Patron) {
	            Patron pat = (Patron) o;
	            if (pat.getId().equals(patronID))
	                {
	                return true;
	            }
	        }
	        return false;
		}
		
		

		public String toString()
		{
			// finish this: return basic Patron info as String
			
			return "Name: " + this.name + "\r" +"ID: " + this.patronID + "\r" + "Copy checked Out: " + this.copiesOut.toString();
		}

		public static void main(String[] args)
		{
			
		}

	}


