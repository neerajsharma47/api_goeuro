package api;

import java.io.PrintWriter;
import api.CsvGenrator;
import api.DataAdapter;


import com.google.gson.Gson;

/*
 * @brief Application class used to hold static main function
 *        declared abstract as no Object is needed
 * 
 */
public abstract class Application {
	
	public static void main(String arg[]) throws Exception
	{
		String requestUrl = "";
		if(arg.length > 0)
		{
			requestUrl = "http://api.goeuro.com/api/v2/position/suggest/en/"+arg[0];
		}
		else
		{
			throw new Exception("[api] invalid argument. \n Usage: api <city_name> ");
		}
		
		try
		{	
			// create DatatAdapter to fetch data from source
			DataAdapter jsonSrc = new DataAdapter(requestUrl);
			
			// create Gson object to process parse Json string
			Gson gson = new Gson();
			
			// create ApiStructre Array from Json
			ApiStructure[] api = gson.fromJson(jsonSrc.getDataString(), ApiStructure[].class);
			
			//save the result in file
			CsvGenrator.saveCsv(api, new PrintWriter("./"+arg[0]+".csv"));	
		}
		catch(Exception expection)
		{
			System.out.println( "Exception: "+expection.getLocalizedMessage());
		}
		
	}


}
