package nix.hibernate.util;

import nix.hibernate.entity.Account;
import nix.hibernate.entity.IncomeCategory;
import nix.hibernate.repository.impl.AccountRepositoryImpl;
import nix.hibernate.repository.impl.ExpenseCategoryRepositoryImpl;
import nix.hibernate.repository.impl.IncomeCategoryRepositoryImpl;
import nix.hibernate.repository.impl.OperationRepositoryImpl;
import nix.jdbc.ApplicationWithJDBC;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class OperationCreator {
private final SessionFactory sessionFactory;
private Session session;



private final AccountRepositoryImpl accountRepository;
private final OperationRepositoryImpl operationRepository;
private final IncomeCategoryRepositoryImpl incomeCategoryRepository;
private final ExpenseCategoryRepositoryImpl expenseCategoryRepository;

    final static Logger LOGGER = Logger.getLogger(OperationCreator.class);

    public OperationCreator(SessionFactory sessionFactory, AccountRepositoryImpl accountRepository,
                            OperationRepositoryImpl operationRepository,
                            IncomeCategoryRepositoryImpl incomeCategoryRepository,
                            ExpenseCategoryRepositoryImpl expenseCategoryRepository) {
        this.sessionFactory = sessionFactory;
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
        this.incomeCategoryRepository = incomeCategoryRepository;
        this.expenseCategoryRepository = expenseCategoryRepository;
        String log4jConfigPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
    }

    public void createOperation(Long userId, Long accountId, Long amount) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Account account = session.get(Account.class, accountId);
        if(!account.getUser().getId().equals(userId)){
            System.out.println("Wrong account! Try again");
            LOGGER.error("Wrong account id");
            createOperation(userId, accountId, amount);
        }
        else if(amount==0){
            System.out.println("Amount equals zero!");
            LOGGER.error("Amount equals zero");
        }
        else{
            operationRepository.createOperation(account, amount);
            session.getTransaction().commit();

        }
    }


}
