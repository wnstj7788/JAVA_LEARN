class Accounting{
	public  double valueOfSupply;// 전역변수로 선
    public  double vatRate;
    public  double expenseRate;
    public  double getDiviend1() {
        return getIncome() * 0.5;
    }
    public  double getDiviend2() {
        return getIncome() * 0.3;
    }
    public  double getDiviend3() {
        return getIncome() * 0.2;
    }
 
    public  double getIncome() {
        return valueOfSupply - getExpense();
    }
 
    public  double getExpense() {
        return valueOfSupply * expenseRate;
    }
 
    public  double getTotal() {
        return valueOfSupply + getVAT();
    } 
 
    public  double getVAT() {
        return valueOfSupply * vatRate;//전역 변수로 선언되어있기에 외부 메소드에서도 활용 가능 
    }
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}

public class AccountingClassApp {
    
    public static void main(String[] args) {
       // Accounting.valueOfSupply = 10000.0;
        //Accounting.vatRate = 0.1;
        //Accounting.expenseRate = 0.3;
        
        
        
        //instance 클래스를 복제 
        Accounting a1 = new Accounting();
       
        a1.valueOfSupply = 10000.0;
        a1.vatRate = 0,1;
        a1.expenseRate = 0.3;
        a1.print();
        
        
        Accounting a2 = new Accounting();
        
        a2.valueOfSupply = 10000.0;
        a2.vatRate = 0,1;
        a2.expenseRate = 0.3;
        a2.print();
        
        
        
    }
 
}
 

 