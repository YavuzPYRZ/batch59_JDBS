package stepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

public class HMC_db_Stepdefinitions {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";
    Connection connection; // ne işe yarar? Database'e bağlanmamızı sağlar.
    Statement statement; //  Query çalıştımamızı saglar.
    ResultSet resultSet; // Query sonunda donen sonucu store etmemize yarar

    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {

        connection = DriverManager.getConnection(url,username,password);
        statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field ) throws SQLException {
        String query = "SELECT "+field+" FROM "+table;
        resultSet = statement.executeQuery(query);

    }
    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String string) throws SQLException {

        // resultSet iteratior gibi çalışır
        resultSet.first(); // birinciye gitti
        System.out.println(resultSet.getString("price")); // 225 // birincidedi stringi yazdırır
        // next() imleci bir sonraki degerin yanına gorturur.
        // bize ttue yada folse doner.
        resultSet.next(); // bir ileri daha gitti
        System.out.println(resultSet.getString("price")); // 445 degeri getirdi ve yadırdık.
        System.out.println(resultSet.next()); // bize true yada false yadırır // true

        System.out.println(resultSet.getString("Price")); // 445
        // next() methodu kullanırken cok dikkatli olmalıyız.
        // cunku neerede olursak olsun imleci bir sonrakıne goturur.

        System.out.println("================LİSTE================");
        resultSet.absolute(0); // bunu koymazdak oncki kaldıgı yerden itibaren yazar.
        while (resultSet.next()){
            System.out.println(resultSet.getString("Price")); // eger sadece boyle yaparsak  imlecin
            // oldugu yerden itibaren yazdırır aman dikkat.

            // tabloda kaç satır oldugunu nasıl buluruz.

            resultSet.last(); // son a gider.
            System.out.println(resultSet.getRow()); // hangi satırda oldugumuzu doner.
        }


    }


}
