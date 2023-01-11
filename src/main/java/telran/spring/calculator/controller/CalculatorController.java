package telran.spring.calculator.controller;


import java.util.*;
import org.slf4j.*;


import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.Valid;
import telran.spring.calculator.dto.OperationData;
import telran.spring.calculator.service.Operation;


@RestController
@RequestMapping("calculator")
public class CalculatorController {
	static Logger LOG = LoggerFactory.getLogger(CalculatorController.class);
	//List<Operation> operations;
	Map<String, Operation> operationServices;
	List<Operation> operationList;
	public CalculatorController(Map<String, Operation> operationServices, List<Operation> operationList) {
		this.operationServices = operationServices;
		this.operationList = operationList;
	}
	@PostMapping
	String getOperationResult(@RequestBody @Valid OperationData data) {
	LOG.debug("received request for execute operation Name: {}, additional data: {}", data.operationName, data.additionalData);	
		Operation operationService = operationServices.get(data.operationName);
		String res = operationService != null ? operationService.execute(data) : 
			String.format("Wrong operation name, should be one from %s",
					operationServices.keySet());
		LOG.debug("received request for execute result:{}",res);
		return res;
			
	}
	@GetMapping
	Set<String> getAllOperationNames() {
		return operationServices.keySet();
	}
	@PostConstruct
	void displayTypes() {
		System.out.printf("application context is created with types %s\n", operationList);
		LOG.info("application context is created with types {}", operationServices.keySet());	
	}
	
	@PreDestroy
	void shutdown() {
		System.out.println("Bye performed graceful shutdown");
	}
	

}
