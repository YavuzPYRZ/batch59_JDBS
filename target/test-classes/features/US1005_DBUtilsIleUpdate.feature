Feature: US1005 Kullanıcı dataqbasede updete yapar

  Scenario: TC05 Kullanıcı update yapabilmeli

    Given kullanici DB Utils ile HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1016 olan kaydin Email bilgisini "geridenGelenlerElKaldirsin.com" yapar
        # UPDATE tHOTEL SET Email = 'sizOldunuzMu@gmail.com' where IDHotel=1016;