import java.sql.*;
public class DataHandler {
	 Connection c = null;
     Statement stmt = null;
     public void insertData(String patronID, String bookId,  String date)
     {
     try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:LibraryDataHouse.db");
        c.setAutoCommit(false);

        stmt = c.createStatement();
        String sql = "INSERT INTO PatronCopyInfo (PatronID,BookID,ReturnDate) " +
                       "VALUES ('" + patronID +"', '"+bookId+"', '"+ date +"');"; 
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
     
     
     public String RetreiveHold(String patronID)
     {
     try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:LibraryDataHouse.db");
        c.setAutoCommit(false);

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT Hold FROM PatronCopyInfo where PatronID = '"  + patronID +"' LIMIT 1;" );
       String hold = rs.getString("Hold");

        stmt.close();
        c.commit();
        c.close();
        return hold;
     } catch ( Exception e ) {
       
        System.out.println(e.toString());
        return null;
     }
	
     }
     
     public boolean removeData(String patronId , String bookID)
     {
    	 try {
    	        Class.forName("org.sqlite.JDBC");
    	        c = DriverManager.getConnection("jdbc:sqlite:LibraryDataHouse.db");
    	        c.setAutoCommit(false);

    	        stmt = c.createStatement();
    	        String sql = "DELETE FROM PatronCopyInfo" +
    	        		"WHERE PatronID = '" + patronId +"' and BookId =  '"+ bookID +"';"; 
    	        stmt.executeUpdate(sql);

    	        stmt.close();
    	        c.commit();
    	        c.close();
    	        return true;
    	     } catch ( Exception e )
    	     {
    	    	 System.out.println(e.toString());
    	    
    	    	 return false;
    	        
    	       
    	     } 
     }
     
     public boolean deleteHold(String patronId)
     {
     try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:LibraryDataHouse.db");
	        c.setAutoCommit(false);

	        stmt = c.createStatement();
	        String sql = "UPDATE PatronCopyInfo SET Hold = Null " +
	        		"WHERE PatronID = '" + patronId +"';"; 
	        stmt.executeUpdate(sql);

	        stmt.close();
	        c.commit();
	        c.close();
	        return true;
	     } catch ( Exception e )
	     {
	    	 System.out.println(e.toString());
	        return false;
	     } 
     }
     
     public boolean addHold(String patronId, String hold)
     {
    	 try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:LibraryDataHouse.db");
	        c.setAutoCommit(false);

	        stmt = c.createStatement();
	        String sql = "UPDATE PatronCopyInfo SET Hold = '" + hold + "'" +
	        		"WHERE PatronID = '" + patronId +"';"; 
	        stmt.executeUpdate(sql);

	        stmt.close();
	        c.commit();
	        c.close();
	        return true;
	     } catch ( Exception e )
	     {
	    	 System.out.println(e.toString());
	        return false;
	     } 
  }
     
     public static void main(String[] args) 
 	{
    	
	

 	}

}
