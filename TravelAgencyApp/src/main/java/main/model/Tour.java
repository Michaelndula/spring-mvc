package main.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Tour {
    private enum Continents{
        Africa, Asia, Europe, North_America, South_America;
    }
    @NotBlank(message = "Name cannot be null")
    @Size(min = 5, message = "name should have at least 5 characters")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "Expected format is CC-DDC where C is character and D is digit")
    private String code;
    private Continents continent;
    @NotNull(message = "Date cannot be null")
    @Future(message = "Date should be from the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Min(value = 7, message = "Must be between 7 and 21")
    @Max(value = 21, message = "Must be between 7 and 21")
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

    public Continents getContinent() {
        return continent;
    }

    public void setContinent(Continents continent) {
        this.continent = continent;
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
