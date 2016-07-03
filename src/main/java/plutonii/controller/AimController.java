package plutonii.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import plutonii.model.Aim;
import plutonii.model.User;
import plutonii.service.AimService;
import plutonii.service.UserService;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller    
@RequestMapping("/aim")
public class AimController {  
	
	protected static Logger logger = Logger.getLogger("AimController");
	
	@Autowired
	private AimService aimService;
	@Autowired
	private UserService userService;
	
	//Delete http://localhost:8080/control_aim/aim/77777 (id = 77777)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable String id) {
        aimService.deleteAim(id);
    }
	
    //get all aims http://localhost:8080/control_aim/aim/
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"}) @ResponseBody
	public List<Aim> getAimList() {  
        return aimService.getAllAim();  
    }
    
    //get aim with id http://localhost:8080/control_aim/aim/8 (id = 8)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {"application/json"}) @ResponseBody
	public Aim getAim(@PathVariable String id) {  
        return aimService.getAim(id);  
    }
    
    //save aim in db http://localhost:8080/control_aim/aim/
    @RequestMapping(method = RequestMethod.POST, consumes = {"application/json"},
    				produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public Aim createAim(@RequestBody Aim aim) {
    	if(StringUtils.hasText(aim.getId())) {
    		System.out.println("has id (change)");
    		aimService.changeAim(aim);
    		System.out.println("has id (change)");
    	} else {
    		System.out.println("not has id (add)");
    		aimService.addAim(aim);
    		System.out.println("not has id (add)");
    	}
    	return aim;  
    }
    
    //change aim with id http://localhost:8080/control_aim/aim/456 (id = 456)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT) @ResponseStatus(HttpStatus.OK)
    public void updateAim(@RequestBody Aim aim, @PathVariable String id) {
    	if (aimService.getAim(id) == null) return;	
        aim.setId(id);
        aimService.changeAim(aim);
    }
    
    //get all Aims by user http://localhost:8080/control_aim/aim/allForUser/1 (id = 1)
    @RequestMapping(value = "/allForUser/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
	public List<Aim> getAimsUser(@PathVariable String id) {
        return aimService.getAimsUser(id);
    }

    //get all Aims by map http://localhost:8080/control_aim/aim/allForMap/1 (id = 1)
    @RequestMapping(value = "/allForMap/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
	public List<Aim> getAimsMap(@PathVariable String id) {
        return aimService.getAimsMap(id);
    }  
    //get all subAims for aim id http://localhost:8080/control_aim/aim/1/subAims (id = 1)
    @RequestMapping(value = "{id}/subAims", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
	public List<Aim> getSubAimsAimList(@PathVariable Integer id) {
        return aimService.getSubAimsAim(id);
    } 
    
}