
package com.tpizza.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bill_details")
public class BillDetails implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private int totalPrice;
    @JoinColumn(name = "id_bill", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Bill bill;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product idProduct;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Bill getBill() {
        return bill;
    }
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    public Product getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }
    
}
