package java8.lambdaexpression;

public class Invoice {
	private Integer id;
	private Customer customer;
	private double amount;
	private String title;
	public Invoice() {
		System.out.println("Empty Constructor");
	}
	
	public Invoice(Integer id, Customer customer, double amount) {
		super();
		this.id = id;
		this.customer = customer;
		this.amount = amount;
	}
	
	public Invoice(double amount) {
		this.amount = amount;
		System.out.println("Amount Constructor");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
        return "amount: " + amount;
    }
}
