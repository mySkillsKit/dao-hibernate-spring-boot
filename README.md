## Решение
1. Create docker container postgres:
   ` docker run --name postgres -d -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres:14`
2. Список людей из города Moscow / GET request
   `http://localhost:8080/persons/by-city?city=Moscow`
3. Список людей возраст меньше 23 и отсортированы по возрастанию / GET request
   `http://localhost:8080/persons/age-less-than?age=23`
4. Список людей у которых name = Pert и surname = Sidorov /GET request
   `http://localhost:8080/persons/by-name-and-surname?name=Pert&surname=Sidorov`
5. Получить персону с id = 8 / GET request
   `http://localhost:8080/persons/8`
6. Удалить персону с id = 8 / GET request
   `http://localhost:8080/persons/delete/8`
7. Создать новую персону / POST request
`http://localhost:8080/persons/create`
```
{
"name": "Anatolii",
"surname": "Vasilev",
"age": 37,
"phoneNumber": "9397272",
"city": "Novgorod"
}
```

```
curl --location --request POST 'http://localhost:8080/persons/create' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Anatolii",
"surname": "Vasilev",
"age": 37,
"phoneNumber": "9397272",
"city": "Novgorod"
}'
```
8. Обновить персону с id = 3 / PUT request
`http://localhost:8080/persons/update/3`

```
{
"name": "PertTest",
"surname": "SidorovTest",
"age": 25,
"phoneNumber": "111111",
"city": "SochiTest"
}

```

```
curl --location --request PUT 'http://localhost:8080/persons/update/3' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "PertTest",
"surname": "SidorovTest",
"age": 25,
"phoneNumber": "111111",
"city": "SochiTest"
}'
```
# Задача DAO слой c Hibernate


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



# Задача DAO слой c JPA Repositories

## Описание
Попрактикуемся в работе с JPA Repositories, переписав приложение для работы с БД [DAO слой c Hibernate](../../hibernate/task1/README.md)

1. Перепишите репозиторий для работы с БД на основе методов-запросов, чтобы:
- у вашего репозитория были основные методы для `CRUD` операций
- создайте метод, который будет принимать название города(`city`) и возвращать `Entity` из базы данных, которые соответствуют этому `city`.
- создайте метод, который будет принимать возраст(`age`) и возвращать `Entity` из базы данных, которые меньше переданного `age` и отсортированы по возрастанию.
- создайте метод, который будет принимать имя и фамилию(`name` и `surname`) и возвращать `Entity` из базы данных, которые соответствуют сочетанию `name` и `surname` и является `Optional`.

2. Допишите недостающие методы контроллера, в соответствии с появившимися новыми методами в репозитории.

3. Написанные код выложите в тот же репозиторий, что и задача [DAO слой c Hibernate](../../hibernate/task1/README.md) на гитхабe, только создайте под нее другую ветку `jpa-repository` и прикрепите ссылку на нее в домашнем задании.