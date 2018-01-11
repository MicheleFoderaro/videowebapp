package com.videowebapp.utility;

import com.videowebapp.dao.dto.FilmDTO;

import java.util.Comparator;

public class Comparators {

    public static class ComparatorTitle implements Comparator<FilmDTO> {
        @Override
        public int compare(FilmDTO o1, FilmDTO o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class ComparatorYear implements Comparator<FilmDTO> {
        @Override
        public int compare(FilmDTO o1, FilmDTO o2) {
            return Integer.compare(o1.getYear(), o2.getYear());
        }
    }
}
