package project.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
    @GeneratedValue
    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public double getBalance() {
		return balance;
	}
	
	// copying from book 
	// issue : can he really set the balance?
	// hint : solution is in somewhere in HF design pattern book 
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
    
    //getters & setters...
    
    
}

