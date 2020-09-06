package nix.hibernate.repository;

import nix.hibernate.entity.ExpenseCategory;

public interface ExpenseCategoryRepository {
    void update(ExpenseCategory expenseCategory);
    void save(ExpenseCategory expenseCategory);
    ExpenseCategory createExpenseCategory(String details);
}
