package nix.jdbc.entity;

import java.time.Instant;

public class Operation {

    private Long id;
    private Long accountId;
    private Instant date;
    private Long amount;
    private Long currency;
    private String type;


    public Operation(Long id, Long accountId, Instant date, Long amount, Long currency, String type){
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.type = type;

    }
    public Operation(){}

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Instant getDate() {
        return date;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }
}
