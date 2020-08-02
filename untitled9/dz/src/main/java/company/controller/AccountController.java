package company.controller;

import company.model.Account;
import company.model.AccountStatus;
import company.repo.repoImpl.AccountRepositoryImpl;



import java.util.List;
import java.util.Optional;

public class AccountController {



    private AccountRepositoryImpl accountRepository =new AccountRepositoryImpl() ;

    public List<Account> getAllAccount() {
        return accountRepository.getAll();
    }

    public Account addAccount(Account account) {

        return accountRepository.create(account);
    }

    public void deletAccount(long id) {
        accountRepository.delete(id);
    }

    public Account apdateAccount(AccountStatus accountStatus  , long id) {
        return  accountRepository.update(new Account(accountStatus,id));
    }

    public Optional<Account> getAccount(long id ) {
        return accountRepository.read(id);
    }
}
