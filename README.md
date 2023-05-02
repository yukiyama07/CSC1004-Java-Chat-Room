# CSC1004-Java-Chat-Room

<h3> To-Do </h3>
<ul>
  <li><strike>Multi-Client Chat (20%)</strike></li>
  <li><strike>Login System (20%)</strike></li>
  <li><strike>Java GUI (20%)</strike></li>
  <li><strike>Registration system (5%)</strike></li>
  <li><strike>Message History (5%)</strike></li>
    <li><strike>Web Application SpringBoot (15%)</strike></li>
</ul>


### Description

Welcome to UChat, a simple chatting tool on the website. It implements some simple feature like adding friends and chatting with a single user in WeChat and QQ. You can also chat with all the online users by clicking the smile button on the UChat main page. The front-end interface is completed by HTML, CSS, and JavaScript, and the back-end is managed by Java SpringBoot. The project may still have some technical and logical issues. I would very much like to receive your response to this project. Don't hesitate to let me know your suggestions and comments. Now let's enjoy chatting on UChat and have fun.

<h3> Features </h3>
<ul>
  <li>Login and Register</li>
  <li>Chat with online users</li>
  <li>Add friends in the stranger list</li>
  <li>Chat with a single friend in the friends list</li>
</ul>


### How I build it

#### Server (Back-end)

<ul>
  <li>Chat with each user: Java SpringBoot WebSocket</li>
  <li>Database: MySQL</li>
  <li>Manage the project: Maven</li>
  <li>IDE: IntelliJ IDEA</li>
</ul>


#### Client (Front-end)

<ul>
  <li>The foundation of UChat web page: HTML</li>
  <li>Style the visual appearance of HTML elements on the web page: CSS</li>
  <li>Programming language used to create dynamic and interactive web pages: JavaScript</li>
</ul>


### How to run it

You need to install MySQL and create a database named db_uchat and import the db_uchat.sql. Then you need to install UChat_Web-0.0.1-SNAPSHOT.jar in any folder and open the `command` in this folder. You need to enter the following command : 

`java -jar UChat_Web-0.0.1-SNAPSHOT.jar`

If you see the similar command line as follows, that means you run it successfully.

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.10)

2023-04-24 01:33:24.443  INFO 9920 --- [           main] cn.com.UChat.UChatWebApplication         : Starting UChatWebApplication v0.0.1-SNAPSHOT using Java 17.0.4.1 on Yokoshima with PID 9920 (D:\Java\UChat_Web\target\UChat_Web-0.0.1-SNAPSHOT.jar started by 17793 in D:\Java\UChat_Web\target)
2023-04-24 01:33:24.446  INFO 9920 --- [           main] cn.com.UChat.UChatWebApplication         : No active profile set, falling back to 1 default profile: "default"
2023-04-24 01:33:25.026  INFO 9920 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2023-04-24 01:33:25.093  INFO 9920 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 55 ms. Found 4 JPA repository interfaces.
2023-04-24 01:33:25.744  INFO 9920 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8888 (http)
2023-04-24 01:33:25.757  INFO 9920 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-04-24 01:33:25.757  INFO 9920 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.73]
2023-04-24 01:33:25.849  INFO 9920 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-04-24 01:33:25.849  INFO 9920 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1359 ms
2023-04-24 01:33:26.152  INFO 9920 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2023-04-24 01:33:26.227  INFO 9920 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.15.Final
2023-04-24 01:33:26.445  INFO 9920 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2023-04-24 01:33:26.587  INFO 9920 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-04-24 01:33:26.973  INFO 9920 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-04-24 01:33:27.017  INFO 9920 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
2023-04-24 01:33:27.831  INFO 9920 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2023-04-24 01:33:27.842  INFO 9920 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2023-04-24 01:33:28.258  WARN 9920 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-04-24 01:33:28.738  INFO 9920 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8888 (http) with context path ''
2023-04-24 01:33:28.749  INFO 9920 --- [           main] cn.com.UChat.UChatWebApplication         : Started UChatWebApplication in 4.763 seconds (JVM running for 5.269)
```

Then you type http://localhost:8888/login.html to enter the login page. If you are the first time to use UChat, you need to register an account to log in UChat. After you login you can chat with all online users and decide whether to add them to your friends list. After you send a request to add him, he accepts it. You can see his name in your friends list. At this time you can click his name to single chat with him. If you want to know more details you can watch the tutorial video. 

