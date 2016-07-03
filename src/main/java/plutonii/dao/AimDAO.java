package plutonii.dao;

import plutonii.model.Aim;
import java.util.List;
import plutonii.model.User;

public interface AimDAO {
	public void addAim(Aim aim);//�������� ����
	
	public List<Aim> getAllAim();//�������� ������ ���� �����
	
	public Aim getAim(String id);//�������� ���� �� id
	
	public void deleteAim(String id);//������� ���� �� id
	
	public void change(Aim aim);//�������� ����
	
	public List<Aim> getAimsUser(String id);	//It returns all the goals by the employee;
												//������� ���� ������������ �����
	
	public List<Aim> getSubAimsAim(Integer id); //�������� ��� ������� ��� ���� � �� = id
	
	public List<Aim> getAimsMap(String id); //�������� ��� ���� � ������� �� �����
	
}