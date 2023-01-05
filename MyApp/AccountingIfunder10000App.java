
public class AccountingIfunder10000App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ValueOfSupply = 10000.0;
		double vatRate = 0.1;
		double VAT = ValueOfSupply * vatRate;
		double Expense = 0.3;
		double expenserate = Expense;
		double expends = ValueOfSupply * expenserate;
		double Income = ValueOfSupply - expends;
		double Dividend1 = Income *1.0;
		double Dividend2 = Income * 0.0;
		double Divdend3 = Income *0.0;
		
		System.out.println("Value of supply : " + ValueOfSupply);
		System.out.println("VAT : " + VAT);
		System.out.println("Total : " + (10000 + VAT));
		System.out.println("Expense : " + expends);
		System.out.println("Income : " + Income);
		System.out.println("Dividend 1 : " +Dividend1);
		System.out.println("Dividend 2 : " +Dividend2);
		System.out.println("Dividend 3 : " +Divdend3);

	}

}
 