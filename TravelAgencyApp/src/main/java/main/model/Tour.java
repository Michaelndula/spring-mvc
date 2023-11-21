package main.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Tour {
    private enum Continents{
        Africa, Asia, Europe, North_America, South_America;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "{Invalid.name}")
    @Size(min = 5, message = "{Invalid.name}")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{Invalid.code}")
    private String code;
    private Continents continent;
    @NotNull(message = "{Invalid.date}")
    @Future(message = "{Invalid.date}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Min(value = 7, message = "{Invalid.durationRang}")
    @Max(value = 21, message = "{Invalid.durationRang}")
    private int duration;
    @Column(name = "all_inclusive")
    private boolean allInclusive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
