package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumTheme {

    private int id;
    private int themeOrder;
    private String name;

    public ForumTheme(String name) {
        this.name = name;
    }
}
