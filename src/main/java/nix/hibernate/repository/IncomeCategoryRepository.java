package nix.hibernate.repository;

import nix.hibernate.entity.IncomeCategory;

public interface IncomeCategoryRepository {
    public void update(IncomeCategory incomeCategory);
    public void save(IncomeCategory incomeCategory);
    public IncomeCategory createIncomeCategory(String details);
}
