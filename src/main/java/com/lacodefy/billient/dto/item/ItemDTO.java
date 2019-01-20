/**
 *
 */
package com.lacodefy.billient.dto.item;

import java.math.BigDecimal;

/**
 * @author Tharanaga Dinesh
 *
 */
public class ItemDTO {

	private Integer id;
	private String itemName;
	private String sku;

	private BigDecimal purchasePrice;
	private BigDecimal sellingPrice;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(final String sku) {
		this.sku = sku;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(final BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(final BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}
