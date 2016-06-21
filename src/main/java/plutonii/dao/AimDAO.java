package plutonii.dao;

import plutonii.model.Aim;
import java.util.List;

public interface AimDAO {
	public void addAim(Aim aim);
	
	public List<Aim> getAllAim();
	
	public Aim getAim(Aim aim);
	
	public void deleteAim(Aim aim);
	
	public void change(Aim aim);
}