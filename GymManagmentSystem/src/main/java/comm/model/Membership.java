package comm.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Membership {

	private String type; // Monthly, Quarterly, Yearly
	@Autowired
	private LocalDate startDate;
	@Autowired
	private LocalDate endDate;
	
	public Membership()
	{
		
	}
		    
	public Membership(String type, LocalDate startDate, int durationInMonths) {
		this.type = type;
		this.startDate = startDate;
		this.endDate = startDate.plusMonths(durationInMonths);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(int durationInMonths) {
		this.endDate = this.startDate.plusMonths(durationInMonths);
	}
	
	
}
