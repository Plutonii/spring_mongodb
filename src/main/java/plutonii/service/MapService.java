package plutonii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import plutonii.dao.MapDAO;
import plutonii.model.Map;

@Service
@Transactional
public class MapService {

    @Autowired
    private MapDAO mapDAO;

    public void addMap (Map map) {
    	mapDAO.addMap(map);
    }
    
    public List<Map> getAllMaps() {
    	return mapDAO.getAllMaps();
    }
    
    public Map getMap(Map map) {
    	return mapDAO.getMap(map);
    }

    public void deleteMap(Map map) {
    	mapDAO.deleteMap(map);
    }
    
	public void changeMap(Map map) {
		mapDAO.changeMap(map);
	}
    
}
