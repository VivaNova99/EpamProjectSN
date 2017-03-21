package dao.mySql;

import dao.ForumThemesDao;
import lombok.SneakyThrows;
import model.AccessLevel;
import model.ForumThemes;
import model.User;

import javax.annotation.Resource;
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
public class MySqlForumThemesDao implements ForumThemesDao {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;


    @Override
    public int save() {
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    @SneakyThrows
    public Collection<ForumThemes> getAll() {

        List<ForumThemes> forumThemes = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "id, " +
                     "themes_order, " +
                     "name FROM ForumThemes")) {
            while (resultSet.next()){
                forumThemes.add(new ForumThemes(
                        resultSet.getInt("id"),
                        resultSet.getInt("themes_order"),
                        resultSet.getString("name")
                ));
            }
            return forumThemes;
        }
    }
}
