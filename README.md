# Learning and getting accustomed with Spring 
###### Winter Vacation December,2018
### Concepts and technology learnt/revised
  - J2EE
    + Servlet
    + JDBC
    + JSP
  - Database used
    + PostGresql
    + Mongo db
  - Introduction to microservice builder 
    + Spring framework
    + Spring JDBC
    + Spring MVC
    + Restful web service using spring mvc
  - client side programming
    + JS, jQuery, Ajax

### Hands on projects/examples
  + firstspring *(spring project)*
    - understood how IoC is being achieved using DI in spring framework
    - got concept of spring beans
    - leart to write the spring configuration file
  + Db connection *(core java project)*
    - wrote an interface to write some dummy data into database
    - an sql implementation and a no sql implementation was provided for that interface
    - basics about MongoDb was learned
  + hello world spring mvc, hello world 2 spring mvc *(spring project)*
    - learnt about model-view-controller design pattern
    - loosly coupled modules and developing them independently
    - initialising dispatcher servlet
    - better understanding of the bean configuration
  + csv reader *(core java project)*
    - actually .xls and .xlsx reader
    - used Apache POI Java Excel API
  + student record **1st iteration** *(spring mvc project)*
    - in this project the target was to provide data both in PostgreSql and mongo db using form and excel file
    - on the 1st iteration of development cycle the 'views' were used to take input from user.
    - observed the advantages of using JdbcTemplate provided by spring
  + spring rest example
    - introduction to RESTful API
    - usage of RequestMappingHandlerAdapter & MappingJackson2HttpMessageConverter
  + student record **2nd iteration** *(rest API with spring mvc)*
    - on the 2nd itreration the project was converted into a restful service
    - did client side programming (using jQuery and Ajax) to make API request and responses.
    - learnt about CORS.
    - final submission (upload module for data saved in excel)
### Future work plan
   + Adding bulk insertion feature (currently batch insertion is supported which may fail in case of large ammount of data insertion)
   + DAO can be more structured (adding service layer may be helpful ! )
   + Better naming convention
