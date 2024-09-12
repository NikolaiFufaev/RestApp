# RestApp

Для запуска нужно настроить подключение к бд включить докер и запустить файл docker-compose

- Добавить достопримечательность
- POST http://localhost:8080/app/landmark
Content-Type: application/json

{
"name": "Name",
"shortDescription": "Description",
"type": "PARKS",
"localityId": 1,
"favors": []
}


- Получить все достопримечательности (передать параметр для сортировки по наименованию достопримечательности, параметр для фильтрации по типу достопримечательности)
- GET http://localhost:8080/app/landmark/all?type=PARKS

- Получить все достопримечательности конкретного населенного пункта
- GET http://localhost:8080/app/landmark/locality/{{localityId}}

- Изменение данных по достопримечательности (возможно изменение только поля Краткое описание)
- PATCH http://localhost:8080/app/landmark/1?shortDescription=NewDiscription

- Удаление достопримечательности из справочника
- DELETE http://localhost:8080/app/landmark/1

- Добавить город
- POST http://localhost:8080/app/locality
  Content-Type: application/json

{
"name": "new locality",
"population": 10,
"metro": false
}

- Изменение данных по городу (возможно изменение только полей: Численность населения, наличие метро)
- PATCH http://localhost:8080/app/locality/2?population=500&metro=false