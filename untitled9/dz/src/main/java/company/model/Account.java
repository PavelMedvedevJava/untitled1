package company.model;

import java.io.Serializable;

public class Account  implements Serializable {

    private long devId;

    private long id;

 private   AccountStatus accountStatus;

    public Account(AccountStatus accountStatus, long devId, long id) {
        this.devId=devId;
        this.accountStatus = accountStatus;
        this.id=id;
    }

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account(AccountStatus accountStatus,long devId) {
        this.devId=devId;
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
        return
                " accountStatus=" + accountStatus
               ;
    }
}
