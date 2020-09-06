package nix.hibernate.repository;

import nix.hibernate.entity.Account;
import nix.hibernate.entity.Operation;

import java.time.Instant;

public interface OperationRepository {
     void save(Operation operation);
     Operation createOperation(Account account, Long amount);
}
