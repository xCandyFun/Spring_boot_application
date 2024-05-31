# Spring Boot Application

You need a mysql database to run this application.
The standard port is 3306 for a mysql database.
You can change it in the application.yml for this project.

Here is how to build the layout of the database that I use:
https://github.com/xCandyFun/CSV-management

You need this docker image for the calendar:
https://hub.docker.com/repository/docker/xcandyfun/calendar_with_node/general

To start a container with the node calendar:
docker run -p 8081:8081 {NAME_ON_IMAGE} 

You need to create a .env file for login.
The .env should look something like this:

For admin:
ADMIN_LOGIN={USERNAME}
ADMIN_PASSWORD={PASSWORD}
ADMIN_ROLE="ADMIN"

For user:
USER_LOGIN={USERNAME}
PASSWORD_LOGIN={PASSWORD}
USER_ROLE="USER"


# Calendar With Node.js

I use insomnia to GET,POST,PUT and DELETE on the calendar.

To POST with json body:

{
"title":"test",
"start":"year-month-day",
"end":"year-month-day"
}

To GET,POST,PUT and DELETE use the url below:

http://localhost:8081/api/events

http://localhost:8081/api/events/{ID}

