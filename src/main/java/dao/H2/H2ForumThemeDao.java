package dao.H2;

import dao.ForumThemeDao;
import lombok.SneakyThrows;
import model.ForumTheme;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    @Override
    @SneakyThrows
    public Collection<ForumTheme> getAllForumThemeNames() {

        List<ForumTheme> forumThemes = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT name FROM ForumTheme")) {
            while (resultSet.next()){
                forumThemes.add(new ForumTheme(
                        resultSet.getString("name")
                ));
            }
            return forumThemes;
        }
    }


    @Override
    @SneakyThrows
    public int getForumThemeId(String forumThemeName) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "id FROM ForumTheme WHERE name = ?")){

            preparedStatement.setString(1, forumThemeName);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            int forumThemeId = resultSet.getInt("id");

            return forumThemeId;
        }
    }


}
