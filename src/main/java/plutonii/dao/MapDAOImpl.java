package plutonii.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;

import plutonii.model.Aim;
import plutonii.model.Map;
import plutonii.dao.MapDAO;

@Repository
public class MapDAOImpl implements MapDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "maps";

	public void addMap(Map map) {
		if (!mongoTemplate.collectionExists(Map.class)) {
			mongoTemplate.createCollection(Map.class);
		}		
		map.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(map, COLLECTION_NAME);
		
	}

	public Map getMap(String id) {
		List <Map> mapL = new ArrayList<Map>();
		mapL = mongoTemplate.find(new Query(Criteria.where("_id").is(id)), Map.class, COLLECTION_NAME);
		return mapL.size() == 0? null: mapL.get(0);
	}

	public void deleteMap(String id) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Map.class, COLLECTION_NAME);
		
	}

	public void changeMap(Map map) {
		org.springframework.data.mongodb.core.query.Update update =
				org.springframework.data.mongodb.core.query.Update.update("id", map.getId());
		
		if (map.getYear() != 0) update.set("year", map.getYear());
		//if (map.getLastChange() != null) update.set("lastChange", map.getLastChange());
		if (map.getStatus() != null) update.set("status", map.getStatus());
		mongoTemplate.upsert(new Query(Criteria.where("_id").is(map.getId())), update,	
				Map.class, COLLECTION_NAME);
	}
	
	public List<Map> getAllMaps() {
		return mongoTemplate.findAll(Map.class, COLLECTION_NAME);
	}
	
}