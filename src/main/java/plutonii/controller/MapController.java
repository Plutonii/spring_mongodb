package plutonii.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import plutonii.model.Map;
import plutonii.service.MapService;

//import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;

@Controller    
public class MapController {  
	
	protected static Logger logger = Logger.getLogger("MapController");

	
	@Autowired
	private MapService mapService;
	
    @RequestMapping(value = "/maps", method = RequestMethod.GET)  
	public String getMapsList(ModelMap model) {  
        model.addAttribute("mapList", mapService.getAllMaps());  
        return "output";  
    }  
    
    @RequestMapping(value = "/map/add", method = RequestMethod.POST)  
	public View createMap(@ModelAttribute Map map, ModelMap model) {
    	if(StringUtils.hasText(map.getId())) {
    		mapService.changeMap(map);
    	} else {
    		mapService.addMap(map);
    	}
    	return new RedirectView("/hz_kuda");  
    }
    
    @RequestMapping(value = "/map/delete", method = RequestMethod.GET)  
   	public View deleteMap(@ModelAttribute Map map, ModelMap model) {  
           mapService.deleteMap(map);
           return new RedirectView("/hz_kuda");  
    }
    
    @RequestMapping(value = "/map/edit", method = RequestMethod.POST)
    public String saveEdit(	@ModelAttribute("mapAttribute") Map map, 
    						@RequestParam(value="id", required=true) String id, 
    						Model model) {
    	logger.debug("Received request to update map");
    
    	map.setId(id);
    	
    	mapService.changeMap(map);
    	
		model.addAttribute("id", id);
		return "editedpage";
	}
}