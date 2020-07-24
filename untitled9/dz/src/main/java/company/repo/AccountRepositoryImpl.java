package company.repo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import company.model.Account;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    private List<Account> accountList = new ArrayList<>();
    Path accountFiles;

    public void create(Account account) {
        System.out.println(account);

        if (getAll() != null) {
            accountList = getAll();
        }

        accountList = new ArrayList<>();
        accountList.add(account);

        try (Writer writer = new FileWriter(String.valueOf(Paths.get("account.json")))) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accountList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update(Account account) {

        delete(account.getId());
        create(account);


        try (Writer writer = new FileWriter("account.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accountList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void delete(Long id) {
        accountList.removeIf(e -> e.getId() == id);

        try (Writer writer = new FileWriter("account.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(accountList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
@Override
    public List<Account> getAll() {


        if (!Files.exists(Paths.get("account.json"))) {
            try {
                Files.createFile(Paths.get("account.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            Reader reader = new FileReader("account.json");

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


        // System.out.println(getAllAccount());
        return getAll().stream().filter(x -> x.getDevId() == id).findFirst();
    }

}
