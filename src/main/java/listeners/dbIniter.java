package listeners;

import dao.H2.H2InsertPictureIntoDatabase;
import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@WebListener
public class dbIniter implements ServletContextListener {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void contextInitialized(ServletContextEvent sce) {
        Pattern pattern = Pattern.compile("^\\d+\\.sql$");
        Path sqlDirPath = Paths.get("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/resources/sql");
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            DirectoryStream<Path> paths = Files.newDirectoryStream(sqlDirPath);
            for (Path filePath: paths){
                if (pattern.matcher(filePath.toFile().getName()).find())
                    statement.addBatch(
                            Files.lines(filePath)
                                .collect(Collectors.joining())
                    );
            }
            statement.executeBatch();

            H2InsertPictureIntoDatabase h2InsertPicture = new H2InsertPictureIntoDatabase(dataSource);
            h2InsertPicture.insertDefaultPictureIntoUserProfilePhoto();
            h2InsertPicture.insertDefaultPictureIntoPhotoAlbumPhotoAlbumPicture();
            h2InsertPicture.insertDefaultPictureIntoPhotoPicture();
            h2InsertPicture.insertPictureOneIntoPhotoAlbumPhotoAlbumPicture();
            h2InsertPicture.insertPictureTwoIntoPhotoAlbumPhotoAlbumPicture();
            h2InsertPicture.insertPictureThreeIntoPhotoAlbumPhotoAlbumPicture();
            h2InsertPicture.insertPictureFourIntoPhotoAlbumPhotoAlbumPicture();
            h2InsertPicture.insertQuestionPictureIntoWallMessagePicture();
            h2InsertPicture.insertAnswerPictureIntoWallMessagePicture();

        }
    }
}
