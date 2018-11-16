package payment;

public class creditCard extends PaymentType{

        
        public creditCard(Payment c, String name) {
		super(c, name);
	}

	@Override
	public void applyPay() {
		System.out.print("Selected payment method: ");
		payment.applyPay();
	} 

}