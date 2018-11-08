package payment;

public class bitcoin extends PaymentType{

	public bitcoin(Payment c) {
		super(c);
	}

	@Override
	public void applyPay() {
		System.out.print("");
		payment.applyPay();
	} 

}