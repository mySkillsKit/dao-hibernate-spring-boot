# Задача DAO слой c Hibernate

1. Create docker container postgres:
``` docker run --name postgres -d -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres:14```
2. create schema in possgres sql:
```create schema if not exists netology;```

## Описание
Попрактикуемся в работе с Hibernate через Spring, попутно закрепляя уже пройденные темы. Вам надо написать приложение для работы с БД, используя средства Spring по конфигурации и работе с Hibernate, адаптировав таблицы из задания [Таблица пользователей](../../sql-basic/task/README.md)

1. Создайте spring boot приложение, с зависимостями на два starter'а - `spring-boot-starter-data-jpa` и `spring-boot-starter-web`

2. Создайте Entity, которая соответствует таблице из условий задачи [Таблица пользователей](../../sql-basic/task/README.md).

3. Напишите репозиторий для работы с БД. Для этого:
- создайте класс и пометьте его аннотацией Repository, либо создайте бин репозитория в Java config классе
- правильно инжектируйте EntityManager
- создайте метод `getPersonsByCity(String city)`, который будет принимать название города и возвращать ваше Entity из базы данных, которые соответствуют этому `city`. Сделать это можно, например, получив всех пользователей и отфильтровав их по городу.

4. Напишите контроллер, с методом-обработчиком GET-метода запроса с маппингом на endpoint `/persons/by-city`. В query params запроса будет приходить строковый параметр `city`, который вам надо будет передавать дальше в репозиторий. То есть, ваш метод должен уметь обрабатывать запрос вида `localhost:8080/persons/by-city?city=Moscow`.
   Контроллер должен будет возвращать всех людей, который он получит от репозитория.

5. Написанные код выложите в отдельный репозиторий на гитхабе и прикрепите ссылку на него в домашнем задании.