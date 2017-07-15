
public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title)
	{


		this.copyID = copyID;
		this.title = title;
		
	}



	public String toString()
	{
		return "Copy ID: " + this.copyID + "   Title: " + this.title;
	}
	public String getCopyID() {
		return copyID;
	}

	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Patron getOutTo() {
		return outTo;
	}

	public void setOutTo(Patron outTo) {      //set the patron to the copy it checked out
		this.outTo = outTo;
	}

	@Override
	public boolean equals(Object o)//Check if the objects are same
	{
		if (this == o) {
			            return true;
			        } else if (o == null) {
			            return false;
			        } else if (o instanceof Copy) {
			            Copy cop = (Copy) o;
			            if ((cop.getTitle() == null && title == null) ||
			                (cop.getTitle().equals(title) && ((cop.getCopyID() == null && copyID == null)
			                || cop.getCopyID().equals(copyID))))
			                {
			                return true;
			            }
			        }
			        return false;
	}
	
	public static void main(String[] args)
	{
		
	
	}
}
