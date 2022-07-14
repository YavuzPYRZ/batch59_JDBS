Feature: US1003 Kullanici DB Utils ile istenen degeri test eder

  Scenario: TC03 Kullanıcı istenen degeri test edebilmeli

    Given kullanici DB Utils ile HMC veri tabanina baglanir
    And kullanici DB Utils ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DB Utils ile "Price" sutunundaki verileri okur
    And DBUtils ile tum "Price" degerlerini sira numarasi ile yazdirir
    Then DB Utils ile 4. "Price" in 425 oldugunu test eder