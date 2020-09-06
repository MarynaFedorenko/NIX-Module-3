package nix.jdbc.entity;

public class Category {
    private Long id;
    private Long operationId;
    private Long incomeId;
    private Long expenseId;


    public Category(Long id, Long operationId, Long incomeId, Long expenseId){
        this.id = id;
        this.operationId = operationId;
        this.incomeId = incomeId;
        this.expenseId = expenseId;
    }

    public Category(){}


    public Long getId() {
        return id;
    }

    public Long getOperationId() {
        return operationId;
    }

    public Long getIncomeId() {
        return incomeId;
    }

    public Long getExpenseId() {
        return expenseId;
    }
}
