
public class AccountingArrayApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ValueOfSupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double VAT = ValueOfSupply * vatRate;
		double Expense = 0.3;
		double expenserate = Expense;
		double expends = ValueOfSupply * expenserate;
		double Income = ValueOfSupply - expends;
		
		double Dividend1;
		double Dividend2;
		double Dividend3;
		
		double [] DividendRates = new double[3]; // 3개 짜리 배열 
		DividendRates[0] = 0.5;
		DividendRates[1] = 0.3;
		DividendRates[2] = 0.2;
		
		Dividend1 = Income * DividendRates[0];
		 Dividend2 = Income * DividendRates[1];
		 Dividend3 = Income * DividendRates[2]; 

		
		System.out.println("Value of supply : " + ValueOfSupply);
		System.out.println("VAT : " + VAT);
		System.out.println("Total : " + (10000 + VAT));
		System.out.println("Expense : " + expends);
		System.out.println("Income : " + Income);
		System.out.println("Dividend 1 : " +Dividend1);
		System.out.println("Dividend 2 : " +Dividend2);
		System.out.println("Dividend 3 : " +Dividend3);

	}

}
 