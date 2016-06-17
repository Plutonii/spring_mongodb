package com.manishchhabra.blog.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
 
import com.manishchhabra.blog.model.Aim;
import com.manishchhabra.blog.service.AimService;
   

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Person;
import org.krams.tutorial.service.PersonService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller    
public class AimController {  
	
	@Autowired
	private AimService aimService;
	
    @RequestMapping(value = "/aim", method = RequestMethod.GET)  
	public String getAimList(ModelMap model) {  
        model.addAttribute("aimList", aimService.listAim());  
        return "output";  
    }  
    
    @RequestMapping(value = "/aim/save", method = RequestMethod.POST)  
	public View createAim(@ModelAttribute Aim aim, ModelMap model) {
    	if(StringUtils.hasText(aim.getId())) {
    		aimService.updateAim(aim);
    	} else {
    		aimService.addAim(aim);
    	}
    	return new RedirectView("/mysql_mongodb/aim");  
    }
        
    @RequestMapping(value = "/aim/delete", method = RequestMethod.GET)  
	public View deleteAim(@ModelAttribute Aim aim, ModelMap model) {  
        aimService.deleteAim(aim);
        return new RedirectView("/mysql_mongodb/aim");  
    }
    /*
    @RequestMapping(value = "/person/edit", method = RequestMethod.GET)  
	public String getEditPerson(@ModelAttribute Person person, ModelMap model) {  
    	//model.add
        model.addAttribute("personL", personService.get(person.getId())); 
        return "editt";  
    }
    
    @RequestMapping(value = "/person/edit", method = RequestMethod.POST)  
	public View saveEditPerson(@ModelAttribute Person person, ModelMap model) {
    	personService.updatePerson(person);
    	return new RedirectView("/HelloSpringWithMongoDB/person");  
    }*/
    
	//protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="personService")
	private PersonService personService;
	
	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 *//*
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model) {
    	
    	logger.debug("Received request to show all persons");
    	
    	// Retrieve all persons by delegating the call to PersonService
    	List<Person> persons = personService.getAll();
    	
    	// Attach persons to the Model
    	model.addAttribute("persons", persons);
    	
    	// This will resolve to /WEB-INF/jsp/personspage.jsp
    	return "personspage";
	}*/
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     *//*
    @RequestMapping(value = "/persons/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", new Person());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "addpage";
	}*/
 
    /**
     * Adds a new person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     *//*
    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Person person) {
		logger.debug("Received request to add new person");
		
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
		
		// Call PersonService to do the actual adding
		personService.add(person);

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "addedpage";
	}
    */
    /**
     * Deletes an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     *//*
    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing person");
		
		// Call PersonService to do the actual deleting
		personService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "deletedpage";
	}*/
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     *//*
    @RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", personService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "editpage";
	}*/
    
    /**
     * Edits an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     *//*
    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update person");
    
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	person.setId(id);
    	
    	// Delegate to PersonService for editing
    	personService.edit(person);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}*/
}