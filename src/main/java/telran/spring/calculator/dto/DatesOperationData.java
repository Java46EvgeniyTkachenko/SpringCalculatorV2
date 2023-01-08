package telran.spring.calculator.dto;

import jakarta.validation.constraints.Pattern;

public class DatesOperationData extends OperationData {
	@Pattern (regexp="\\d{4}-\\d{2}-\\d{2}")	
public String dateFrom;
	@Pattern (regexp="\\d{4}-\\d{2}-\\d{2}")
public String dateTo;
}
