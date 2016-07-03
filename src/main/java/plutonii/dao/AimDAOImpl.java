package plutonii.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
//import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import plutonii.model.Aim;
import plutonii.model.User;

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

	public Aim getAim(String id) {
		List <Aim> aimL = new ArrayList<Aim>();
		aimL = mongoTemplate.find(new Query(Criteria.where("_id").is(id)), Aim.class, COLLECTION_NAME);
		return aimL.size() == 0? null: aimL.get(0);
	}

	public void deleteAim(String id) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Aim.class, COLLECTION_NAME);
		
	}

	public void change(Aim aim) {
		org.springframework.data.mongodb.core.query.Update update =
				org.springframework.data.mongodb.core.query.Update.update("id", aim.getId());
		
		if (aim.getNumber() != 0) update.set("number", aim.getNumber());
		if (aim.getIdHead() != null) update.set("idHead", aim.getIdHead());
		if (aim.getDescription() != null) update.set("description", aim.getDescription());
		if (aim.getPersonalAim() != null) update.set("personalAim",aim.getPersonalAim());
		if (aim.getRatingMeasure() != null) update.set("ratingMeasure", aim.getRatingMeasure());
		if (aim.getExpectedValue() != 0) update.set("expectedValue", aim.getExpectedValue());
		if (aim.getRealizDate() != null) update.set("realizDate", aim.getRealizDate());
		if (aim.getValueAim() != 0) update.set("valueAim", aim.getValueAim());
		if (aim.getComment() != null) update.set("comment", aim.getComment());
		if (aim.getExpectedRating() != 0) update.set("expectedRating", aim.getExpectedRating());
		if (aim.getComment() != null) update.set("commentRating", aim.getComment());
		if (aim.getIdCreatorAim() != null) update.set("idCreatorAim", aim.getIdCreatorAim());
		mongoTemplate.upsert(new Query(Criteria.where("_id").is(aim.getId())), update,	
				Aim.class, COLLECTION_NAME);
	}

	public List<Aim> getAimsUser(String id) {
		return mongoTemplate.find (new Query(
				Criteria.where("idCreatorAim").is(id)), Aim.class,
				COLLECTION_NAME);
	}
	
	public List<Aim> getSubAimsAim(Integer id) {
		return mongoTemplate.find (new Query(
				Criteria.where("idHead").is(id)), Aim.class,
				COLLECTION_NAME);
	}

	public List<Aim> getAimsMap(String id) {
		return mongoTemplate.find( new Query(Criteria.where("idMap").is(id)),
				Aim.class, COLLECTION_NAME);
	}
	
}