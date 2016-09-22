package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author king6
 * abstracting data adapter to fetch data. 
 * all logic regarding fetching of data is to be implemented here
 */
public class DataAdapter{
	
	private String urlString;
	

	public DataAdapter(String url)
	{
		urlString = url;
	}

	public String getDataString() throws Exception {
		
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        
	        StringBuffer buffer = new StringBuffer();
	        
	        int read;
	        
	        char[] chars = new char[1024];
	        
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read);
	        
	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}

}
