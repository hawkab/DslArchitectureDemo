# DSL Architecture Demo
### Представление о чистой архитектуре с использованием DSL

---
Данное приложение демонстрирует пример как можно реализовать чистую архитектуру в связке с вычислительным ядром на базе DSL (Domain-Specific Language), 
используются читаемые, поддерживаемые решения.
Приложение разделено на два модуля:
 * core
>Это место, где лежит чистый бизнес — сущности и правила, которые определяют, как работает система. Оно универсально и может быть использовано в любом окружении.
 * service 
>Использует Spring фреймворк, реализует бизнес-логику, описанную в `core` при помощи заданных в нём правил и исполняет действия, которые ядро предписывает выполнить

Модули структурируются по принципу разделения ответственности и направленности зависимости. Главная цель — добиться независимости от фреймворков

При запуске приложение загружает правила из файла rules в формате YAML, формирует из них функции проверки и указания которые будут исполнены после 
обработки. Хранение правил в файле удобно: аналитики могут редактировать правила без изменения кода. При желании можно реализовать загрузку правил из БД.
---
# Шаги реализации:
* Аналитик описывает правила в YAML-файле, например, для проверки входных данных.
* При запуске приложения правила загружаются и преобразуются в объекты.
* Эти объекты интерпретируются на основе вашего DSL.
* Контроллер получает запросы, передаёт их в сервис, где правила применяются к данным.
---
# Тестирование
#1 Пример POST-запроса:
```http request
POST http://localhost:8080/rules/apply
Content-Type: application/json

{
  "customerType": "VIP",
  "orderAmount": 2500
}
```
Примет ответа #1:
```json
[
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 2125.0,
        "discount": 15,
        "customerType": "VIP",
        "orderAmount": 2500
      }
    },
    "ruleName": "VIP Discount Rule"
  },
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 2250.0,
        "discount": 10,
        "customerType": "VIP",
        "orderAmount": 2500
      }
    },
    "ruleName": "Regular Discount Rule"
  }
]
```
---
#2 Пример POST-запроса:
```http request
POST http://localhost:8080/rules/apply
Content-Type: application/json

{
  "customerType": "VIP",
  "orderAmount": 1500
}
```
Примет ответа #2:
```json
[
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 1275.0,
        "orderAmount": 1500,
        "customerType": "VIP",
        "discount": 15
      }
    },
    "ruleName": "VIP Discount Rule"
  }
]
```
---
#3 Пример POST-запроса:
```http request
POST http://localhost:8080/rules/apply
Content-Type: application/json

{
  "customerType": "Regular",
  "orderAmount": 2500
}
```
Примет ответа #3:
```json
[
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 2250.0,
        "discount": 10,
        "customerType": "Regular",
        "orderAmount": 2500
      }
    },
    "ruleName": "Regular Discount Rule"
  }
]
```
