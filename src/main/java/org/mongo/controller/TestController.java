package org.mongo.controller;

import java.util.List;

import org.mongo.model.TestModel;
import org.mongo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public TestModel test(@RequestParam("_id") String _id) throws Exception {
		return testService.test(_id);
	}
	
	@RequestMapping(value="/test_list", method=RequestMethod.GET)
	public List<TestModel> testList(@RequestParam("name") String name) throws Exception {
		return testService.list(name);
	}
	
	@RequestMapping(value="/test_all", method=RequestMethod.GET)
	public List<TestModel> testListAll() throws Exception {
		return testService.listAll();
	}
	
	@RequestMapping(value="/test_insert", method=RequestMethod.POST)
	public TestModel testInsert(@RequestBody TestModel testModel) throws Exception {
		return testService.insertTest(testModel);
	}
}
