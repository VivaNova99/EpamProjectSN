INSERT INTO AccessLevel(id, description) VALUES (1, 'ADMIN');
INSERT INTO AccessLevel(id, description) VALUES (2, 'MODERATOR');
INSERT INTO AccessLevel(id, description) VALUES (3, 'STANDARD_USER');
INSERT INTO AccessLevel(id, description) VALUES (4, 'DELETED_USER');


INSERT INTO PhotoStatus(id, description) VALUES (1, 'PRIVATE');
INSERT INTO PhotoStatus(id, description) VALUES (2, 'FOR_FRIENDS');
INSERT INTO PhotoStatus(id, description) VALUES (3, 'PUBLIC');


INSERT INTO MessageStatus (id, description) VALUES (1, 'UNREAD');
INSERT INTO MessageStatus (id, description) VALUES (2, 'STANDARD');
INSERT INTO MessageStatus (id, description) VALUES (3, 'DELETED');


INSERT INTO ForumTheme (theme_order, name)
VALUES (100, 'Про детей');
INSERT INTO ForumTheme (theme_order, name)
VALUES (200, 'Про взрослых');
INSERT INTO ForumTheme (theme_order, name)
VALUES (300, 'Прочее');

INSERT INTO ForumTheme (theme_order, name)
VALUES (105, 'Планируем беременность');
INSERT INTO ForumTheme (theme_order, name)
VALUES (110, ' Беременность и роды ');
INSERT INTO ForumTheme (theme_order, name)
VALUES (115, 'Детское здоровье');
INSERT INTO ForumTheme (theme_order, name)
VALUES (120, 'О малышах до года');
INSERT INTO ForumTheme (theme_order, name)
VALUES (125, 'Развивающие центры, кружки и занятия');
INSERT INTO ForumTheme (theme_order, name)
VALUES (130, 'Детские сады и ясли');
INSERT INTO ForumTheme (theme_order, name)
VALUES (135, 'От года до трех');
INSERT INTO ForumTheme (theme_order, name)
VALUES (140, 'От трех до шести');
INSERT INTO ForumTheme (theme_order, name)
VALUES (145, 'Младшие школьники');
INSERT INTO ForumTheme (theme_order, name)
VALUES (150, 'Подростки');
INSERT INTO ForumTheme (theme_order, name)
VALUES (155, 'В десять быть дома!');

INSERT INTO ForumTheme (theme_order, name)
VALUES (203, 'Ах, эта свадьба!');
INSERT INTO ForumTheme (theme_order, name)
VALUES (206, 'Наш дом');
INSERT INTO ForumTheme (theme_order, name)
VALUES (209, 'Все о недвижимости');
INSERT INTO ForumTheme (theme_order, name)
VALUES (212, 'Тратим деньги');
INSERT INTO ForumTheme (theme_order, name)
VALUES (215, 'Работа и образование');
INSERT INTO ForumTheme (theme_order, name)
VALUES (218, 'Бастен бак');
INSERT INTO ForumTheme (theme_order, name)
VALUES (221, 'Дачная тематика и загородная жизнь');
INSERT INTO ForumTheme (theme_order, name)
VALUES (224, 'Lege artis');
INSERT INTO ForumTheme (theme_order, name)
VALUES (227, 'Кулинария');
INSERT INTO ForumTheme (theme_order, name)
VALUES (230, 'Рукоделие');
INSERT INTO ForumTheme (theme_order, name)
VALUES (233, 'О домашних питомцах');
INSERT INTO ForumTheme (theme_order, name)
VALUES (236, 'Горшки и корешки');
INSERT INTO ForumTheme (theme_order, name)
VALUES (239, 'Досуг и отдых (клубы, рестораны, загородный отдых)');
INSERT INTO ForumTheme (theme_order, name)
VALUES (242, 'Hard and soft');
INSERT INTO ForumTheme (theme_order, name)
VALUES (245, 'Финляндия - столица Швеции (с)');
INSERT INTO ForumTheme (theme_order, name)
VALUES (248, 'Едем в отпуск');
INSERT INTO ForumTheme (theme_order, name)
VALUES (251, 'Я сам');
INSERT INTO ForumTheme (theme_order, name)
VALUES (254, 'Дом мод');
INSERT INTO ForumTheme (theme_order, name)
VALUES (257, 'Красота - страшная сила!');
INSERT INTO ForumTheme (theme_order, name)
VALUES (260, 'Наше здоровье');
INSERT INTO ForumTheme (theme_order, name)
VALUES (263, 'О спорт, ты - жизнь!');
INSERT INTO ForumTheme (theme_order, name)
VALUES (266, 'Похудательный форум');
INSERT INTO ForumTheme (theme_order, name)
VALUES (269, 'Женские грезы');
INSERT INTO ForumTheme (theme_order, name)
VALUES (272, 'Развлечения дома');
INSERT INTO ForumTheme (theme_order, name)
VALUES (275, 'Курилка');
INSERT INTO ForumTheme (theme_order, name)
VALUES (278, 'Обо всем остальном');

INSERT INTO ForumTheme (theme_order, name)
VALUES (310, 'Наш форум');
INSERT INTO ForumTheme (theme_order, name)
VALUES (320, 'Конкурсы');
INSERT INTO ForumTheme (theme_order, name)
VALUES (330, 'Опросник');


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



