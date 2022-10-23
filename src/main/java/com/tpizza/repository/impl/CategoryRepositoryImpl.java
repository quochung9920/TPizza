package com.tpizza.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpizza.pojos.Category;
import com.tpizza.repository.CategoryRepository;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root root = query.from(Category.class);
        query = query.select(root);

        if(!name.isEmpty()){
            Predicate p = builder.equal(root.get("name").as(String.class), name.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root root = query.from(Category.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("id").as(Integer.class), id);
        query = query.where(p);
        Query q = session.createQuery(query);
        return (Category) q.getSingleResult();
    }

    @Override
    public Category getCategoryByShortName(String shortName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root root = query.from(Category.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("shortName").as(String.class), shortName.trim());
        query = query.where(p);
        Query q = session.createQuery(query);
        return (Category) q.getSingleResult();
    }

    
}
