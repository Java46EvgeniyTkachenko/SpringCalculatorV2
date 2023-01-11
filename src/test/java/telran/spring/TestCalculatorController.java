package telran.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.spring.calculator.controller.*;
import telran.spring.calculator.dto.*;



//@SpringBootTest(classes= CalculatorController.class)
@WebMvcTest(CalculatorController.class)	
class TestCalculatorController {
@Autowired
 MockMvc mockMvc;
ObjectMapper mapper;
	@Test
	void rightDataControllerTest() throws Exception {	
		DatesOperationData data = new DatesOperationData();		
		data.operationName = "dates-between";
		data.additionalData = null;
		data.dateFrom = "2022-12-10";
		data.dateTo = "2022-10-10";
		
		String	messageJSON = mapper.writeValueAsString(data);
			
			mockMvc.perform(post("http://localhost:8080/calculator")
					.contentType(MediaType.APPLICATION_JSON).content(messageJSON))
					.andExpect(status().isOk());
		
	
		}
	@Test
	void falseDataControllerTest() throws Exception {
		String messageJSON;
		DatesOperationData data = new DatesOperationData();		
		data.operationName = "date-between";
		data.additionalData = null;
		data.dateFrom = "22-12-10";
		data.dateTo = "22-10-10";
		try {
			messageJSON = mapper.writeValueAsString(data);
			mockMvc.perform(post("http://localhost:8080/calculator")
					.contentType(MediaType.APPLICATION_JSON).content(messageJSON))
			.andExpect(status().isBadRequest());
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}

	}

	

}