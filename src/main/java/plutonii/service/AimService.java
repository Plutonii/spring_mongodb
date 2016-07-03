package plutonii.service;

import java.util.List;
//import javax.ws.rs.Produces;
//import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import plutonii.dao.AimDAO;
import plutonii.model.Aim;
import plutonii.model.User;

@Service
@Transactional
public class AimService {

    @Autowired
    private AimDAO aimDAO;

    public void addAim (Aim aim) {
    	aimDAO.addAim(aim);
    }
    
    public List<Aim> getAllAim() {
    	return aimDAO.getAllAim();
    }
    
    public Aim getAim(String id) {
    	return aimDAO.getAim(id);
    }

    public void deleteAim(String id) {
    	aimDAO.deleteAim(id);
    }
    
	public void changeAim(Aim aim) {
		aimDAO.change(aim);
	}
	
	public List<Aim> getAimsUser(String id) {
		return aimDAO.getAimsUser(id);
	}
    
	public List<Aim> getSubAimsAim(Integer id) {
		return aimDAO.getSubAimsAim(id);
	}
	
	public List<Aim> getAimsMap(String id) {
		return aimDAO.getAimsMap(id);
	}
	
}
