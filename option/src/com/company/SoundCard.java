package com.company;

import java.util.Optional;

public class SoundCard {
    private Optional<USB> usb;

    public SoundCard(Optional<USB> usb) {
        this.usb = usb;
    }

    public SoundCard() {
    }
}
