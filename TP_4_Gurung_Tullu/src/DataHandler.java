import java.sql.*;
import java.util.ArrayList;
public class DataHandler {
	 Connection c = null;
     Statement stmt = null;
     public void insertData(String patronID, String bookId,  String date)
     {
     try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
        c.setAutoCommit(false);
        String hold = "none";
        stmt = c.createStatement();
        String sql = "INSERT INTO PatronCopyData (PatronID, BookID, ReturnDate, Hold) " +
                       "VALUES ('" + patronID +"', '"+bookId+"', '"+ date +"', '"+ hold +"');"; 
        stmt.executeUpdate(sql);

        stmt.close();
        c.commit();
        c.close();
     } catch ( Exception e )
     {
    	System.out.println(e.toString());
        System.exit(0);
     }
     }
     
     
     public String retreiveHold(String patronID)
     {
     try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
        c.setAutoCommit(false);

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT Hold FROM PatronCopyData(nolock) where PatronID = '"  + patronID +"' LIMIT 1;" );
        String hold;
      
    	   hold = rs.getString("Hold");
     
        stmt.close();
        c.commit();
        c.close();
        return hold;
     } catch ( Exception e ) {
       
        //System.out.println(e.toString());
        return "";
     }
     }
     
     public String retrieveReturnDate(String patronID, String copyID)
     {
     try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
        c.setAutoCommit(false);

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT ReturnDate FROM PatronCopyData where PatronID = '"  + patronID +"' and BookID = '"+ copyID +"';" );
       String date = rs.getString("ReturnDate");

        stmt.close();
        c.commit();
        c.close();
        return date;
     } catch ( Exception e ) {
       
        //System.out.println(e.toString());
        return null;
     }
	
     }
     
     public boolean removeData(String patronId , String bookID)
     {
    	 try {
    	        Class.forName("org.sqlite.JDBC");
    	        c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
    	        c.setAutoCommit(false);

    	        stmt = c.createStatement();
    	        String sql = "DELETE FROM PatronCopyData WHERE PatronID = '" + patronId +"' and BookId = '"+ bookID +"';"; 
    	        stmt.executeUpdate(sql);

    	        stmt.close();
    	        c.commit();
    	        c.close();
    	        return true;
    	     } catch ( Exception e )
    	     {
    	    	 //System.out.println(e.toString());
    	    
    	    	 return false;
    	        
    	       
    	     } 
     }
     
     public boolean deleteHold(String patronId)
     {
     try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
	        c.setAutoCommit(false);

	        stmt = c.createStatement();
	        String sql = "UPDATE PatronCopyData SET Hold = '' " +
	        		"WHERE PatronID = '" + patronId +"';"; 
	        stmt.executeUpdate(sql);

	        stmt.close();
	        c.commit();
	        c.close();
	        return true;
	     } catch ( Exception e )
	     {
	    	 //System.out.println(e.toString());
	        return false;
	     } 
     }
     
     public boolean addHold(String patronId, String hold)
     {
    	 try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
	        c.setAutoCommit(false);

	        stmt = c.createStatement();
	        String sql = "UPDATE PatronCopyData SET Hold = '" + hold + "'" +
	        		"WHERE PatronID = '" + patronId +"';"; 
	        stmt.executeUpdate(sql);

	        stmt.close();
	        c.commit();
	        c.close();
	        return true;
	     } catch ( Exception e )
	     {
	    	 //System.out.println(e.toString());
	        return false;
	     } 
  }
     
     public ArrayList<String> getCopies(String patronID)
     {
    	 Connection c = null;
  	   Statement stmt = null;
  	   try {
  	      Class.forName("org.sqlite.JDBC");
  	      c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
  	      c.setAutoCommit(false);
  	     

  	      stmt = c.createStatement();
  	      ResultSet rs = stmt.executeQuery( "SELECT BookID FROM PatronCopyData where PatronID = '"+ patronID +"' ;" );
  	    ArrayList<String> array = new ArrayList<String>();
  	 
  	      while ( rs.next() ) {
  	    	  
  	    	 String copies = rs.getString("BookID");
  	  	      array.add(copies);
  		       
  		       
  		        
  	      }
  	      rs.close();
  	      stmt.close();
  	      c.close();
  	      return array;
  	   } catch ( Exception e ) {
  	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	      System.exit(0);
  	      return null;
  	   }
     }
    
     
     public static void main(String[] args) 
 	{
    	 Connection c = null;
    	   Statement stmt = null;
    	   try {
    	      Class.forName("org.sqlite.JDBC");
    	      c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
    	      c.setAutoCommit(false);
    	      System.out.println("Opened database successfully");

    	      stmt = c.createStatement();
    	      ResultSet rs = stmt.executeQuery( "SELECT * FROM PatronCopyData;" );
    	      
    	      while ( rs.next() ) {
    	    	  String patronId = rs.getString("PatronID");
    		         String copyId = rs.getString("BookID");
    		         String returnDate  = rs.getString("ReturnDate");
    		         String hold = rs.getString("Hold");
    		       
    		         
    		         System.out.println( "StudentID = " + patronId + " CopyId = " + copyId + " ReturnDate = " + returnDate + " Hold = " + hold);
    	      }
    	      rs.close();
    	      stmt.close();
    	      c.close();
    	   } catch ( Exception e ) {
    	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	      System.exit(0);
    	   }
    	   System.out.println("Operation done successfully");
    	 
    	   

 	}

}
