package com.landmarkdataservice.entity;

public enum Type {
    ARCHAEOLOGICAL_OBJECT,
    MUSEUMS,
    PALACES,
    PARKS,
    RESERVES;


    public static boolean contains(String test) {

        for (Type c : Type.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }

}
