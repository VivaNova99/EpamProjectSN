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
    1,
    'ivan@mail.ru',
    'qwerty',
    'ссылка на фото профиля Ивана Петрова',
    'Совсем один',
    'СПб')