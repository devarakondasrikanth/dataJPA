package com.spring.io.srikanth.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

		@Autowired
		private TopicRepository topicRepo;
		
		public List<Topic> getAllTopic(){
			List<Topic> topics = new ArrayList<Topic>();
			topicRepo.findAll().forEach(topics::add);
			return topics;
		}
		
		public void addTopic(Topic topic){
			topicRepo.save(topic);
		}
		
		public Topic getTopic(String id){
			return topicRepo.findOne(id);
		}
		
		public void updateTopic(Topic topic){
			topicRepo.save(topic);
		}
		public void deleteTopic(String id){
			topicRepo.delete(id);
		}
}
