package plutonii.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

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

	public Map getMap(Map map) {
		Map map1 = new Map();
		List<Map> mapReturn = mongoTemplate.find(query(where("_id").is(map.getId())), Map.class);
		map1 = mapReturn.get(0);
		return map1;
	}

	public void deleteMap(Map map) {
		mongoTemplate.remove(map, COLLECTION_NAME);
		
	}

	public void changeMap(Map map) {
		mongoTemplate.insert(map, COLLECTION_NAME);		
	}
	
	public List<Map> getAllMaps() {
		return mongoTemplate.findAll(Map.class, COLLECTION_NAME);
	}
	
}