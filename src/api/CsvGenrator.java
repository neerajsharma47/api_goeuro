/**
 * 
 */
package api;

import java.io.*;


/**
 * @author king6
 *
 */
public abstract class CsvGenrator {
		
	public static void saveCsv(ApiStructure[] apiArr, PrintWriter fileWriter )
	{
		
		for( ApiStructure api_ele : apiArr)
		{
			fileWriter.println(api_ele.getCsv());
		}
		
		fileWriter.close();
	}

};
