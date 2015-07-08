package com.lihui.hibernate.double_n_1;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer customerId;
	private String customerName;
	private Set<Order> orders = new HashSet<Order>();
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
