package dao.H2;

import lombok.SneakyThrows;

import java.io.*;
import java.sql.ResultSet;

public class H2SavePictureFromDatabase {

    // В этом классе собраны методы для сохранения изображений из базы данных во временные файлы.
    // Сейчас класс не используется, так как реализован вывод изображений непосредственно из базы данных

    public int generateRandom6DigitNumber(){
        int randomNumber;
        int minNumber = 100000;
        int maxNumber = 999999;

        maxNumber -= minNumber;
        randomNumber = (int)(Math.random() * ++maxNumber) + minNumber;

        return randomNumber;
    }

    
    public String getPathToUserProfilePhotoFile() {
        String pathToPictureFile = "/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/temp/user_profile_photo" + generateRandom6DigitNumber() + ".jpg";
        return pathToPictureFile;
    }

    @SneakyThrows
    public void saveUserProfilePhotoFromDatabaseIntoFile(ResultSet resultSet) {
        String pathname = getPathToUserProfilePhotoFile();

        File image = new File(pathname);
        FileOutputStream fileOutputStream = new FileOutputStream(image);

        byte[] buffer = new byte[1];
        InputStream inputStream = resultSet.getBinaryStream(8);
        if (inputStream != null) {
            while (inputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }

        }
        fileOutputStream.close();
    }

    public String getPathToPictureFile() {
        String pathToPictureFile = "/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/temp/picture" + generateRandom6DigitNumber() + ".jpg";
        return pathToPictureFile;
    }

    @SneakyThrows
    public String savePhotoAlbumPictureFromDatabaseIntoFile(ResultSet resultSet) {
        String pathname = getPathToPictureFile();

        File image = new File(pathname);
        image.setReadable(true);

//        if(!image.exists()){
//            image.createNewFile();
//        }

        FileOutputStream fileOutputStream = new FileOutputStream(image);

        byte[] buffer = new byte[1];
        InputStream inputStream = resultSet.getBinaryStream(7);
        if (inputStream != null) {
            while (inputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }

        }
        fileOutputStream.close();

        try(FileInputStream fileInputStream = new FileInputStream(pathname)) {
//            pathname = pathname + fileInputStream.available();
            System.out.println("file size - " + fileInputStream.available());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }


        int startIndex = pathname.indexOf("/img/");
        pathname = pathname.substring(startIndex, pathname.length());
//        pathname = "\"" + pathname + "\"";
        return pathname;
    }

    @SneakyThrows
    public void savePhotoFromDatabaseIntoFile(ResultSet resultSet) {
        String pathname = getPathToPictureFile();

        File image = new File(pathname);
        FileOutputStream fileOutputStream = new FileOutputStream(image);

        byte[] buffer = new byte[1];
        InputStream inputStream = resultSet.getBinaryStream(7);
        if (inputStream != null) {
            while (inputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }

        }
        fileOutputStream.close();
    }

}
