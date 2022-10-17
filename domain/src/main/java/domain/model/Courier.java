package domain.model;

import lombok.Data;

//курьер
@Data
public class Courier {
    private int id;
    private String name;
    private int latitude;
    private int longitude;
}