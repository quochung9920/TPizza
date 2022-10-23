/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpizza.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private int totalPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;

    @Column(name = "name_order")
    private String nameOrder;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idClient;
    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    @ManyToOne
    private User idStaff;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<BillDetails> billDetails;
    @JoinColumn(name = "id_discount", referencedColumnName = "id")
    @ManyToOne
    private Discount idDiscount;
    
    public Discount getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Discount idDiscount) {
        this.idDiscount = idDiscount;
    }

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, Date createDate, int totalPrice, String status) {
        this.id = id;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getIdClient() {
        return idClient;
    }

    public void setIdClient(User idClient) {
        this.idClient = idClient;
    }

    public User getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(User idStaff) {
        this.idStaff = idStaff;
    }

    public List<BillDetails> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetails> billDetails) {
        this.billDetails = billDetails;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
