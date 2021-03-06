package com.services.eCommerceRestful.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customer_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="user_email")
	private String userEmail; 
	
	@Column(name="order_time")
	private String orderTime;
	
	@Column(name="order_Amount")
	private double orderAmount;
	
	@OneToOne(mappedBy="order",cascade=CascadeType.ALL)
	@JsonManagedReference
	private OrderAddress orderAddress;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItem> orderItems;
	
	public Order() {
		
	}

	public Order(String userEmail, String orderTime, double orderAmount, OrderAddress orderAddress,
			List<OrderItem> orderItems) {
		this.userEmail = userEmail;
		this.orderTime = orderTime;
		this.orderAmount = orderAmount;
		this.orderAddress = orderAddress;
		this.orderItems = orderItems;
	}



	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userEmail=" + userEmail + ", orderTime=" + orderTime + ", orderAmount="
				+ orderAmount + ", orderAddress=" + orderAddress + ", orderItems=" + orderItems + "]";
	}

	
	
	
	

}
