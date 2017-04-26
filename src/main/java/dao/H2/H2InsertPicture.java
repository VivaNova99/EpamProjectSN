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
public class H2InsertPicture {

    private DataSource dataSource;

    public H2InsertPicture(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @SneakyThrows
    public void insertDefaultPictureIntoUserProfilePhoto() {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE User set profile_photo = ? "
             )){


            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/default_large.png");
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

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/no_image.png");
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

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/no_image.png");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)file.length());

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


}
