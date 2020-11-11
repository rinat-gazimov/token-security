package ru.springboot.app.utils;


public class DataConstants {

    public enum TokenStatus {
        ACTIVE(1L),
        EXPIRED(2L);

        private Long value;

        TokenStatus(Long value) {
            this.value = value;
        }

        public Long getValue() {
            return value;
        }
    }

}
