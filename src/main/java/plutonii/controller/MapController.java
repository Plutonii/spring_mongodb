package plutonii.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import plutonii.model.Aim;
import plutonii.model.Map;
import plutonii.service.MapService;

import java.util.List;

//import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/maps")
public class MapController {  
	
	protected static Logger logger = Logger.getLogger("MapController");

	
	@Autowired
	private MapService mapService;
	
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"}) @ResponseBody
	public List <Map> getMapsList() {  
    	return mapService.getAllMaps();
        
    }  
    
    
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"}) @ResponseStatus(HttpStatus.CREATED) @ResponseBody  
	public Map createMap(@RequestBody Map map) {
    	if(StringUtils.hasText(map.getId())) {
    		mapService.changeMap(map);
    	} else {
    		mapService.addMap(map);
    	}
    	return map;  
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) @ResponseStatus(HttpStatus.OK)
   	public void deleteMap(@PathVariable String id) {  
           mapService.deleteMap(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {"application/json"}) @ResponseBody
	public Map getMap(@PathVariable String id) {  
        return mapService.getMap(id);  
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT) @ResponseStatus(HttpStatus.OK)
    public void updateMap(@RequestBody Map map, @PathVariable String id) {
    	if (mapService.getMap(id) == null) return;	
        map.setId(id);
        System.out.println(map.getYear());
        mapService.changeMap(map);
    }
}