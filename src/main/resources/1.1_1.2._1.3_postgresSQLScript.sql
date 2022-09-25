/*
 Напишите скрипт создания таблицы со следующими параметрами:
Название таблицы - PERSONS
содержит в себе 5 столбцов - name, surname, age, phone_number, city_of_living
первичным ключом будет сочетание name, surname, age
 */

CREATE SCHEMA netology

CREATE TABLE persons
(
    name           VARCHAR(128) NOT NUll,
    surname        VARCHAR(128) NOT NULL,
    age            INT CHECK ( age > 0 AND age < 150 ),
    phone_number   VARCHAR(50),
    city_of_living VARCHAR(128) NOT NULL,
    PRIMARY KEY (name, surname, age)
);

INSERT INTO persons(name, surname, age, phone_number, city_of_living)
VALUES ('Pert', 'Petrov', 37, '9384877', 'MOSCOW'),
       ('Ivan', 'Ivanov', 27, '3646466', 'SARATOV'),
       ('Pert', 'Sidorov', 18, '3464677', 'SOCHI'),
       ('Sergey', 'Alekseev', 39, '9384877', 'MOSCOW'),
       ('Fedor', 'Fedorov', 67, '6786545', 'KAZAN'),
       ('Stepan', 'Stepanov', 32, '3545788', 'VLADIVOSTOK'),
       ('Alex', 'Petrov', 84, '9384877', 'MOSCOW'),
       ('Pert', 'Ivanov', 23, '8664445', 'KRASNODAR'),
       ('Ivan', 'Petrov', 43, '6544567', 'SAINT-PETERSBURG'),
       ('Fedor', 'Petrov', 21, '6556785', 'MINSK'),
       ('Igor', 'Aleksandrov', 22, '9384877', 'MOSCOW');

/*
 Напишите скрипт, который будет искать в таблице
 PERSONS поля name и surname пользователей,
 которые проживают в MOSCOW.
 */

SELECT name,
       surname
FROM persons
WHERE city_of_living LIKE 'MOSCOW';
--WHERE city_of_living = 'MOSCOW';


/*
 Напишите скрипт, который будет искать в таблице
 PERSONS все поля, у которых поле age выше 27 лет.
 Отсортируем получаемые результаты по убыванию возраста.
 */

SELECT *
FROM persons
WHERE age > 27
ORDER BY age DESC;


--Удаление таблицы
-- DROP TABLE persons;