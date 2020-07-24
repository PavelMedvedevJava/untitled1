package company.view;

import company.controller.AccountController;
import company.model.AccountStatus;
import company.model.Develloper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AccountView {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    AccountController accountController = new AccountController();

    public void addAccount(Develloper develloper) throws IOException {
        while (true) {
            System.out.println("Write account status 1:Active ; 2:Banned ; 3:Delete");
            String read = reader.readLine();

            switch (read) {
                case "1":
                    accountController.addAccount(AccountStatus.ACTIVE,develloper.getId());
                    break;
                case "2":
                    accountController.addAccount(AccountStatus.BANNED,develloper.getId());
                    break;
                case "3":
                    accountController.addAccount(AccountStatus.DELETED,develloper.getId());
                    break;
            }
            break;
        }
    }

    public void createAccount(Develloper develloper){
        while (true) {
            System.out.println("Write account status 1:Active ; 2:Banned ; 3:Delete");
            String read = null;
            try {
                read = reader.readLine();
            } catch (IOException e) {
                System.out.println("Tray again ");
            }
            long idDev;
            switch (read) {

                case "1":
                    idDev= accountController.getAccount(develloper.getId()).get().getDevId();
                    accountController.apdateAccount(AccountStatus.ACTIVE,develloper.getId(),idDev);

                    break;
                case "2":
                    idDev= accountController.getAccount(develloper.getId()).get().getDevId();
                    accountController.apdateAccount(AccountStatus.BANNED,develloper.getId(),idDev);
                    break;
                case "3":
                    idDev= accountController.getAccount(develloper.getId()).get().getDevId();
                    accountController.apdateAccount(AccountStatus.DELETED,develloper.getId(),idDev);
                    break;
            }
            break;
        }


    }
}
