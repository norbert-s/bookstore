# bookstore

bookstore app with admin, security, admin and user functions, and with queries

Currently it is not possible to deploy to heroku with database support for security concerns

https://status.heroku.com/incidents/2413

As soon as everything comes back to normal i will be deploying this app the same way as the previous ones

What this app does is, it comes with two different users with two different access rights and policies

After authentication(base authentication) the users will be shown different views
Also different quesries will be executed to order the columns beings shown

The ADMIN user is able to create, update, delete books
The normal user is only able to read
logout functionality is also implemented

currently because of heroku's issues it comes with a local setup(mysql, on heroku I am using postgre), because pushing the .jar to heroku and the procfile plus the database integration does not work right now.


Next I will be implementing user registration with roles accross 3 tables ( user, roles, and one table to reference users with roles)



