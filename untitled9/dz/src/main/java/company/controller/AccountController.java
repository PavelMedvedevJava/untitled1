package company.controller;

import company.model.Account;
import company.model.AccountStatus;
import company.repo.AccountRepositoryImpl;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountController {


    private long idcounter=1;

    private AccountRepositoryImpl accountRepository =new AccountRepositoryImpl() ;

    public List<Account> getAllAccount() {
        return accountRepository.getAll();
    }

    public void addAccount(AccountStatus accountStatus  , long devId) {

        if (getAllAccount() != null) {
            idcounter = getAllAccount().stream().max(Comparator.comparing(i -> i.getId())).get().getId() + 1;
        }

        accountRepository.create(new Account(accountStatus,devId,idcounter));
        idcounter++;
    }

    public void deletAccount(long id) {
        accountRepository.delete(id);
    }

    public void apdateAccount(AccountStatus accountStatus  , long devId,long id) {
        accountRepository.update(new Account(accountStatus,devId,id));
    }

    public Optional<Account> getAccount(long id ) {
        return accountRepository.read(id);
    }
}
