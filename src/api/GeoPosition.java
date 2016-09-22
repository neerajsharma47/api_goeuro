package api;

/*
 * @brief GeoPosition: class to save Geo Locations
 */
public class GeoPosition implements CsvOutputInterface {
	float latitude;
	float longitude;
	
	public String getCsv()
	{
		return latitude + "," + longitude ;
	}
	
}
