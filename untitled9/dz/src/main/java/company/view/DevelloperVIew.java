package company.view;

import company.controller.AccountController;
import company.controller.DeveloperController;
import company.model.Account;
import company.model.Develloper;


import java.io.*;
import java.util.List;
import java.util.Optional;

public class DevelloperVIew {
    DeveloperController developerController = new DeveloperController();
    AccountController accountController = new AccountController();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




    public void addNewDevelloper()  {


        String name = "";
              String  lastName ="" ;
        while (!false) {
            System.out.println("Write name developer ");
            try {
                name = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error try again");
            }
            System.out.println("Write Last name developer ");
            try {
                lastName=reader.readLine();
            } catch (IOException e) {
                System.out.println("Error try again");
            }
            System.out.println(name+" "+lastName);
            if (!(name.length() <= 2)&&!(lastName.length() <= 2)) {
                developerController.addDeveloper(name,lastName);
                break;
            }
        }
    }

    public void showAllDevellopers() {

      //  developerController.getAllDev().forEach(System.out::println);
        List<Develloper> devellopersList ;
        devellopersList= developerController.getAllDev();
//
        for (Develloper dev:devellopersList) {
            Optional<Account> optional;
            optional=accountController.getAccount(dev.getId());
            if (optional.isPresent()) {
                dev.setAccount(optional.get());

            }
           System.out.println(dev);

        }

     //   System.out.println(devellopersList);
      //  developerController.getAllDev().forEach(x-> System.out.println(accountController.getAccount(x.getId())));

    //   System.out.println(developerController.getAllDev());

    }


    public void deleteDeveloper() throws IOException {
        showAllDevellopers();
        System.out.println("Please indicate the developer you want to delete");
        int idForDelete = Integer.parseInt(reader.readLine());
        if (idForDelete > developerController.getAllDev().size()) {
            System.out.println("There is no such developer");
        } else {
            developerController.deletDevelloper(idForDelete);
        }
    }

    public void createDeveloper() throws IOException {
        showAllDevellopers();
        System.out.println("Please indicate the developer you want to create");
        int idForCreate = Integer.parseInt(reader.readLine());
        if (idForCreate > developerController.getAllDev().size()) {
            System.out.println("There is no such developer");
        } else {
            System.out.println("write a new name");
            String newName = reader.readLine();
            System.out.println("write a new last name");
            String newLastName = reader.readLine();
            developerController.apdateDevelloper(idForCreate,newName,newLastName);
        }


    }

    public Develloper viewDeveloper() throws IOException {
        showAllDevellopers();
        System.out.println("Please indicate the developer ");
        int idForView = Integer.parseInt(reader.readLine());
        if (idForView > developerController.getAllDev().size()) {
            System.out.println("There is no such developer");
            return null;
        } else {
            return developerController.getDevelloper(idForView).get();

        }


    }
}
