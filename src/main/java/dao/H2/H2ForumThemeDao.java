package dao.H2;

import dao.ForumThemeDao;
import lombok.SneakyThrows;
import model.ForumTheme;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by veraivanova on 17.03.17.
 */
public class H2ForumThemeDao implements ForumThemeDao {


    private DataSource dataSource;

    public H2ForumThemeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public int save() {
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    @SneakyThrows
    public Collection<ForumTheme> getAll() {

        List<ForumTheme> forumThemes = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "id, " +
                     "theme_order, " +
                     "name FROM ForumTheme")) {
            while (resultSet.next()){
                forumThemes.add(new ForumTheme(
                        resultSet.getInt("id"),
                        resultSet.getInt("theme_order"),
                        resultSet.getString("name")
                ));
            }
            return forumThemes;
        }
    }
}
