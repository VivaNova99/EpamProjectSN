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
