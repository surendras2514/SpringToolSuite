package com.spring.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.entity.Account;

public class AccountHibernateDAOSupportImpl
extends HibernateDaoSupport 
implements AccountDAO{

	@Transactional
	public void save(Account account) {
		getHibernateTemplate().save(account);
	}
	

}
