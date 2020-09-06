package nix.jdbc.util;

import nix.jdbc.entity.Account;
import nix.jdbc.entity.Operation;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DbConnection extends Configs {

    Connection dbConnection;

    private final String url = "jdbc:postgresql://" + dbHost + ":" + dbPort+ "/" + dbName;
    private final String user;
    private final String password;
    private final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DbConnection(String user, String password ){
        this.user = user;
        this.password = password;
    }

    public Connection getDbConnection(){
        try{
            dbConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }


    public List<Account> getAccountsByUserId(Long userId){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + " accounts "
                + " WHERE "+" user_id " +" = "
                + userId ;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Account> accounts = new ArrayList<>();

        Long idResult; Long userIdResult; Long currencyResult;
        try{
            while (true) {
                try {
                    if (!resSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                idResult = resSet.getLong("id");
                userIdResult = resSet.getLong("user_id");
                currencyResult = resSet.getLong("currency");
                Account account = new Account(idResult, userIdResult, currencyResult);

                accounts.add(account);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Operation> getOperationsByAccount(Account account, String sinceDate, String tillDate){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + " operations "
                + " WHERE "+" account_id " +" = " +account.getId();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
//            prSt.setLong(1, account.getId());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Operation> operations = new ArrayList<>();

        Long idResult; Long accountIdResult; String dateResult;
        Long amountResult; Long currencyResult; String typeResult;
        Instant formattedDate = null;


        try{
            while (true) {
                try {
                    if (!resSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                idResult = resSet.getLong("id");
                accountIdResult = resSet.getLong("account_id");
                dateResult = resSet.getString("date");
                amountResult = resSet.getLong("amount");
                currencyResult = resSet.getLong("currency");
                typeResult = resSet.getString("type");

                formattedDate = format.parse(dateResult).toInstant();

                Operation operation = new Operation(idResult,accountIdResult,formattedDate,amountResult,
                        currencyResult,typeResult);

                operations.add(operation);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return operations;
    }


    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
