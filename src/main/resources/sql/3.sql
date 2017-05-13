
INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password,  status_on_wall, city)
    VALUES ('Иван', 'Петров', '1989-03-08', 3, 'ivan@mail.ru', 'qwerty',  'Совсем один', 'СПб');
INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password,  status_on_wall, city)
    VALUES ('Маша', 'Васильева', '1985-08-01', 2, 'maria@mail.ru', 'qwerty11',  'Очень занятой человек', 'город на Неве');
INSERT INTO User (first_name, last_name, date_of_birth, access_level_id, email, password,  status_on_wall, city)
    VALUES ('Катя', 'Смирнова', '1986-03-02', 3, 'katja@mail.ru', 'qwertyqwerty',  'Люблю все новое ))', 'Москва');


INSERT INTO AccessRoles (email, role_name)
    VALUES ('ivan@mail.ru', 'standard_user');
INSERT INTO AccessRoles (email, role_name)
    VALUES ('maria@mail.ru', 'moderator');
INSERT INTO AccessRoles (email, role_name)
    VALUES ('maria@mail.ru', 'standard_user');
INSERT INTO AccessRoles (email, role_name)
    VALUES ('katja@mail.ru', 'standard_user');


INSERT INTO PhotoAlbum (name, user_id, description, date_time, status_id)
    VALUES ('Альбом 1', 1, 'Описание альбома 1', '2017-03-21 00:00:00', 3);
INSERT INTO PhotoAlbum (name, user_id, description, date_time, status_id)
    VALUES ('Альбом 2', 2, 'Описание альбома 2', '2017-03-21 00:00:01', 3);
INSERT INTO PhotoAlbum (name, user_id, description, date_time, status_id)
    VALUES ('Альбом 3', 3, 'Описание альбома 3', '2017-04-17 00:00:01', 3);
INSERT INTO PhotoAlbum (name, user_id, description, date_time, status_id)
    VALUES ('Альбом 4', 1, 'Описание альбома 4', '2017-04-17 00:05:01', 3);


INSERT INTO Photo (user_id, photo_album_id, description, date_time, status_id)
    VALUES (1, 1, 'Описание фото 1 альбома 1', '2017-03-21 01:00:00', 3);
INSERT INTO Photo (user_id, photo_album_id, description, date_time, status_id)
    VALUES (2, 2, 'Описание фото 1 альбома 2', '2017-03-21 01:00:01', 2);
INSERT INTO Photo (user_id, photo_album_id, description, date_time, status_id)
    VALUES (2, 2, 'Описание фото 2 альбома 2', '2017-03-21 01:00:03', 3);
INSERT INTO Photo (user_id, photo_album_id, description, date_time, status_id)
    VALUES (1, 4, 'Описание фото 1 альбома 4', '2017-04-17 01:00:03', 3);
INSERT INTO Photo (user_id, photo_album_id, description, date_time, status_id)
    VALUES (3, 3, 'Описание фото 1 альбома 3', '2017-04-17 05:00:03', 3);


INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (1, 2, 'Маша, привет!', '2017-03-23 20:00:00', 2);
INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (2, 1, 'Привет, привет!))', '2017-03-23 20:05:00', 1);
INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (2, 3, 'Добро пожаловать!', '2017-04-17 20:05:00', 1);
INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (3, 2, 'Спасибо ))', '2017-04-17 21:05:00', 1);
INSERT INTO PrivateMessage (sender_user_id, receiver_user_id, text, date_time, status_id)
    VALUES (3, 1, 'Здесь пока мало народу, да?', '2017-04-17 22:05:00', 1);



INSERT INTO WallMessage (sender_user_id, text, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (2, 'Запись для того, чтобы на нее ссылаться', '2017-03-24 01:00:02', 3, NULL, TRUE, 1, 2);
/*может быть, поставить null в parent_message_id, тогда запись будет, но не будет выводиться?*/
INSERT INTO WallMessage (sender_user_id, text, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (2, 'Моя первая запись', '2017-03-24 01:01:02', 3, 'Первая тема', TRUE , 1, 2);
INSERT INTO WallMessage (sender_user_id, text, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (1, 'Просто ответ', '2017-03-24 01:05:02', 3, NULL, FALSE, 2, 2);
INSERT INTO WallMessage (sender_user_id, text, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (1, 'Как вставить фото? Не понимаю', '2017-04-15 01:05:02', 41, 'Как вставить фото?', TRUE, 1, 2);
INSERT INTO WallMessage (sender_user_id, text, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (3, 'Собственно, сабж', '2017-04-17 01:05:02', 41, 'Как стать модератором?', TRUE, 1, 2);
INSERT INTO WallMessage (sender_user_id, text, date_time, forum_theme_id, message_header, is_parent, parent_message_id, status_id)
    VALUES (2, 'А обычная загрузка не работает?', '2017-04-17 02:05:02', 41, 'Как вставить фото?', FALSE, 4, 2);


