package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注文商品のドメインクラス.
 * @author sho
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	/** 注文商品ID */
	private Long id;
	/** 注文した商品固有のID */
	private Long itemId;
	/** 注文数 */
	private Integer quantity;
	/** 注文ID */
	private Long orderId;
	/** 注文商品 */
	private Item item;
}
