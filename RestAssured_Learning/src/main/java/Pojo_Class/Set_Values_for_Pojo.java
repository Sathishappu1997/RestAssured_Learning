package Pojo_Class;

import java.util.ArrayList;
import java.util.List;

public class Set_Values_for_Pojo {
	
	All_Methods_Pojo pojo;
	Location location;
	
	public All_Methods_Pojo setValues_post_Pojo() {
		
	pojo = new All_Methods_Pojo();
	location = new Location();
	
	location.setLat("-38.383494");
	location.setLng("33.427362");
	
	pojo.setLocation(location);
	pojo.setAccuracy("50");
	pojo.setName("Franklin");
	pojo.setPhone_number("(+91) 983 893 3937");
	pojo.setAddress("29, side layout, cohen 09");
	
	List<String> list = new ArrayList<String>();
	list.add("shoe park");
	list.add("shop");
	
	pojo.setTypes(list);
	pojo.setWebsite("http://google.com");
	pojo.setLanguage("English");
	
	return pojo;
	
	}

}
