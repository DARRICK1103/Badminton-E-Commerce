
public class OrderList {

	private int List_ID;
	private int Product_ID;
	private int Order_ID;
	
	private int Quantity;
	private double subtotal;
	
	public int getList_ID() {
		return List_ID;
	}
	public void setList_ID(int list_ID) {
		List_ID = list_ID;
	}
	public int getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}
	public int getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
