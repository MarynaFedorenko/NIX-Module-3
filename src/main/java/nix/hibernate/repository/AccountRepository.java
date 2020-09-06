package nix.hibernate.repository;

import nix.hibernate.entity.Account;

public interface AccountRepository {
    void update(Account account);
    Account findAccountById(Long id);
    void updateCurrency(Long id, Long currency);
}
