package payment;

public class CardDetail {

	private String id;
	private String exp_month;
	private String exp_year;
	private String name;
	private String last4;
	private boolean defaultSource;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExp_month() {
		return exp_month;
	}
	public void setExp_month(String exp_month) {
		this.exp_month = exp_month;
	}
	public String getExp_year() {
		return exp_year;
	}
	public void setExp_year(String exp_year) {
		this.exp_year = exp_year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast4() {
		return last4;
	}
	public void setLast4(String last4) {
		this.last4 = last4;
	}
	public boolean isDefaultSource() {
		return defaultSource;
	}
	public void setDefaultSource(boolean defaultSource) {
		this.defaultSource = defaultSource;
	}



}
