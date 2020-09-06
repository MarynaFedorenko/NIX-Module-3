package nix.hibernate.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(name="phoneNumber", unique=true, nullable=false)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;


    public User(Long id, String name, String phoneNumber, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.accounts = accounts;
    }

    public User() { }

    public Long getId() {
        return id;    }

    public void setId(Long id) {
        this.id = id;    }

    public String getName() {
        return name;    }

    public void setName(String name) {
        this.name = name;    }

    public String getPhoneNumber() {
        return phoneNumber;    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;    }

    public List<Account> getAccounts() {
        return accounts;    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;    }


}
