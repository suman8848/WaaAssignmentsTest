package cs545.bank.bean.view;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.bank.domain.Account;
import cs545.bank.service.IAccountService;

@RequestScoped
@Named
public class AccountBean {
	@Inject
	private IAccountService accountService;
	private long  accNumber;
	private String custName;
	private Double balance;
	private Double amount;


	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public long getAccNumber() {
		return accNumber;
	}
	
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
  public void createAccount() {
	  accountService.createAccount(accNumber, custName);
	  System.out.println(this.getAccNumber());
  }
	
  public void deposit() {
	  accountService.deposit(accNumber, amount);
  }
  
  public void withdraw() {
	  accountService.withdraw(accNumber, amount);
  }
  
 public Account getAccount() {
		Account account = accountService.getAccount(accNumber);
		return account;
	}
	
 public Collection<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
  
  public void getAccount(Long accountNmuber) {
	  Account account= accountService.getAccount(accountNmuber);
	  this.accNumber = account.getAccountnumber();
	  this.custName = account.getCustomer().getName();
	  this.balance = account.getBalance();
  }

}
