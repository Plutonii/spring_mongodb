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

import plutonii.model.Aim;
import plutonii.service.AimService;

//import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;

@Controller    
public class AimController {  
	
	protected static Logger logger = Logger.getLogger("AimController");

	
	@Autowired
	private AimService aimService;
	
    @RequestMapping(value = "/aims", method = RequestMethod.GET)  
	public String getAimList(ModelMap model) {  
        model.addAttribute("aimList", aimService.getAllAim());  
        return "output";  
    }  
    
    @RequestMapping(value = "/aim/add", method = RequestMethod.POST)  
	public View createAim(@ModelAttribute Aim aim, ModelMap model) {
    	if(StringUtils.hasText(aim.getId())) {
    		aimService.changeAim(aim);
    	} else {
    		aimService.addAim(aim);
    	}
    	return new RedirectView("/hz_kuda");  
    }
    
    @RequestMapping(value = "/aim/delete", method = RequestMethod.GET)  
   	public View deleteAim(@ModelAttribute Aim aim, ModelMap model) {  
           aimService.deleteAim(aim);
           return new RedirectView("/hz_kuda");  
    }
    
    @RequestMapping(value = "/aim/edit", method = RequestMethod.POST)
    public String saveEdit(	@ModelAttribute("personAttribute") Aim aim, 
    						@RequestParam(value="id", required=true) String id, 
    						Model model) {
    	logger.debug("Received request to update person");
    
    	aim.setId(id);
    	
    	aimService.changeAim(aim);
    	
		model.addAttribute("id", id);
		return "editedpage";
	}
}