package CarnaticVideoUploader;

import java.util.HashMap;
import java.util.Map;

public class Index_Map {
	
	private boolean isenabled;
	private boolean is_free;
	private String resource_name; 
	private String res_url;
	private String sample_url;
	private String description;
	
	synchronized(this){
		
		Map<String,Object> indexMapper = new HashMap<String,Object>();
		indexMapper.put("home", new Home());
		indexMapper.put("Vocal", new Vocal());
		indexMapper.put("Flute", new Flute());
		indexMapper.put("enabled", isenabled);
		indexMapper.put("is_free", is_free);
		indexMapper.put("Section", new Home());
		indexMapper.put("Chapter_Name", new Vocal());
		indexMapper.put("Lesson_Name", new Flute());
		indexMapper.put("Resource_Name", resource_name);
		indexMapper.put("Resource_URL", res_url);
		indexMapper.put("Sample_URL", sample_url);
		indexMapper.put("Description", description);
		
	}
	
	private enum Maps { 
		
		Home,Vocal,Flute,Dance,enabled, 
		Is_Free,Section, Chapter_Name ,
		Lesson_Name, Resource_Name, 
		Resource_URL, Sample_URL , Description

	}
	 
}
