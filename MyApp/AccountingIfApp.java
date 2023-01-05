
public class AccountingIfApp {
	public static double ValueOfSupply;//전역변수로 선
	public static double vatRate;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vatRate = 0.1;
		ValueOfSupply = 10000.0;
		double VAT = getVat();
		double Expense = 0.3;
		double expenserate = Expense;
		double expends = getVat(ValueOfSupply, expenserate);
		double Income = ValueOfSupply - expends;
		
		double Dividend1;
		double Dividend2;
		double Dividend3;
		
		if (Income > 10000.0) {
		 Dividend1 = Income *0.5;
		 Dividend2 = Income * 0.3;
		 Dividend3 = Income *0.2; 
		}else {
			 Dividend1 = Income *1.0;
			 Dividend2 = Income * 0.0;
			 Dividend3 = Income *0.0;
			
		}
		System.out.println("Value of supply : " + ValueOfSupply);
		System.out.println("VAT : " + VAT);
		System.out.println("Total : " + (10000 + VAT));
		System.out.println("Expense : " + expends);
		System.out.println("Income : " + Income);
		System.out.println("Dividend 1 : " +Dividend1);
		System.out.println("Dividend 2 : " +Dividend2);
		System.out.println("Dividend 3 : " +Dividend3);

	}

	private static double getVat() { 
		return ValueOfSupply * vatRate; //전역 변수로 선언되어있기에 외부 메소드에서 활용가능 
	}

}
 