package com.videowebapp.model;

import java.util.ArrayList;
import java.util.List;


public class Database {

    private static List<Film> list;

    public static List<Film> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }
}
