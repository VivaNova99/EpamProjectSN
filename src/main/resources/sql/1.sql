 CREATE TABLE PhotoStatus (
   id INT PRIMARY KEY,
   description VARCHAR(20) NOT NULL
 );

 CREATE TABLE MessageStatus (
   id INT PRIMARY KEY,
   description VARCHAR(20) NOT NULL
 );

 CREATE TABLE AccessLevel (
   id INT PRIMARY KEY,
   description VARCHAR(20) NOT NULL
 );

 CREATE TABLE ForumTheme (
   id INT PRIMARY KEY,
   theme_order INT,
   name VARCHAR(50) NOT NULL
 );

 CREATE TABLE User (
   id INT AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   date_of_birth DATE NOT NULL,
   access_level_id int NOT NULL,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(255) NOT NULL,
   profile_photo VARCHAR(100) NOT NULL,
   status_on_wall VARCHAR(100),
   city VARCHAR(50),

   FOREIGN KEY (access_level_id) REFERENCES AccessLevel(id),
   UNIQUE (email)
 );

 CREATE TABLE PrivateMessage (
   id INT AUTO_INCREMENT PRIMARY KEY,
   sender_user_id int NOT NULL,
   reciever_user_id int NOT NULL,
   text VARCHAR(160) NOT NULL,
   date_time DATETIME NOT NULL,
   status_id INT,

   FOREIGN KEY (sender_user_id) REFERENCES User(id),
   FOREIGN KEY (reciever_user_id) REFERENCES User(id),
   FOREIGN KEY (status_id) REFERENCES MessageStatus(id)
 );

 CREATE TABLE WallMessage (
   id INT AUTO_INCREMENT PRIMARY KEY,
   sender_user_id int NOT NULL,
   text VARCHAR(500) NOT NULL,
   picture VARCHAR(100),
   date_time DATETIME NOT NULL,
   forum_theme_id INT,
   parent_message_id INT,
   status_id VARCHAR(50),

   FOREIGN KEY (parent_message_id) REFERENCES WallMessage(id),
   FOREIGN KEY (status_id) REFERENCES MessageStatus(id),
   FOREIGN KEY (sender_user_id) REFERENCES User(id),
   FOREIGN KEY (forum_theme_id) REFERENCES ForumTheme(id)
 );

 CREATE TABLE PhotoAlbum (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   user_id INT NOT NULL,
   photo_album_picture VARCHAR(100) NOT NULL,
   description VARCHAR(100),
   date_time DATETIME NOT NULL,
   status_id INT,

   FOREIGN KEY (user_id) REFERENCES User(id),
   FOREIGN KEY (status_id) REFERENCES PhotoStatus(id)
 );

 CREATE TABLE Photo (
   id INT AUTO_INCREMENT PRIMARY KEY,
   user_id INT NOT NULL,
   photo_album_id INT,
   picture VARCHAR(100) NOT NULL,
   description VARCHAR(100),
   date_time DATETIME NOT NULL,
   status_id INT,

   FOREIGN KEY (user_id) REFERENCES User(id),
   FOREIGN KEY (photo_album_id) REFERENCES PhotoAlbum(id),
   FOREIGN KEY (status_id) REFERENCES PhotoStatus(id)
 );









