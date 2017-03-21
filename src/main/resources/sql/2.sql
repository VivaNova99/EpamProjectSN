INSERT INTO AccessLevel(id, description) VALUES (1, 'ADMIN');
INSERT INTO AccessLevel(id, description) VALUES (2, 'MODERATOR');
INSERT INTO AccessLevel(id, description) VALUES (3, 'STANDART_USER');
INSERT INTO AccessLevel(id, description) VALUES (4, 'DELETED_USER');


INSERT INTO User (
  first_name,
  last_name,
  date_of_birth,
  access_level_id,
  email,
  password,
  profile_photo,
  status_on_wall,
  city)

  VALUES (
    'Иван',
    'Петров',
    1989-03-08,
    3,
    'ivan@mail.ru',
    'qwerty',
    'ссылка на фото профиля Ивана Петрова',
    'Совсем один',
    'СПб');


INSERT INTO ForumThemes (id, themes_order, name) VALUES (1, 10, 'Про детей');
INSERT INTO ForumThemes (id, themes_order, name) VALUES (2, 20, 'Про взрослых');
INSERT INTO ForumThemes (id, themes_order, name) VALUES (3, 30, 'Прочее');


INSERT INTO PhotoAlbum (name, user_id, photo_album_picture, description, date_time, status_id)
    VALUES ('Альбом 1', 1, 'Ссылка на фото альбома 1', 'Описание альбома 1', '2017-03-21 00:00:00', 3);
INSERT INTO PhotoAlbum (name, user_id, photo_album_picture, description, date_time, status_id)
    VALUES ('Альбом 2', 1, 'Ссылка на фото альбома 2', 'Описание альбома 2', '2017-03-21 00:00:01', 3);


INSERT INTO Photo (user_id, photo_album_id, picture, description, date_time, status_id)
    VALUES (1, 1, 'Ссылка на фото 1 альбома 1', 'Описание фото 1 альбома 1', '2017-03-21 01:00:00', 3);
INSERT INTO Photo (user_id, photo_album_id, picture, description, date_time, status_id)
    VALUES (1, 2, 'Ссылка на фото 1 альбома 2', 'Описание фото 1 альбома 2', '2017-03-21 01:00:01', 3);
INSERT INTO Photo (user_id, photo_album_id, picture, description, date_time, status_id)
    VALUES (1, 2, 'Ссылка на фото 2 альбома 2', 'Описание фото 2 альбома 2', '2017-03-21 01:00:03', 3);

