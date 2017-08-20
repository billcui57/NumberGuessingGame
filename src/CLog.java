
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CLog {

	private static final String FILENAME = "C:\\Users\\billc\\eclipse-workspace\\Number Guesser\\src\\records.txt";

	public void write() {
		CFred fred = new CFred(); // introduces object fred from class CFred
		BufferedWriter bw = null;
		FileWriter fw = null;
		int tries=fred.tries;
		int num=fred.num;

		try {

			

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write("Fred guessed the number %d in %d tries",num,tries);

			System.out.println("File write done");

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