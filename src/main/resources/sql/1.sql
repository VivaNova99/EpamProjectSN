 CREATE TABLE PhotoStatus (
   id INT PRIMARY KEY,
   description VARCHAR(20) NOT NULL
 );

 CREATE TABLE MessagesStatus (
   id INT PRIMARY KEY,
   description VARCHAR(20) NOT NULL
 );

 CREATE TABLE AccessLevel (
   id INT PRIMARY KEY,
   description VARCHAR(20) NOT NULL
 );

 CREATE TABLE ForumThemes (
   id INT PRIMARY KEY,
   order INT,
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
   status VARCHAR(100),
   city VARCHAR(50),

   FOREIGN KEY (access_level_id) REFERENCES AccessLevel(id),
   UNIQUE (email)
 );

 CREATE TABLE PrivateMessages (
   id INT AUTO_INCREMENT PRIMARY KEY,
   sender_user_id int NOT NULL,
   reciever_user_id int NOT NULL,
   text VARCHAR(160) NOT NULL,
   date_time DATETIME NOT NULL,
   status INT,

   FOREIGN KEY (sender_user_id) REFERENCES User(id),
   FOREIGN KEY (reciever_user_id) REFERENCES User(id),
   FOREIGN KEY (status) REFERENCES MessagesStatus(id)
 );

 CREATE TABLE WallMessages (
   id INT AUTO_INCREMENT PRIMARY KEY,
   sender_user_id int NOT NULL,
   reciever_user_id int NOT NULL,
   text VARCHAR(500) NOT NULL,
   picture VARCHAR(100) NOT NULL,
   date_time DATETIME NOT NULL,
   forum_themes_id INT,
   parent_message_id INT,
   status INT,

   FOREIGN KEY (parent_message_id) REFERENCES WallMessages(id),
   FOREIGN KEY (status) REFERENCES MessagesStatus(id)
 );

 CREATE TABLE PhotoAlbum (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL,
   user_id INT NOT NULL,
   album_picture VARCHAR(100) NOT NULL,
   description VARCHAR(100),
   date_time DATETIME NOT NULL,
   status INT,

   FOREIGN KEY (user_id) REFERENCES User(id),
   FOREIGN KEY (status) REFERENCES PhotoStatus(id)
 );

 CREATE TABLE Photo (
   id INT AUTO_INCREMENT PRIMARY KEY,
   user_id INT NOT NULL,
   album_id INT,
   picture VARCHAR(100) NOT NULL,
   description VARCHAR(100),
   date_time DATETIME NOT NULL,
   status INT,

   FOREIGN KEY (user_id) REFERENCES User(id),
   FOREIGN KEY (album_id) REFERENCES PhotoAlbum(id),
   FOREIGN KEY (status) REFERENCES PhotoStatus(id)
 )







