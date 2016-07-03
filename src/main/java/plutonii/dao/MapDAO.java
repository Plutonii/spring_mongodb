package plutonii.dao;

import plutonii.model.Map;
import java.util.List;

public interface MapDAO {
	public void addMap(Map map);
	
	public List<Map> getAllMaps();
	
	public Map getMap(String id);
	
	public void deleteMap(String id);
	
	public void changeMap(Map map);
}