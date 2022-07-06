Feature: US1002 kullanıcı DB Utils ile database baglantısı yapabilir
  @db
  Scenario: TC02 Kullanici DB Utils ile database'deki bilgileri okur

    Given kullanici DB Utils ile HMC veri tabanina baglanir
    And kullanici DB Utils ile "tHOTELROOM" tablosundaki "Price" verilerini alir

    # SELECT Price FROM tHOTELROOM
    And kullanici DB Utils ile "Price" sutunundaki verileri okur
