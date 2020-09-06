package nix.jdbc;

import nix.jdbc.entity.Account;
import nix.jdbc.entity.Operation;
import nix.jdbc.util.CheckCreator;
import nix.jdbc.util.DbConnection;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;
import java.util.Scanner;

public class ApplicationWithJDBC {

    final static Logger LOGGER = Logger.getLogger(ApplicationWithJDBC.class);

    public static void main(String[] args) {
        String log4jConfigPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter user ID:  ");
        Long id = in.nextLong();
        LOGGER.info("User entered USER_ID "+id);
        System.out.println("Enter database username: ");
        String username = in.next();
        LOGGER.info("User entered USERNAME "+username);
        System.out.println("Enter database password: ");
        String password = in.next();
        LOGGER.info("User entered PASSWORD "+password);

        //Измени даты в соответствии с данными в таблице
        String sinceDate = "2020-09-01 10:00:00";
        String tillDate = "2019-09-28 10:00:00";
        String filepath = "check.csv";

        DbConnection db = new DbConnection(username, password);
        db.getDbConnection();
        LOGGER.info("Connecting to the database...");

        List<Account> accounts = db.getAccountsByUserId(id);
        if(accounts.size()!=0){
            for(Account acc : accounts){
                LOGGER.info("Checking account "+acc.getId());
                List<Operation> operations = db.getOperationsByAccount(acc, sinceDate, tillDate);
                if(operations.size()!=0){
                    LOGGER.info("Account "+acc+ " contains "+operations.size()+" operations");
                    CheckCreator checkCreator = new CheckCreator(acc, operations, filepath);
                    checkCreator.createCheck();
                    LOGGER.info(" Check was created ");

                }
                else System.out.println("Account "+ acc.getId()+" doesn't have any operation");

            }
        }else System.out.println("User "+id+" doesn't have any account");



    }
}
