package demo.model;

public class Tickets {
	
	private int ticket_id;
	private int amount;
	private String description;
	private String status;
	private int ticket_emp_id;
	
	public Tickets() {
	}

	public Tickets(int ticket_id, int amount, String description, String status, int ticket_emp_id) {
		super();
		this.ticket_id = ticket_id;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.ticket_emp_id = ticket_emp_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTicket_emp_id() {
		return ticket_emp_id;
	}

	public void setTicket_emp_id(int ticket_emp_id) {
		this.ticket_emp_id = ticket_emp_id;
	}

	@Override
	public String toString() {
		return "Tickets [ticket_id=" + ticket_id + ", amount=" + amount + ", description=" + description + ", status="
				+ status + ", ticket_emp_id=" + ticket_emp_id + "]";
	}
}
