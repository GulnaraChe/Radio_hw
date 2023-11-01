package org.example.Radio_hw.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void validateChangeFields() {
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
        radio.setCurrentRadioStation(4);
        Assertions.assertEquals(4, radio.getCurrentRadioStation());
    }

    // тестируем станции
    @Test
    public void changeOverLastRadioStation() {
        radio.setCurrentRadioStation(9);
        radio.pressNextStation();
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void changeUnderInitialRadioStation() {
        radio.setCurrentRadioStation(0);
        radio.pressPrevStation();
        Assertions.assertEquals(9, radio.getCurrentRadioStation());

    }

    @Test
    public void nextRadioStation() {
        radio.setCurrentRadioStation(6);
        radio.pressNextStation();
        Assertions.assertEquals(7, radio.getCurrentRadioStation());
    }

    @Test
    public void prevRadioStation() {
        radio.setCurrentRadioStation(6);
        radio.pressPrevStation();
        Assertions.assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void OverInitialRadioStation() {
        radio.setCurrentRadioStation(11);
        radio.getMaxRadioStation();
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void UnderInitialRadioStation() {
        radio.setCurrentRadioStation(-1);
        radio.getMinRadioStation();
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    // тестируем громкость
    @Test
    public void volumeOverMax() {
        radio.setCurrentVolume(11);
        radio.getMaxVolume();
        Assertions.assertEquals(10, radio.getMaxVolume());
    }

    @Test
    public void volumeDownUnderMin() {
        radio.setCurrentVolume(-11);
        radio.getMinVolume();
        Assertions.assertEquals(0, radio.getMinVolume());

    }

    @Test
    public void plusVolume() {
        radio.setCurrentVolume(4);
        radio.pressPlusVolume();
        Assertions.assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void minusVolume() {
        radio.setCurrentVolume(4);
        radio.pressMinusVolume();
        Assertions.assertEquals(3, radio.getCurrentVolume());
    }
}