package com.paradigmadigital.watto.order;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	private String id;
    private List<OrderLine> orderLines;
	private String offerIdApplied;
	private long shipDate;
	private OrderStatus orderStatus;
	private boolean complete;
	private String userId;
	
}
