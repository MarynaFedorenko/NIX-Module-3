package nix.jdbc.entity;

public class IncomeCategory {
    private Long id;
    private String details;


    public IncomeCategory(Long id, String details){
        this.id = id;
        this.details = details;
    }

    public IncomeCategory(){}

    public Long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }
}
