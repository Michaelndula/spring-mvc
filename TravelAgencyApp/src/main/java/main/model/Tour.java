package main.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Tour {
    private enum Continents{
        Africa, Asia, Europe, North_America, South_America;
    }
    private String name;
    private String code;
    private Continents continents;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private int duration;
    private boolean allInclusive;


}
