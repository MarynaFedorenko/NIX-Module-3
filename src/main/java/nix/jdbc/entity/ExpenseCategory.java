package nix.jdbc.entity;

public class ExpenseCategory {
    private Long id;
    private String details;


    public ExpenseCategory(Long id, String details){
        this.id = id;
        this.details = details;
    }

    public ExpenseCategory(){}

    public Long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }
}
