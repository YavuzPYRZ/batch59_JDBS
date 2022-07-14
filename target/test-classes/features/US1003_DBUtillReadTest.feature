Feature: US1003 Kullanici DB Utils ile istenen degeri test eder

  Scenario: TC03 Kullanıcı istenen degeri test edebilmeli

    Given kullanici DB Utils ile HMC veri tabanina baglanir
    And kullanici DB Utils ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DB Utils ile "Price" sutunundaki verileri okur
    Then DB Utils ile 2. "Price" in 4000 oldugunu test eder