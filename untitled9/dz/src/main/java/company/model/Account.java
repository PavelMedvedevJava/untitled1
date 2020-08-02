package company.model;

import java.io.Serializable;

public class Account  implements Serializable {



    private long id;

 private   AccountStatus accountStatus;

    public Account(AccountStatus accountStatus, long id) {

        this.accountStatus = accountStatus;
        this.id=id;
    }

    public long getDevId() {
        return id;
    }

    public void setDevId(long devId) {
        this.id = devId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account(AccountStatus accountStatus) {

        this.accountStatus = accountStatus;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
