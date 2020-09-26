package Payloads;

public class All_Methods_Payloads {
	
	public static String postPayload() {
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String putPayload() {
		return "{\r\n" + 
				"\"place_id\":\"f64759c5dbafa9970a8277cb55fb4803\",\r\n" + 
				"\"address\":\"70 winter world, Canada\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String deletePayload() {
		return "{\r\n" + 
				"    \"place_id\":\"f64759c5dbafa9970a8277cb55fb4803\" \r\n" + 
				"}\r\n" + 
				"";
	}

}
