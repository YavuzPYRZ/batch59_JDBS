package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.DBUtils;

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
    public void kullanici_db_utils_ile_sutunundaki_verileri_okur(String string) {

        throw new io.cucumber.java.PendingException();
    }

}
