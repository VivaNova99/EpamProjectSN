package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumTheme {

    private int id;
//    id INT PRIMARY KEY,
    private int themeOrder;
//    themes_order INT,
    private String name;
//    name VARCHAR(50) NOT NULL
}
