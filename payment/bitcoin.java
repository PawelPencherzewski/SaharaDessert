package payment;

public class bitcoin extends PaymentType{

	public bitcoin(Payment c, String name) {
		super(c, name);
	}

	@Override
	public void applyPay() {
		System.out.print("Selected payment method: ");
		payment.applyPay();
	} 
}