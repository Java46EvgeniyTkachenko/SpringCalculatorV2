package telran.spring.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import telran.spring.calculator.dto.OperationData;

public interface Operation {
	static Logger LOG = LoggerFactory.getLogger(Operation.class);
String execute(OperationData data);
}
