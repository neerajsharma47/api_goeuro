package api;

import api.GeoPosition;

public class ApiStructure implements CsvOutputInterface{
	int _id;
	int key;
	String name;
	String fullName;
	String iata_airport_code;
	String type;
	String country;
	
	GeoPosition geo_position;
	
	int location_id;
	Boolean inEurope;
	String countryCode;
	Boolean coreCountry;
	int distance;

	public String getCsv() 
	{
		return _id + "," + ","+ name + ","+type+"," + geo_position.getCsv();
	}
}
