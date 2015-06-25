package com.smartrecruiters.oauth.example.smartrecruiters.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


@Controller
public class SmartrecruitersController {

	private RestOperations smartrecruitersRestTemplate;

	@RequestMapping("/smartrecruiters/jobs")
	public String jobs(Model model) throws Exception {
		ObjectNode result = smartrecruitersRestTemplate
				.getForObject("https://api.smartrecruiters.com/jobs", ObjectNode.class);
		ArrayNode data = (ArrayNode) result.get("content");
		ArrayList<String> friends = new ArrayList<String>();
		for (JsonNode dataNode : data) {
			friends.add(dataNode.get("title").asText());
		}
		model.addAttribute("jobs", friends);
		return "smartrecruiters";
	}

	public void setSmartrecruitersRestTemplate(RestOperations smartrecruitersRestTemplate) {
		this.smartrecruitersRestTemplate = smartrecruitersRestTemplate;
	}

}
