package nix.hibernate.repository.impl;

import nix.hibernate.entity.ExpenseCategory;
import nix.hibernate.entity.IncomeCategory;
import nix.hibernate.repository.ExpenseCategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ExpenseCategoryRepositoryImpl implements ExpenseCategoryRepository {

    private final SessionFactory sessionFactory;
    private Session session;

    public ExpenseCategoryRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory  = sessionFactory;
    }

    public void update(ExpenseCategory expenseCategory){
        session = sessionFactory.getCurrentSession();
        session.update(expenseCategory);
    }

    public void save(ExpenseCategory expenseCategory){
        session = sessionFactory.getCurrentSession();
        session.save(expenseCategory);
    }

    public ExpenseCategory createExpenseCategory(String details){
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setDetails(details);
        save(expenseCategory);
        return expenseCategory;
    }

}
