package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class All_Method_HashMap {

	public HashMap<String, Object> Post_HashMap(String name, String lang) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> location = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		
		location.put("lat", -38.383494);
		location.put("lng", 33.427362);
		
		map.put("location", location);
		map.put("accuracy", 50);
		map.put("name", name);
		map.put("phone_number", "(+91) 983 893 3937");
		map.put("address", "29, side layout, cohen 09");
		
		list.add("Shop");
		list.add("Shoe Shop");
		
		map.put("types", list);
		map.put("website", "http://google.com");
		map.put("language", lang);
		
		return map;
		
	}

	public HashMap<Object, Object> Put_HashMap(String placeid) {
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("place_id", placeid);
		map.put("address", "56, john Street, USA");
		map.put("key", "qaclick123");

		return map;

	}

	public HashMap<Object, Object> Delete_HashMap(String placeid) {

		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("place_id", placeid);
		
		return map;
		
	}

}
