package plutonii.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import plutonii.model.*;
import plutonii.service.TokenService;
import plutonii.service.UserService;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/user")
public class UserController{
	
	protected static Logger logger = Logger.getLogger("UserController");
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody 
	public List<User> getUserList() {
        return userService.getAllUsers();  
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public User createUser(@RequestBody User user) {
    	userService.addUser(user);
    	tokenService.addToken(user.getId());
    	return user;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,  produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
   	public void deleteUser(@RequestBody User user) {  
           userService.deleteUser(user);  
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT,  produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User changeUser(@RequestBody User user, @PathVariable String id) {
    	userService.changeUser(userService.getUser(id));
		return userService.getUser(id);
	}
    
    //get subordibates user's http://localhost:8080/control_aim/user/12/sub (id = 12)
    @RequestMapping(value = "{id}/sub", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	public List<User> getSubUser(@PathVariable String id) {
        return userService.getSubordinatesUser(id);  
    }
    
}