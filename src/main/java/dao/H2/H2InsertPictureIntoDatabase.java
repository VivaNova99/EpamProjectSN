package dao.H2;

import lombok.SneakyThrows;
import model.User;

import javax.imageio.stream.ImageInputStreamImpl;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

/**
 * Created by veraivanova on 25.04.17.
 */
public class H2InsertPictureIntoDatabase {

    private DataSource dataSource;

    public H2InsertPictureIntoDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }


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


}
