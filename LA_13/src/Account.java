import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	// Create a lock
	private static Lock lock = new ReentrantLock();
	
	// Create a condition
	private static Condition newDeposit = lock.newCondition();
	// Balance Value is private 
	private int balance = 1;
	public int newBalance = 1;
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amount){
		getBalance();
		newBalance = balance;
		// get the lock 
		lock.lock();
		// await until balance is larger than amount,
		try {
			while(newBalance < amount) {
				System.out.println("        \t\tWait for a deposit");
				newDeposit.await();
				}
		newBalance -= amount;
		System.out.print("        \t\tWithdraw " + amount);
		System.out.println("        \t" + newBalance);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// unlock the lock
		lock.unlock();
		balance = newBalance;
	}
	
	public void deposit(int amount) {
		getBalance();
		newBalance = balance;
		// get the lock 
		lock.lock();
		// add amount to account balance
		newBalance += amount;
		// print current balance
		System.out.print("Deposit " + amount);
		System.out.println("\t\t\t\t\t" + newBalance);
		// signal to withdraw task : 예금이 들어왔음을 알림 
		newDeposit.signal();
		// unlock the lock
		lock.unlock();
		balance = newBalance;
	}

}