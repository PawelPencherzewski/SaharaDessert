package payment;

public class creditCard extends PaymentType{

	public creditCard(Payment c) {
		super(c);
	}

	@Override
	public void applyPay() {
		System.out.print("");
		payment.applyPay();
	} 

}