package company.repo.repoImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import company.model.Account;
import company.repo.AccountRepository;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    private long idcounter = 1;

    private final String fileName = "account.json";

    private Path filePath = Paths.get("account.json");

    private List<Account> accountList = new ArrayList<>();


    public Account create(Account account) {
        if (Files.exists(filePath)) {

            try {
                if (Files.size(filePath) > 5) {
                    idcounter = getAll().stream().max(Comparator.comparing(i -> i.getId())).get().getId() + 1;
                    account.setId(idcounter);
                    accountList.add(account);
                } else {
                    account.setId(idcounter);
                    idcounter++;
                    accountList.add(account);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            account.setId(idcounter);
            idcounter++;
            accountList.add(account);

        }



        try (Writer writer = new FileWriter(String.valueOf(Paths.get(fileName)))) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accountList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return account;

    }

    public Account update(Account account) {

        delete(account.getId());
        create(account);


        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accountList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }




    public void delete(Long id) {
        accountList.removeIf(e -> e.getId() == id);

        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accountList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
@Override
    public List<Account> getAll() {


        if (!Files.exists(Paths.get(fileName))) {
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            Reader reader = new FileReader(fileName);

            Gson gson1 = new GsonBuilder().create();
            accountList = gson1.fromJson(reader, new TypeToken<ArrayList<Account>>() {
            }.getType());
            return accountList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
@Override
    public Optional<Account> read (Long id) {

        return getAll().stream().filter(x -> x.getDevId() == id).findFirst();
    }

}
