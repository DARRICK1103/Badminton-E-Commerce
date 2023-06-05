
public class Order {
	private int Order_ID;
	private int Payment_ID;
	private int Customer_ID;
	
	private String Ship_Address;
	private String ORDER_DATE;
	private int Status;
	
	public int getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}
	public int getPayment_ID() {
		return Payment_ID;
	}
	public void setPayment_ID(int payment_ID) {
		Payment_ID = payment_ID;
	}
	public int getCustomer_ID() {
		return Customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}
	
	public String getShip_Address() {
		return Ship_Address;
	}
	public void setShip_Address(String ship_Address) {
		Ship_Address = ship_Address;
	}
	public String getORDER_DATE() {
		return ORDER_DATE;
	}
	public void setORDER_DATE(String oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		this.Status = status;
	}
	
	

}
