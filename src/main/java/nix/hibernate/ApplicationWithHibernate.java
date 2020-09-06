package nix.hibernate;

import nix.hibernate.repository.impl.AccountRepositoryImpl;
import nix.hibernate.repository.impl.ExpenseCategoryRepositoryImpl;
import nix.hibernate.repository.impl.IncomeCategoryRepositoryImpl;
import nix.hibernate.repository.impl.OperationRepositoryImpl;
import nix.hibernate.util.OperationCreator;
import nix.jdbc.ApplicationWithJDBC;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ApplicationWithHibernate {

    final static Logger LOGGER = Logger.getLogger(ApplicationWithHibernate.class);

        public static void main(String[] args) {
            String log4jConfigPath = "src/main/resources/log4j.properties";
            PropertyConfigurator.configure(log4jConfigPath);

            Scanner in = new Scanner(System.in);
            System.out.println("Enter user ID:  ");
            Long id = in.nextLong();
            LOGGER.info("User entered USER_ID " + id);
            System.out.println("Enter database username: ");
            String username = in.next();
            LOGGER.info("User entered USERNAME " + username);
            System.out.println("Enter database password: ");
            String password = in.next();
            LOGGER.info("User entered PASSWORD " + password);
            System.out.println("Enter account for new operation: ");
            Long accountId = in.nextLong();
            LOGGER.info("User entered accountId " + accountId);
            System.out.println("Enter amount to add: ");
            Long amount = in.nextLong();
            LOGGER.info("User entered amount " + amount);

            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.username", username)
                    .setProperty("hibernate.connection.password", password)
                    .configure();

            try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()){
                AccountRepositoryImpl accountRepository = new AccountRepositoryImpl(sessionFactory);
                OperationRepositoryImpl operationRepository = new OperationRepositoryImpl(sessionFactory);
                IncomeCategoryRepositoryImpl incomeCategoryRepository = new IncomeCategoryRepositoryImpl(sessionFactory);
                ExpenseCategoryRepositoryImpl expenseCategoryRepository = new ExpenseCategoryRepositoryImpl(sessionFactory);

                OperationCreator operationCreator = new OperationCreator(sessionFactory, accountRepository,
                operationRepository, incomeCategoryRepository,expenseCategoryRepository);

                operationCreator.createOperation(id, accountId, amount);

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
