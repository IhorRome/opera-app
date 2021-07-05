# Opera app
This project is an application for selling tickets to the opera, where, as an administrator, you can add a variety of performances, scenes, create sessions to show performances, or, as a user, order tickets for existing sessions.
## Launch
- Clone this project to your IDE
- Create database using MySQL Workbrench
- in <i><b>src/main/resources/db.properties</b></i> file configure connection to your database:<br>
<i>MySQL properties:</i><br>
db.driver=com.mysql.cj.jdbc.Driver<br>
db.url=jdbc:mysql://localhost:3306/<b>your_db_name</b>?serverTimezone=UTC<br>
db.user=<b>MySQL username</b><br>
db.password=<b>MySQL password</b><br>
<i>Hibernate properties:</i><br>
hibernate.show_sql=true<br>
hibernate.hbm2ddl.auto=create (or "validate" if you have already launched this project and created sql tables earlier)<br>
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect<br>
- Configure Local Tomcat server<br>
- In browser enter this URL: http://localhost:8080/inject to add user roles (USER, ADMIN) and one user with role ADMIN (login: admin@i.ua, password: admin123)
- Using Postman now you may send such http requests:<br>

 <b>all users</b> (not authenticated, with admin role, with user role):<br>
    - POST /register<br>
 <b>admin</b> only (do not forget Basic Authentication with login and password from previous stage):<br>
    - POST: /cinema-halls<br>
    - POST: /movies<br>
    - POST: /movie-sessions<br>
    - PUT: /movie-sessions/{id}<br>
    - DELETE: /movie-sessions/{id}<br>
    - GET: /users/by-email<br>
  <b>user</b> only (make sure you have already registered at least one new user and entered correct login/password in Authentication window in Postman):<br>
    - GET: /orders<br>
    - POST: /orders/complete<br>
    - POST: /shopping-carts/movie-sessions<br>
    - GET: /shopping-carts/by-user<br>
  <b>authenticated</b> (user or admin role):<br>
    - GET: /cinema-halls<br>
    - GET: /movies<br>
    - GET: /movie-sessions/available<br>
    - GET: /movie-sessions/{id}<br>
  <b><i>Hint:</b></i> Dont be scared to send POST methods with empty body: Global Exception Handler will inform you which fields you have to fill
