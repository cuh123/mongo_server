package org.mongo.service;

import java.util.List;
import java.util.Optional;

import org.mongo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service("testService")
public class TestService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public TestModel test(String _id) throws Exception {
		TestModel testModel = mongoTemplate.findById(_id, TestModel.class);
		return testModel;
		
	}
	
	public List<TestModel> list(String name) throws Exception {
		Query query = new Query().addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.find(query, TestModel.class);
	}
	
	public List<TestModel> listAll() throws Exception {
		return mongoTemplate.findAll(TestModel.class);
	}
	
	public TestModel insertTest(TestModel testModel) throws Exception {
		return mongoTemplate.insert(testModel);
	}
}
