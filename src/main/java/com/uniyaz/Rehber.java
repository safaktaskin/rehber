package com.uniyaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Rehber {
    static Scanner klavyedenGirilenDeger = new Scanner(System.in);
    static ArrayList<Kisi> rehber = new ArrayList<Kisi>();

    public static void main(String[] args) {
        boolean cikis = false;
        byte secim = -1;
        while (!cikis) {
            RehberTasarimi.baslikYazdir();
            RehberTasarimi.menuYazdir();
            secim = klavyedenGirilenDeger.nextByte();
            switch (secim) {
                case 1:
                    rehbereYeniKayitEkle();
                    break;
                case 2:
                    kisiGuncelle();
                    break;
                case 3:
                    rehberdenKisiArama();
                    break;
                case 4:
                    kisiSil();
                    break;
                case 5:
                    rehberiListele(rehber);
                    break;
                default:
                    break;
            }
        }
    }

    private static void rehberiListele(ArrayList<Kisi> rehber) {
        Iterator<Kisi> kisiIterator = rehber.listIterator();
        int sayac = -1;
        boolean rehbereEklenenleriGoster = true;
        if (rehber.size() > 0) {
            while (kisiIterator.hasNext()) {
                sayac++;
                Kisi kisi = kisiIterator.next();

                if (rehbereEklenenleriGoster) {
                    RehberTasarimi.listeleme();
                    RehberTasarimi.ayracYazdir();
                    rehbereEklenenleriGoster = false;
                }
                System.out.println(sayac + kisi.getAd() + kisi.getSoyad() + kisi.getNumara());
            }
            System.out.println(rehber.size());

        } else {
            System.out.println("Kayıt Bulunamadı");
        }
    }

    private static void kisiSil() {
        Scanner scanner = new Scanner(System.in);
        rehberiListele(rehber);
        System.out.println("No giriniz");
        byte secim = scanner.nextByte();
        for (Kisi kisi : rehber) {
            rehber.remove(secim);
        }
        rehberiListele(rehber);
    }

    private static void kisiGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen güncellemek istediğiniz kaydın sıra numarasını giriniz: ");
        int indexNo = scanner.nextByte();
        Kisi kisi = rehber.get(indexNo);

        System.out.println("----------  KAYIT GÜNCELLEME ------------");
        System.out.println("Lütfen Yeni İsim Bilgisi Girin");
        kisi.setAd(scanner.next());
        System.out.println("Lütfen Yeni Soyad Bilgisi Girin");
        kisi.setSoyad(scanner.next());
        System.out.println("Lütfen Yeni Numara Bilgisi Girin");
        kisi.setNumara(scanner.next());
        rehberiListele(rehber);
    }

    private static void rehberdenKisiArama() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aranacak Kelimeyi Söyleyin");
        String arancakKelime = scanner.next();
        Iterator<Kisi> kisiIterator = rehber.listIterator();
        ArrayList<Kisi> sonuclar = new ArrayList<Kisi>();
        while (kisiIterator.hasNext()) {

            Kisi kisi = kisiIterator.next();
            if (kisi.getAd().contains(arancakKelime)) {
                sonuclar.add(kisi);
            }
        }
        rehberiListele(sonuclar);
    }

    private static void rehbereYeniKayitEkle() {

        Kisi kisi = new Kisi();
        Scanner scan = new Scanner(System.in);
        System.out.println("Yeni Kişinin Adı: ");
        kisi.setAd(scan.nextLine());
        System.out.println("Yeni Kişinin Soyadı: ");
        kisi.setSoyad(scan.nextLine());
        System.out.println("Yeni Kişinin Telefonu: ");
        kisi.setNumara(scan.nextLine());
        if (rehber.add(kisi)) {
            System.out.println("Kayıt Eklendi.");
        }
    }
}