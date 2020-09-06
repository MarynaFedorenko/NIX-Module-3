package nix.hibernate.repository.impl;

import nix.hibernate.entity.Account;
import nix.hibernate.repository.AccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountRepositoryImpl implements AccountRepository {
    private final SessionFactory sessionFactory;
    private Session session;

    public AccountRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory  = sessionFactory;
    }


    public void update(Account account){
        session = sessionFactory.getCurrentSession();
        session.update(account);
        session.update(account);
    }

    public Account findAccountById(Long id){
        session = sessionFactory.getCurrentSession();
        return session.get(Account.class, id);
    }

    public void updateCurrency(Long id, Long currency){
        Account account = findAccountById(id);
        if(currency!=0 && account!=null){}
        account.setCurrency(account.getCurrency()+currency);
        update(account);
    }
}
