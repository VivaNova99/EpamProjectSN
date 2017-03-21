package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumThemes {

    private int id;
//    id INT PRIMARY KEY,
    private int themesOrder;
//    themes_order INT,
    private String name;
//    name VARCHAR(50) NOT NULL
}
