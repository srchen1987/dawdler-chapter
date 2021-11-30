package com.anywide.shop.product.entity;

import java.math.BigDecimal;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.product_id
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.product_name
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.stock
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.addtime
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    private Integer addtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.amount
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    private BigDecimal amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.product_id
     *
     * @return the value of t_product.product_id
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.product_id
     *
     * @param productId the value for t_product.product_id
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.product_name
     *
     * @return the value of t_product.product_name
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.product_name
     *
     * @param productName the value for t_product.product_name
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.stock
     *
     * @return the value of t_product.stock
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.stock
     *
     * @param stock the value for t_product.stock
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.addtime
     *
     * @return the value of t_product.addtime
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public Integer getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.addtime
     *
     * @param addtime the value for t_product.addtime
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.amount
     *
     * @return the value of t_product.amount
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.amount
     *
     * @param amount the value for t_product.amount
     *
     * @mbg.generated Thu Jul 29 19:02:20 CST 2021
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}