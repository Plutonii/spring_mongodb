package plutonii.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import plutonii.model.Aim;
import plutonii.dao.AimDAO;

@Repository
public class AimDAOImpl implements AimDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "aims";
	
	public void addAim(Aim aim) {
		if (!mongoTemplate.collectionExists(Aim.class)) {
			mongoTemplate.createCollection(Aim.class);
		}		
		aim.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(aim, COLLECTION_NAME);
	}

	public List<Aim> getAllAim() {
		return mongoTemplate.findAll(Aim.class, COLLECTION_NAME);
	}

	public Aim getAim(Aim aim) {
		Aim aim1 = new Aim();
		List<Aim> aimReturn = mongoTemplate.find(query(where("_id").is(aim.getId())), Aim.class);
		aim1 = aimReturn.get(0);
		return aim1;
	}

	public void deleteAim(Aim aim) {
		mongoTemplate.remove(aim, COLLECTION_NAME);
	}

	public void change(Aim aim) {
		mongoTemplate.insert(aim, COLLECTION_NAME);	
	}
	
}