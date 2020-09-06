package nix.hibernate.repository.impl;

import nix.hibernate.entity.IncomeCategory;
import nix.hibernate.repository.IncomeCategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class IncomeCategoryRepositoryImpl implements IncomeCategoryRepository {

    private final SessionFactory sessionFactory;
    private Session session;

    public IncomeCategoryRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory  = sessionFactory;
    }

    public void update(IncomeCategory incomeCategory){
        session = sessionFactory.getCurrentSession();
        session.update(incomeCategory);
    }

    public void save(IncomeCategory incomeCategory){
        session = sessionFactory.getCurrentSession();
        session.save(incomeCategory);
    }

    public IncomeCategory createIncomeCategory(String details){
        IncomeCategory incomeCategory = new IncomeCategory();
        incomeCategory.setDetails(details);
        save(incomeCategory);
        return incomeCategory;
    }


}
