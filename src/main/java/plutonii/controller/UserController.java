package plutonii.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import plutonii.model.*;
import plutonii.service.UserService;
//import plutonii.dao.UserDAO;

//import java.util.List;

//import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
//import org.apache.log4j.Logger;

@Controller
public class UserController{
	
	protected static Logger logger = Logger.getLogger("UserController");
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/users", method = RequestMethod.GET)  
	public String getUserList(ModelMap model) {  
        model.addAttribute("userList", userService.getAllUsers());  
        return "output";  
    }
    
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)  
	public View createAim(@ModelAttribute User user, ModelMap model) {
    	userService.addUser(user);
    	return new RedirectView("/users");  
    }
    
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)  
   	public View deleteUser(@ModelAttribute User user, ModelMap model) {  
           userService.deleteUser(user);
           return new RedirectView("/users");  
    }
    
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String saveEdit(	@ModelAttribute("userAttribute") User user, 
    						@RequestParam(value="id", required=true) Integer id, 
    						Model model) {
    	logger.debug("Received request to update user");
    
    	user.setId(id);
    	
    	userService.changeUser(user);
    	
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}
}