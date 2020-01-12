package ru.springboot.app.utils;

import java.util.UUID;

public class DataConstants {

    public enum TokenStatus {
        ACTIVE(UUID.fromString("4bf45086-e93e-4c43-adfa-2a3dda9bc146")),
        EXPIRED(UUID.fromString("4bf45086-e93e-4c43-adfa-2a3dda9bc147"));

        private UUID value;

        TokenStatus(UUID value) {
            this.value = value;
        }

        public UUID getValue() {
            return value;
        }
    }

}
