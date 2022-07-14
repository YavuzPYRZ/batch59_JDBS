package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_stepdefinitons {

    @Given("kullanici DB Utils ile HMC veri tabanina baglanir")
    public void kullanici_db_utils_ile_hmc_veri_tabanina_baglanir() {

        DBUtils.getConnection();
    }
    @Given("kullanici DB Utils ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_utils_ile_tablosundaki_verilerini_alir(String table, String field) {

        String query = "SELECT "+field+" FROM "+table;
        DBUtils.executeQuery(query);
    }
    @Given("kullanici DB Utils ile {string} sutunundaki verileri okur")
    public void kullanici_db_utils_ile_sutunundaki_verileri_okur(String field) throws SQLException {
        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(field)); // 1. yi bize yazdırması lazım


    }

    @And("DBUtils ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilsIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {
        // 1. derste while loop ile yapmıştık.
        // şimdi for loop ile yapalım.

        DBUtils.getResultset().last();
        int sonSatirNo = DBUtils.getResultset().getRow();
        DBUtils.getResultset().first();

        for (int i = 1; i <sonSatirNo ; i++) {
            System.out.println(i+". kayit " +DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }


    }

    @Then("DB Utils ile {int}. {string} in {int} oldugunu test eder")
    public void dbUtilsIleInOldugunuTestEder(int istenenSiraNo, String field, int expectedDeger) throws SQLException {
        DBUtils.getResultset().absolute(istenenSiraNo);
        double actualDeger = DBUtils.getResultset().getDouble(field);
        System.out.println("excepted Deger : " + expectedDeger);
        System.out.println("actual Deger : " + actualDeger);
        Assert.assertTrue(actualDeger==expectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {

        String updateQuery="UPDATE tHOTEL SET Email = '"+yeniEmail+"' WHERE IDHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);


    }
}
