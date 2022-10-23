package com.tpizza.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpizza.pojos.User;
import com.tpizza.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getUsers(String email) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if(!email.isEmpty()){
            Predicate p = builder.equal(root.get("email").as(String.class), email.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public boolean updateUser(User user, String userUpdate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(userUpdate, user);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }


    
}
