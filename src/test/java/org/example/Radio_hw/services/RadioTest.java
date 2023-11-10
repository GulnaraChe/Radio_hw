package org.example.Radio_hw.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class RadioTest {


    @Test
    public void validateChangeFields() {
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);

        radio.setCurrentRadioStation(4);
        actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(4, actual);
    }


    // тестируем станции
    @Test
    public void changeOverLastRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);
        radio.pressNextStation();
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void changeUnderInitialRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.pressPrevStation();
        Assertions.assertEquals(9, radio.getCurrentRadioStation());

    }

    @Test
    public void nextRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(6);
        radio.pressNextStation();
        Assertions.assertEquals(7, radio.getCurrentRadioStation());
    }

    @Test
    public void prevRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(6);
        radio.pressPrevStation();
        Assertions.assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void OverInitialRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(11);
        int actual = radio.getMaxRadioStation();
        Assertions.assertEquals(9, actual);
    }

    @Test
    public void UnderInitialRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);
        int actual = radio.getMinRadioStation();
        Assertions.assertEquals(0, actual);
    }

    // тестируем громкость
    @Test
    public void volumeOverMax() {
        Radio radio = new Radio();
        int expected = radio.getMaxVolume();
        radio.setCurrentVolume(111);
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void volumeDownUnderMin() {
        Radio radio = new Radio();
        int expected = radio.getMinVolume();
        radio.setCurrentVolume(-11);
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void plusVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(4);
        radio.pressPlusVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(5, actual);
    }

    @Test
    public void minusVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(4);
        radio.pressMinusVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(3, actual);
    }
}