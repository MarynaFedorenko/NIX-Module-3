package nix.hibernate.entity;


import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="operation_id", nullable = false)
//    private Operation operation;
//
//    @ManyToOne
//    @JoinColumn(name="income_id", nullable = false)
//    private IncomeCategory incomeCategory;
//
//    @ManyToOne
//    @JoinColumn(name="expense_id", nullable = false)
//    private ExpenseCategory expenseCategory;

    public Category(Long id, Operation operation, IncomeCategory incomeCategory, ExpenseCategory expenseCategory) {
        this.id = id;
//        this.operation = operation;
//        this.incomeCategory = incomeCategory;
//        this.expenseCategory = expenseCategory;
    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Operation getOperation() {
//        return operation;
//    }
//
//    public void setOperation(Operation operation) {
//        this.operation = operation;
//    }
//
//    public IncomeCategory getIncomeCategory() {
//        return incomeCategory;
//    }
//
//    public void setIncomeCategory(IncomeCategory incomeCategory) {
//        this.incomeCategory = incomeCategory;
//    }
//
//    public ExpenseCategory getExpenseCategory() {
//        return expenseCategory;
//    }
//
//    public void setExpenseCategory(ExpenseCategory expenseCategory) {
//        this.expenseCategory = expenseCategory;
//    }
}
