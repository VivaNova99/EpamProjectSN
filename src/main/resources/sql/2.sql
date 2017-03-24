INSERT INTO AccessLevel(id, description) VALUES (1, 'ADMIN');
INSERT INTO AccessLevel(id, description) VALUES (2, 'MODERATOR');
INSERT INTO AccessLevel(id, description) VALUES (3, 'STANDARD_USER');
INSERT INTO AccessLevel(id, description) VALUES (4, 'DELETED_USER');


INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password, profile_photo, status_on_wall, city)
    VALUES ('Иван', 'Петров', '1989-03-08', 3, 'ivan@mail.ru', 'qwerty', 'ссылка на фото профиля Ивана Петрова', 'Совсем один', 'СПб');
INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password, profile_photo, status_on_wall, city)
VALUES ('Маша', 'Васильева', '1985-08-01', 2, 'maria@mail.ru', 'qwerty11', 'ссылка на фото профиля Маши Васильевой', 'Очень занятой человек', 'город на Неве');



INSERT INTO ForumTheme (id, theme_order, name)
    VALUES (1, 10, 'Про детей');
INSERT INTO ForumTheme (id, theme_order, name)
    VALUES (2, 20, 'Про взрослых');
INSERT INTO ForumTheme (id, theme_order, name)
    VALUES (3, 30, 'Прочее');


INSERT INTO PhotoStatus(id, description) VALUES (1, 'PRIVATE');
INSERT INTO PhotoStatus(id, description) VALUES (2, 'FOR_FRIENDS');
INSERT INTO PhotoStatus(id, description) VALUES (3, 'PUBLIC');


INSERT INTO PhotoAlbum (name, user_id, photo_album_picture, description, date_time, status_id)
    VALUES ('Альбом 1', 1, 'Ссылка на фото альбома 1', 'Описание альбома 1', '2017-03-21 00:00:00', 3);
INSERT INTO PhotoAlbum (name, user_id, photo_album_picture, description, date_time, status_id)
    VALUES ('Альбом 2', 2, 'Ссылка на фото альбома 2', 'Описание альбома 2', '2017-03-21 00:00:01', 3);


INSERT INTO Photo (user_id, photo_album_id, picture, description, date_time, status_id)
    VALUES (1, 1, 'Ссылка на фото 1 альбома 1', 'Описание фото 1 альбома 1', '2017-03-21 01:00:00', 3);
INSERT INTO Photo (user_id, photo_album_id, picture, description, date_time, status_id)
    VALUES (2, 2, 'Ссылка на фото 1 альбома 2', 'Описание фото 1 альбома 2', '2017-03-21 01:00:01', 2);
INSERT INTO Photo (user_id, photo_album_id, picture, description, date_time, status_id)
    VALUES (2, 2, 'Ссылка на фото 2 альбома 2', 'Описание фото 2 альбома 2', '2017-03-21 01:00:03', 3);


INSERT INTO MessageStatus (id, description) VALUES (1, 'UNREAD');
INSERT INTO MessageStatus (id, description) VALUES (2, 'STANDARD');
INSERT INTO MessageStatus (id, description) VALUES (3, 'DELETED');


INSERT INTO PrivateMessage (sender_user_id, reciever_user_id, text, date_time, status_id)
    VALUES (1, 2, 'Маша, привет!', '2017-03-23 20:00:00', 2);
INSERT INTO PrivateMessage (sender_user_id, reciever_user_id, text, date_time, status_id)
    VALUES (2, 1, 'Привет, привет!))', '2017-03-23 20:05:00', 1);


INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, is_parent, parent_message_id, status_id)
    VALUES (2, 'Запись для того, чтобы на нее ссылаться', NULL , '2017-03-24 01:00:02', 3, TRUE, 1, 2);
/*может быть, поставить null в parent_message_id, тогда запись будет, но не будет выводиться?*/
INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, is_parent, parent_message_id, status_id)
    VALUES (2, 'Моя первая запись', 'Ссылка на фото 2 альбома 2', '2017-03-24 01:01:02', 3, TRUE , 1, 2);
INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, is_parent, parent_message_id, status_id)
    VALUES (1, 'Просто ответ', NULL , '2017-03-24 01:05:02', 3, FALSE, 2, 2);

