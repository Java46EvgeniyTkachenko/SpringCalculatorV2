package telran.spring.calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import telran.spring.calculator.dto.*;
import telran.spring.calculator.service.*;

@SpringBootTest
class CalculatorServiceTests {
	@Autowired
	ArithmeticSimpleOperation arithmetic; //= new ArithmeticSimpleOperation();
	@Autowired
	DatesBetweenOperation dateBetween; //= new DatesBetweenOperation();
	@Autowired
	DatesSimpleOperation dateSimple; //= new DatesSimpleOperation();

	@Test
	void arithmeticTest() {
		ArithmeticOperationData data = new ArithmeticOperationData();
		data.operationName = "arithmetic-simple";
		data.additionalData ="+";
		data.operand1 = 10.0;
		data.operand2 =3.0;
		String res = arithmetic.execute(data);
		assertTrue(res.contains("13.0"));
	}
	@Test
	void daysBetweenTest() {
		DatesOperationData data = new DatesOperationData();
		data.operationName = "dates-between";
		data.additionalData =null;
		data.dateFrom="2022-10-12";
		data.dateTo="2022-06-10";
		String res = dateBetween.execute(data);
		assertTrue(res.contains("-124"));
	}
	@Test
	void daysPlusDaysTest() {
		DateDaysOperationData data = new DateDaysOperationData();
		data.operationName = "dates-simple";
		data.additionalData ="before";
		data.date="2022-10-12";
		data.days=10;
		String res = dateSimple.execute(data);
		assertTrue(res.contains("2022-10-02"));
	}

}
