package nix.hibernate.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "expenses")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


//    @OneToMany(mappedBy = "expenseCategory")
//    private List<Category> categories;

    @ManyToMany
    List<Operation> operations;

    @Column(nullable=false)
    private String details;

    public ExpenseCategory(Long id, List<Operation> operations, String details) {
        this.id = id;
        this.operations = operations;
        this.details = details;
    }

    public ExpenseCategory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
