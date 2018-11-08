package payment;

public abstract class PaymentType {
	//Composition - implementor
	protected Payment payment;
	
	//constructor with implementor as input argument
	public PaymentType(Payment c){
		this.payment=c;
	}
	
	abstract public void applyPay();
}