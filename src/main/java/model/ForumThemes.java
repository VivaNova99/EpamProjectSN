package model;

import lombok.Value;

@Value
public class ForumThemes {

    private int id;
//    id INT PRIMARY KEY,
    private int themes_order;
//    themes_order INT,
    private String name;
//    name VARCHAR(50) NOT NULL
}
