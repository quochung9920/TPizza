
package com.tpizza.pojos;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Column(name = "image")
    private String image;
    

    @JoinColumn(name = "id_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category idCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    @JsonIgnore
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    @JsonIgnore
    private List<BillDetails> billDetailsList;

    
    @Transient
    @JsonIgnore
    private MultipartFile productImage;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<BillDetails> getBillDetailsList() {
        return billDetailsList;
    }

    public void setBillDetailsList(List<BillDetails> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }
}
