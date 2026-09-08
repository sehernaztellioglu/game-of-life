package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Main {

    static JButton basilanButon = new JButton();

    static ArrayList<JButton> dogacakButonlar =
            new ArrayList<>();

    static ArrayList<JButton> kapatilacakButonlar =
            new ArrayList<>();

    static JButton startButon = new JButton("start");
    static int sayac = 0;

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JPanel startPaneli = new JPanel();
    static JPanel oyunPaneli = new JPanel();

    static JButton[][] butonlar =
            new JButton[20][20];

    static void dugmeOlusturma(int boyut) {

        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {

                butonlar[i][j] = new JButton();
                panel.add(butonlar[i][j]);
            }
        }
    }

    static void komsuOlme(int boyut) {

        kapatilacakButonlar.add(basilanButon);

        for (int i = 1; i < boyut - 1; i++) {
            for (int j = 1; j < boyut - 1; j++) {

                if (Color.RED.equals(
                        butonlar[i][j].getBackground())) {

                    if (Color.RED.equals(
                            butonlar[i - 1][j - 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i - 1][j]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i - 1][j + 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i][j - 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i][j + 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i + 1][j - 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i + 1][j]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i + 1][j + 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (sayac == 0
                            || sayac == 1
                            || sayac == 4
                            || sayac == 5
                            || sayac == 6
                            || sayac == 7
                            || sayac == 8) {

                        kapatilacakButonlar.add(
                                butonlar[i][j]);
                    }

                    sayac = 0;
                }
            }
        }
    }

    static void kareDogma(int boyut) {

        for (int i = 1; i < boyut - 1; i++) {
            for (int j = 1; j < boyut - 1; j++) {

                if (!butonlar[i][j].isOpaque()) {

                    if (Color.RED.equals(
                            butonlar[i - 1][j - 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i - 1][j]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i - 1][j + 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i][j - 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i][j + 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i + 1][j - 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i + 1][j]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (Color.RED.equals(
                            butonlar[i + 1][j + 1]
                                    .getBackground())) {
                        sayac++;
                    }

                    if (sayac == 3) {
                        dogacakButonlar.add(
                                butonlar[i][j]);
                    }

                    sayac = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        dugmeOlusturma(20);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                oyunPaneli.add(butonlar[i][j]);

                butonlar[i][j].addActionListener(e -> {

                    JButton basilanButon =
                            (JButton) e.getSource();

                    basilanButon.setOpaque(true);
                    basilanButon.setContentAreaFilled(true);
                    basilanButon.setBorderPainted(false);
                    basilanButon.setBackground(Color.RED);
                });
            }
        }

        startButon.addActionListener(e -> {

            komsuOlme(20);
            kareDogma(20);

            for (JButton buton : kapatilacakButonlar) {
                buton.setBackground(null);
                buton.setOpaque(false);
                buton.setContentAreaFilled(true);
                buton.setBorderPainted(true);
            }

            for (JButton buton : dogacakButonlar) {
                buton.setOpaque(true);
                buton.setContentAreaFilled(true);
                buton.setBorderPainted(false);
                buton.setBackground(Color.RED);
            }

            kapatilacakButonlar.clear();
            dogacakButonlar.clear();
        });

        startPaneli.add(startButon);

        panel.add(oyunPaneli);
        panel.add(startPaneli);

        panel.setLayout(new BorderLayout());
        oyunPaneli.setLayout(new GridLayout(20, 20));

        panel.add(oyunPaneli, BorderLayout.CENTER);
        panel.add(startPaneli, BorderLayout.SOUTH);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
    }
}