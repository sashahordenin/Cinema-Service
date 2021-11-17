# Cinema-Service

## Table of contents

* [General info](#general-info)
* [Features](#features)
* [Technologies](#technologies)
* [Installation](#installation)

<a id="general-info"></a>
## General info

Cinema service App is a web-app, built based on SOLID
principles using Hibernate, Spring frameworks.

<a id="features"></a>
## Features:

- Support registration(POST:/register), authentication(/login), authorization and logout(/logout) processes
- Get all cinema halls (GET: /cinema-halls) or add cinema hall (POST: /cinema-halls)
- Get all movies (GET: /movies) or add movie (POST: /movies)
- Get all available movie sessions (/movie-sessions/available?movieId&date), add(/movie-sessions), delete or update movie session by id (/movie-sessions/{id})
- Add movie session to shopping cart (PUT: /shopping-carts/movie-sessions?movieSessionId) and get shopping cart by user (GET: /shopping-carts/by-user)
- Complete order (POST: /orders/complete) and get orders history for user (GET: /orders)
- Get user by email (GET: /users/by-email?email)

You can send POST requests from <a href="https://web.postman.co/home">Postman</a>

<a id="technologies"></a>
## Technologies:

- Java (JDK version 11)
- MySQL database
- Tomcat - web-server (version 9.0.54)
- Hibernate
- Spring (Spring Core, Spring Security, Spring Web)
- JSON
- Maven (version 3.6.3)

<a id="installation"></a>
## Installation:

1. Install MySQL or other RDBMS (you need to create schema)
2. Install Tomcat (version 9.0.54)
3. Fork this project to your repository and clone to your IDE
4. Open db.properties file by path src/main/resources. Here you can configure your JDBC connection and hibernate by editing next fields:
```sh
#MySQL properties
db.driver=YOUR_DRIVER
db.url=YOUR_DATABASE_URL
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD

#Hibernate properties
hibernate.show_sql=true
hibernate.hbm2ddl.auto=create
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect (change this property if don't use MySQL)
```
5. By default, in pom.xml file is already exist dependencies for mySQL connector (change this dependency if don't use MySQL)
6. Add configuration of your installed TomCat's local server to the IDE
7. Run you project. You must be redirected to login page. Here you can go to register page or use default users to login:
- ROLE_ADMIN (username: admin@i.ua; password: admin123)
- ROLE_USER (username: user@i.ua; password: user1234)
8. If authentication was successful you will be redirected to http://localhost:8080/, where you have access to all described features of cinema service App.
