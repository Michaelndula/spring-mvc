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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Continents getContinents() {
        return continents;
    }

    public void setContinents(Continents continents) {
        this.continents = continents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(boolean allInclusive) {
        this.allInclusive = allInclusive;
    }
}
