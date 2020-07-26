package company;



import company.view.AccountView;
import company.view.DevelloperVIew;
import company.view.SkillView;

import java.io.*;

//Один турист разглядывал выставленных для продажи животных в зоомагазине
//        и увидел, как человек купил обезьяну за 5000 долларов. Он подошел к
//        продавцу и поинтересовался, почему эта обезьяна такая дорогая.
//        Продавец ответил:
//        - Она очень быстро программирует на С, не делая ошибок, и пишет
//        великолепный код.
//        Тогда турист стал внимательно разглядывать других обезьян в этой клетке
//        и заметил, что одна из них стоит 10000.
//        - За что же назначена цена в два раза больше? - спросил он.
//        Продавец сказал:
//        - Эта обезьяна программирует на С++, Java и других
//        объектно-ориентированных языках.
//        Оглядев магазин, турист увидет еще одну обезьяну в отдельной клетке
//        с табличкой $50000:
//        - О! А вон та стоит 50000! Это неслыханная цена, что же она умеет?
//        Продавец развел руками и сказал:
//        - Сам я точно не знаю, но другие обезьяны называют ее Project Manager.





// Когда я начинал это писать, только Бог и я понимали, что я делаю
// Сейчас остался только Бог
public class Main {

    public static void main(String[] args) {
      


        DevelloperVIew develloperVIew = new DevelloperVIew();
        SkillView skillView = new SkillView();
        AccountView accountView = new AccountView();

        System.out.println("Welcome to Developer manager V1.0");


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){

//Когда нибудь мне будет жутко стыдно за этот код , а пока я очень хочу спать )
            while (true) {
                System.out.println(" Choose your destiny"+System.lineSeparator()+"New developer pres 1"
                        +System.lineSeparator()+"loock all developers - press 2  "
                         +System.lineSeparator()+
                        "create developer pres 3" +System.lineSeparator());

                String read = reader.readLine();
                switch (read) {
                    case "1":
                        develloperVIew.addNewDevelloper();
                        break;
                    case "2":
                        develloperVIew.showAllDevellopers();
                        break;
                    case "3":
                        develloperVIew.createDeveloper();
                        break;
                    case "0":

                        System.exit(1);
                }


            }
        } catch (IOException e) {
            System.out.println("how could you break anything?");
        }



    }


}