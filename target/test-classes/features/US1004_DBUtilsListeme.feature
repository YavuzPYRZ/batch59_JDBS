Feature: US1004 Kullanici istenen tablodaki istenen fiald'i listeleyebilir

  Scenario: TC04 Kullanıcı field listesi yazdırabilmeli

    Given kullanici DB Utils ile HMC veri tabanina baglanir
    And kullanici DB Utils ile "tHOTEL" tablosundaki "Email" verilerini alir
    And kullanici DB Utils ile "Email" sutunundaki verileri okur
    And DBUtils ile tum "Email" degerlerini sira numarasi ile yazdirir
