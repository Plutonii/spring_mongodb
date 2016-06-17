package com.manishchhabra.blog.service;
 
import java.util.List;
import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//import static org.springframework.data.mongodb.core.query.Query.query;
 
import com.manishchhabra.blog.model.Aim;
 
@Repository
public class AimService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "aim";
	
	public void addAim(Aim aim) {
		if (!mongoTemplate.collectionExists(Aim.class)) {
			mongoTemplate.createCollection(Aim.class);
		}		
		aim.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(aim, COLLECTION_NAME);
	}
	
	public List<Aim> listAim() {
		return mongoTemplate.findAll(Aim.class, COLLECTION_NAME);
	}
	
	/*public List<Person> get(String id) {
		return mongoTemplate.find(query(where("_id"	).is(id)), Person.class);
	}*/
	
	public void deleteAim(Aim aim) {
		mongoTemplate.remove(aim, COLLECTION_NAME);
	}
	
	public void updateAim(Aim aim) {
		mongoTemplate.insert(aim, COLLECTION_NAME);		
	}
}