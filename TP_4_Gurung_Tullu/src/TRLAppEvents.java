




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

//An interface to be implemented by check in and out events
interface CheckInOutListener {
void copyCheckedIn(String copyID, String userID, String workerID);
void copyCheckedOut(String copyID, String userID, String workerID);
void removeHold(String userID, String workerID);
void addHold(String userID, String workerID, String hold);
}



//Someone interested in events
class Responder implements CheckInOutListener{

	private Calendar cal = Calendar.getInstance();
	private String path = System.getProperty("user.dir");
	
@Override
public void copyCheckedIn(String copyID, String userID, String workerID) {
	

	BufferedWriter bw = null;
	FileWriter fw = null;

	try {
		String newline = System.getProperty("line.separator");
		String data = newline + userID + "	checked in copy:	" + copyID + "	Worker:	" + workerID + "	" + cal.getTime().toString();
		File file = new File(path + "\\Events\\TRLevent.txt"); 

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		// true = append file
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);

		bw.write(data);

		//System.out.println("Done");

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}
	
}

@Override
public void copyCheckedOut(String copyID, String userID, String workerID) {
	BufferedWriter bw = null;
	FileWriter fw = null;

	try {
		String newline = System.getProperty("line.separator");
		String data = newline + userID + "	checked out copy:	" + copyID + "	Worker:	" + workerID + "	" + cal.getTime().toString();
		File file = new File(path + "\\Events\\TRLevent.txt");

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		// true = append file
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);

		bw.write(data);

		//System.out.println("Done");

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}
	
}

@Override
public void addHold(String userID, String workerID, String hold){
	

	BufferedWriter bw = null;
	FileWriter fw = null;

	try {
		String newline = System.getProperty("line.separator");
		String data = newline + "Worker:	" + workerID + "	added hold:	"+hold+"	"+"	StudentID =	"+userID	+"	"+ cal.getTime().toString();
		File file = new File(path + "\\Events\\TRLevent.txt"); 

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		// true = append file
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);

		bw.write(data);

		//System.out.println("Done");

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}
	
}

@Override
public void removeHold(String userID, String workerID){
	

	BufferedWriter bw = null;
	FileWriter fw = null;

	try {
		String newline = System.getProperty("line.separator");
		String data = newline + "Worker:	" + workerID + "	removed hold:	"+userID+"	"	+ cal.getTime().toString();
		File file = new File(path + "\\Events\\TRLevent.txt"); 

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		// true = append file
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);

		bw.write(data);

		//System.out.println("Done");

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}
	
}

}



class TRLAppEvents {
public static void main(String[] args) {
   
}
}