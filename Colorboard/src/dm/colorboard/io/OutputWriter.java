package dm.colorboard.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Output Writer
 * @author dmurarik
 *
 */
public class OutputWriter{
	
	private final String NEW_LINE = "\n";
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	/**
	 * Constructor
	 * @param fileLocation File to write to
	 * @throws IOException
	 */
	public OutputWriter(String fileLocation) throws IOException{
		File output = new File(fileLocation);
		if(output.exists())
			output.delete();
		output.createNewFile();
		
		fw = new FileWriter(output.getAbsolutePath());
		bw = new BufferedWriter(fw);
		
	}
	
	/**
	 * Write a new line
	 * @param newLine Line to written
	 * @throws IOException
	 */
	public void writeln(String newLine) throws IOException{
		bw.write(newLine);
		bw.write(NEW_LINE);
		bw.flush();
	}
	
	/**
	 * Close buffered writer
	 * @throws IOException
	 */
	public void close() throws IOException{
		bw.close();
	}
	
}