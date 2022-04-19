# bookstore

The app has been deployed to heroku

https://ns-bookstore.herokuapp.com/

Please click on the link and then you can access the app by the credentials that I have provided.


Below issue is related to when one wants to deploy through the gui of heroku. The solution was to do it from the cli.

Bookstore spring boot, Thymeleaf app with roles - admin to edit, create etc, and user to view books, security(basic authentication) user functions, and with queries

Currently it is not possible to deploy to heroku with database support for security concerns

https://status.heroku.com/incidents/2413

As soon as everything comes back to normal i will be deploying this app the same way as the previous ones

What this app does is, it comes with two different users with two different access rights and policies

After authentication(base authentication) the users will be shown different views
Also different quesries will be executed to order the columns beings shown

The ADMIN user is able to create, update, delete books
The normal user is only able to read
logout functionality is also implemented

Thymeleaf is used to dinamically present data being queried from the database, etc
Spring data is being used, therefore in a local setup only the access to a database should be changed and then the app should start up automatically
by creating the table and the schema

currently because of heroku's issues it comes with a local setup(mysql, on heroku I am using postgre), because pushing the .jar to heroku and the procfile plus the database integration does not work right now.


![image](https://user-images.githubusercontent.com/31439537/163974071-41b0c741-0f6f-472e-97a2-b055f2cc4da2.png)



