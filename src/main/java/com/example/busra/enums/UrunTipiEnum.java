package com.example.busra.enums;

import java.util.UUID;

public enum UrunTipiEnum {
    ELEKTRONIK(UUID.fromString("c36a92e9-1bc0-4a8a-a4f3-f17e2f174c97")),

    KOZMETIK(UUID.fromString("0c0d1ccf-09e4-4100-99d1-9173124b511d"));

    public final UUID id;

    UrunTipiEnum(UUID id) {
        this.id = id;
    }
}
