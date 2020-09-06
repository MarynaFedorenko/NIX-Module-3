package nix.jdbc.util;

import nix.jdbc.entity.Account;
import nix.jdbc.entity.Operation;

import java.util.Arrays;
import java.util.List;

public class CheckCreator {
    private final Account account;
    private final List<Operation> operations;
    private final String filePath;


    public CheckCreator(Account account, List<Operation> operations, String filePath){
        this.account = account;
        this.operations = operations;
        this.filePath = filePath;
    }

    public void createCheck (){
        String accountId = String.valueOf(account.getId());
        String generalIncome = String.valueOf(generalIncomeCount());
        String saldo = saldoCount().toString();
        List<String> headers = Arrays.asList("account_id", "date", "amount", "currency", "type");
        String [][] cells = new String [operations.size()+5][headers.size()];
        for(int i=0; i<operations.size(); i++){
            cells[i][0] = accountId;
            cells[i][1] = operations.get(i).getDate().toString();
            cells[i][2] = operations.get(i).getAmount().toString();
            cells[i][3] = operations.get(i).getCurrency().toString();
            cells[i][4] = operations.get(i).getType();
        }
        for(int i=0; i<5; i++)
            cells[operations.size()][i] = "     ";


        cells[operations.size()+1][0] = "general income";
        cells[operations.size()+1][1] = "saldo";
        cells[operations.size()+1][2] = "     ";
        cells[operations.size()+1][3] = "     ";
        cells[operations.size()+1][4] = "     ";
        cells[operations.size()+2][0] = "       "+generalIncome;
        cells[operations.size()+2][1] = "       "+saldo;
        cells[operations.size()+2][2] = "     ";
        cells[operations.size()+2][3] = "     ";
        cells[operations.size()+2][4] = "     ";
        for(int i=operations.size()+3; i<operations.size()+5; i++){
            for(int j=0; j<5; j++){
              cells[i][j] = "     ";
            }
        }
        for(int i=0; i<operations.size()+3; i++){
            for(int j=0; j<5; j++){
                System.out.print("  "+cells[i][j]);
            }
            System.out.println();
        }

        CsvTable csvTable = new CsvTable(headers,cells);
        CsvTable.writeIntoFile(csvTable, filePath);

    }

    public int generalIncomeCount(){
        int generalIncome = 0;
        for(Operation operation : operations){
            if(operation.getAmount()>0)
                generalIncome+= operation.getAmount();
        }
        return generalIncome;
    }

    public Long saldoCount(){
        Long startBalance = account.getCurrency();
        Long endBalance = operations.get(operations.size()-1).getCurrency();
        return endBalance-startBalance;

    }



    public Account getAccount() {
        return account;
    }

    public List<Operation> getOperations() {
        return operations;
    }


    public String getFilePath() {
        return filePath;
    }
}
