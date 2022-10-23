package com.tpizza.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.tpizza.pojos.Product;
import com.tpizza.repository.ProductRepository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Product> getProducts(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);

        if (!name.isEmpty()) {
            Predicate p = builder.equal(root.get("name").as(String.class), name.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public Product addProduct(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);

            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Product> getAllProducts() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Product> getProductsByCategory(int category) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Product WHERE idCategory = " + category);

        return query.getResultList();
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query<Product> query = session.createQuery("FROM Product WHERE id = " + id);

        return query.getSingleResult();
    }

    @Override
    public Product updateProduct(int product, int amount) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Product p = getProductById(product);
            p.setAmount(amount);
            session.update(p);
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
