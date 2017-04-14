
INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password, profile_photo, status_on_wall, city)
VALUES ('Иван', 'Петров', '1989-03-08', 3, 'ivan@mail.ru', 'qwerty', 'ссылка на фото профиля Ивана Петрова', 'Совсем один', 'СПб');
INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password, profile_photo, status_on_wall, city)
VALUES ('Маша', 'Васильева', '1985-08-01', 2, 'maria@mail.ru', 'qwerty11', 'ссылка на фото профиля Маши Васильевой', 'Очень занятой человек', 'город на Неве');


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


INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (1, 2, 'Маша, привет!', '2017-03-23 20:00:00', 2);
INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (2, 1, 'Привет, привет!))', '2017-03-23 20:05:00', 1);


INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (2, 'Запись для того, чтобы на нее ссылаться', NULL , '2017-03-24 01:00:02', 3, NULL, TRUE, 1, 2);
/*может быть, поставить null в parent_message_id, тогда запись будет, но не будет выводиться?*/
INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (2, 'Моя первая запись', 'Ссылка на фото 2 альбома 2', '2017-03-24 01:01:02', 3, 'Первая тема', TRUE , 1, 2);
INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (1, 'Просто ответ', NULL , '2017-03-24 01:05:02', 3, NULL, FALSE, 2, 2);
INSERT INTO WallMessage (sender_user_id, text, picture, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (1, 'Как вставить фото? Не понимаю', NULL , '2017-04-15 01:05:02', 41, 'Как вставить фото?', TRUE, 1, 2);


