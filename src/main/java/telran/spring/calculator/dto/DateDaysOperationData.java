package telran.spring.calculator.dto;
import jakarta.validation.constraints.*;

public class DateDaysOperationData extends OperationData {
	@Pattern (regexp="\\d{4}-\\d{2}-\\d{2}")
	public String date;
	public int days;
}
