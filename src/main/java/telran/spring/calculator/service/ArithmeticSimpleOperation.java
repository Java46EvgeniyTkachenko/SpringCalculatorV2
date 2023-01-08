package telran.spring.calculator.service;

import java.util.*;
import java.util.function.BiFunction;

import org.springframework.stereotype.Service;

import telran.spring.calculator.dto.*;
@Service   //("arithmetic-simple")
public class ArithmeticSimpleOperation implements Operation {
private static Map<String, BiFunction<Double, Double, String>> operations;
static {
	operations = new HashMap<>();
	operations.put("*", (o1, o2) -> o1 * o2 + "");
	operations.put("-", (o1, o2) -> o1 - o2 + "");
	operations.put("+", (o1, o2) -> o1 + o2 + "");
	operations.put("/", (o1, o2) -> o1 / o2 + "");
	
}
	@Override
	public String execute(OperationData data) {
		String res = "";
		try {
			ArithmeticOperationData arithmeticData = (ArithmeticOperationData) data;
			var function = operations.getOrDefault(data.additionalData,
					(o1, o2) -> "Wrong arithmetic operation should be (*,/,+,-)");
			res =function.apply(arithmeticData.operand1, arithmeticData.operand2);
		} catch (Exception e) {
			res = "Arithmetic Operation mismatch type data";
		}
		
		return res;
	}

}
