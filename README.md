# Проект "Быстро и в точку" - job4j_fast_food

#### Технологии проекта
![badge](https://img.shields.io/badge/PostgreSQL-14-blue)
![badge](https://img.shields.io/badge/Java-17-green)
![badge](https://img.shields.io/badge/Kafka-2.8.9-red)
![badge](https://img.shields.io/badge/Maven-3.6-green)
![badge](https://img.shields.io/badge/SpringBot-2.7.4-yellow)

## Технические требования заказчика:

- иметь каталог блюд

- принимать заказы клиента на сайте, либо через скачанное клиентами приложение

- предоставлять клиенту курьерскую доставку, клиент может контролировать положение курьера

- предоставлять курьерам приложения, где они могут отчитываться о заказах, обновлять свое положение

- иметь админку в виде WEB приложения, где можно оформлять поставки продуктов, а также видеть прибыль

## Структура проекта, микро-сервисы

Приложение состоит из maven модулей. Каждый модуль - отдельное Spring boot приложение.

```
- /admin/ - админка
- /dish/ - сервис блюд
- /order/ - сервис заказов
- /delivery/ - сервис доставки
- /kitchen/ - сервис кухни
- /payment/ - сервис платежей
- /notification/ - сервис уведомлений
- /domains/ - доменные модели
```
## Архитектура:
![img.png](img/architecture.png)