package company.repo;

import company.model.Account;

import java.util.Collection;
import java.util.Optional;

public interface AccountRepository extends GenericRepository<Account,Long> {
    @Override
    void create(Account account);

    @Override
    void update(Account account);

    @Override
    Optional<Account> read(Long aLong);

    @Override
    Collection<Account> getAll();

    @Override
    void delete(Long aLong);
}
