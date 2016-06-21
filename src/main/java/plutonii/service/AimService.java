package plutonii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import plutonii.dao.AimDAO;
import plutonii.model.Aim;

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
    
    public Aim getAim(Aim aim) {
    	return aimDAO.getAim(aim);
    }

    public void deleteAim(Aim aim) {
    	aimDAO.deleteAim(aim);
    }
    
	public void changeAim(Aim aim) {
		aimDAO.change(aim);
	}
    
}
