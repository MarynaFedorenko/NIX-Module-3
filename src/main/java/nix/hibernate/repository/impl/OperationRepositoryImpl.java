package nix.hibernate.repository.impl;

import nix.hibernate.ApplicationWithHibernate;
import nix.hibernate.entity.*;
import nix.hibernate.repository.OperationRepository;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OperationRepositoryImpl implements OperationRepository {
    private final SessionFactory sessionFactory;
    private Session session;

    final static Logger LOGGER = Logger.getLogger(OperationRepositoryImpl.class);

    public OperationRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory  = sessionFactory;
        String log4jConfigPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
    }

    public void save(Operation operation){
        session = sessionFactory.getCurrentSession();
        session.save(operation);
    }

    public Operation createOperation(Account account, Long amount){
        Operation operation = new Operation();
        operation.setAccount(account);
        operation.setDate(Instant.now());
        operation.setAmount(amount);
        operation.setCurrency(account.getCurrency());

        if(amount>0) {
            operation.setType("income");
            IncomeCategory incomeCategory = new IncomeCategory();
            incomeCategory.setDetails("account "+account.getId()+" operation type INCOME");
            List<IncomeCategory> incomeCategories = new ArrayList<>();
            incomeCategories.add(incomeCategory);
            operation.setIncomeCategories(incomeCategories);
            LOGGER.info("In account "+account.getId()+" operation was created: type INCOME, amount "+amount);

        }
        else {
            operation.setType("expense");
            ExpenseCategory expenseCategory = new ExpenseCategory();
            expenseCategory.setDetails("account "+account.getId()+" operation type EXPENSE");
            List<ExpenseCategory> expenseCategories = new ArrayList<>();
            expenseCategories.add(expenseCategory);
            operation.setExpenseCategories(expenseCategories);
            LOGGER.info("In account "+account.getId()+" operation was created: type EXPENSE, amount "+amount);

        }
        return operation;
    }

}
