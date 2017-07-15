
import java.sql.*;
//Create the database and the table
public class CreateTable {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:LibraryData.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE PatronCopyData " +
                        "( PatronID           TEXT    NOT NULL, " + 
                        " BookID           TEXT   NOT NULL, " + 
                        " ReturnDate		TEXT NOT NULL," +
                        " Hold 			TEXT NOT NULL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}