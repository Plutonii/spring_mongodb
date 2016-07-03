package plutonii.dao;

import plutonii.model.Aim;
import java.util.List;
import plutonii.model.User;

public interface AimDAO {
	public void addAim(Aim aim);//добавить цель
	
	public List<Aim> getAllAim();//получить список всех целей
	
	public Aim getAim(String id);//получить цель по id
	
	public void deleteAim(String id);//удалить цель по id
	
	public void change(Aim aim);//изменить цель
	
	public List<Aim> getAimsUser(String id);	//It returns all the goals by the employee;
												//вернуть цели определённого юзера
	
	public List<Aim> getSubAimsAim(Integer id); //получить все подцели для цели с ид = id
	
	public List<Aim> getAimsMap(String id); //получить все цели и подцели на карте
	
}