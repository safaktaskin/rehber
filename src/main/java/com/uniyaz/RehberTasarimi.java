package com.uniyaz;

public class RehberTasarimi {

    public static void baslikYazdir() {
        System.out.println("*************** TELEFON REHBERİ **************");
    }

    public static void menuYazdir() {
        System.out.println("1. Rehbere Kayıt Ekle");
        System.out.println("2. Kişi Güncelle");
        System.out.println("3. Kişi Ara");
        System.out.println("4. Kişi Sil");
        System.out.println("5. Listele");
        System.out.println("6. Çıkış");
    }

    public static void ayracYazdir() {
        System.out.println("____________________________________________________________");
    }

    public static void listeleme(){
        System.out.println();
        System.out.println("********************** TÜM KAYITLAR  ******************");
        System.out.println("**** NO ******** AD ****** SOYAD ****** TELEFON *******");
    }

}
