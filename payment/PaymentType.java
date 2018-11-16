package payment;

public abstract class PaymentType {
	//Composition - implementor
	protected Payment payment;
        public String name;
	
	//constructor with implementor as input argument
        
	public PaymentType(Payment c, String name){
		this.payment=c;
                this.name=name;
	}
	
	abstract public void applyPay();
}