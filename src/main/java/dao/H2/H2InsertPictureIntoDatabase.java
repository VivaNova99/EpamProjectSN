package dao.H2;

import lombok.SneakyThrows;
import model.User;

import javax.annotation.Resource;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;


public class H2InsertPictureIntoDatabase {

//    @Resource(name = "jdbc/TestDB")
//    private DataSource dataSource;

    private DataSource dataSource;

    public H2InsertPictureIntoDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    public H2InsertPictureIntoDatabase() {
//
//    }


    @SneakyThrows
    public void insertDefaultPictureIntoUserProfilePhoto() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE User set profile_photo = ? "
             )){


            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/default_large.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


    @SneakyThrows
    public void insertDefaultPictureIntoPhotoAlbumPhotoAlbumPicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE PhotoAlbum set photo_album_picture = ? "
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/no_image.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }

    @SneakyThrows
    public void insertPictureOneIntoPhotoAlbumPhotoAlbumPicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE PhotoAlbum set photo_album_picture = ? WHERE id = 1"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/1.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }

    @SneakyThrows
    public void insertPictureTwoIntoPhotoAlbumPhotoAlbumPicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE PhotoAlbum set photo_album_picture = ? WHERE id = 2"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/2.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }

    @SneakyThrows
    public void insertPictureThreeIntoPhotoAlbumPhotoAlbumPicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE PhotoAlbum set photo_album_picture = ? WHERE id = 3"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/3.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }

    @SneakyThrows
    public void insertPictureFourIntoPhotoAlbumPhotoAlbumPicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE PhotoAlbum set photo_album_picture = ? WHERE id = 4"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/4.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


    @SneakyThrows
    public void insertDefaultPictureIntoPhotoPicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Photo set picture = ? "
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/no_image.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


    @SneakyThrows
    public void insertQuestionPictureIntoWallMessagePicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE WallMessage set picture = ? WHERE id = 2 OR id = 5"
//                     "UPDATE WallMessage set picture = ? WHERE is_parent = TRUE"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/question.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


    @SneakyThrows
    public void insertAnswerPictureIntoWallMessagePicture() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE WallMessage set picture = ? WHERE id = 3 OR id = 6"
//                     "UPDATE WallMessage set picture = ? WHERE is_parent = FALSE"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/answer.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


}
