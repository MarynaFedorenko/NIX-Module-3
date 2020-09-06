package nix.jdbc.entity;


public class User {
    private Long id;
    private String name;
    private String phoneNumber;


    public User(Long id, String name, String phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User(){}


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
