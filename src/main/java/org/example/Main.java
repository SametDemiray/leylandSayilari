package org.example;
/*
Leyland sayıları, iki pozitif tam sayının üslerinin toplamına eşit olan bir tamsayıdır. Yani, bir Leyland sayısı olan
x için, x =a^b + b^a eşitliğini sağlayan pozitif tamsayılar a ve b bulunur.

Leyland sayıları, adını matematikçi Paul Leyland'den alır ve teorik olarak sonsuz sayıda olması beklenir. Bu sayılar genellikle
matematiksel araştırmalarda ve bilgisayar bilimlerinde ilginç uygulamalara sahip olabilirler.
10 olarak girdiğimizde :
İstenen 10 adet Leyland sayısı:
8,17,32,54,57,100,145,177,320,368, çıkacaktır.
*/

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Kaç adet Leyland sayısı istiyorsunuz ? : ");
        int count = scanner.nextInt(); // Kullanıcıdan kaç adet Leyland sayısı istediğini alıyoruz

        int[] leylandNumbers = new int[count]; // Kullanıcının istediği sayıda Leyland sayısı için bir dizi oluşturuyoruz

        int limit = 2; // İlk Leyland sayısının bulunacağı sayı
        int found = 0; // Bulunan Leyland sayısı sayısı

        while (found < count) {
            if (isLeylandNumber(limit)) {
                leylandNumbers[found] = limit; // Leyland sayısını diziye ekliyoruz
                found++; // Bulunan sayı sayısını arttırıyoruz
            }
            limit++; // Bir sonraki sayıya geçiyoruz
        }

        Arrays.sort(leylandNumbers); // Leyland sayılarını sıralıyoruz

        System.out.println("İstenen " + count + " adet Leyland sayısı:");
        for (int number : leylandNumbers) {
            System.out.print(number + ","); // Leyland sayılarını ekrana yazdırıyoruz
        }

        scanner.close();
    }

    // Bir sayının m değerini döndüren fonksiyon
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // Bir sayının Leyland sayısı olup olmadığını kontrol eden fonksiyon
    public static boolean isLeylandNumber(int number) {
        for (int i = 2; i < number; i++) {
            for (int j = i; j < number; j++) {
                int leyland = power(i, j) + power(j, i);
                if (leyland == number) {
                    return true;
                }
                if (leyland > number) {
                    break;
                }
            }
        }
        return false;
    }
}
