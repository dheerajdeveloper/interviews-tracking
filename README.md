# notification-system
This README.txt file contains the files and the architecture of the application.
This application is created in a spring boot application. 
It has an inbuilt h2 in memory database.
it contains a file named logicticsScript.sh to run the api and start the initiate
It has four controller.
## Controllers:
UserController: This controller takes care of all user related activities like adding user, getting details about the user

NotificationController: This takes care of adding or removing notification for a user

ChannelController: This takes care of adding or removing channel for a user

ItemController: This takes care of adding or removing item for a user

# Basic api's and example:

## Adding user api:
curl -X POST -H "Content-Type:application/json" -d '{ "username" : "Dheeraj Tyagi"}' localhost:8080/user/add

## adding channel for a user:
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "channel" : "WEB"}' localhost:8080/channel/add

## adding a notification type for a user:
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "SHIPMENT_IS_CREATED"}' localhost:8080/notification/add

## Adding item for a user:
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "name" : "RADIO"}' localhost:8080/item/add

## Get all details about a user
curl -X GET -H "Content-Type:application/json" localhost:8080/user/getuseralldetail/1

## Send notification for a user:
curl -X POST -H "Content-Type:application/json" -d '{ "itemId" : "1" , "notificationEvent" : "SHIPMENT_IS_CREATED"}' localhost:8080/notification/send

All these api calling example are present in the logicticsScript.sh script. 

# steps to run the application
Go the the root folder of the application

run the command : mvn spring-boot:run

The application will start now. The h2 db console can be accessed at: localhost:8080/console

run script in the root folder: sh logicticsScript.sh

call notification api for the user: e.g. curl -X POST -H "Content-Type:application/json" -d '{ "itemId" : "1" , "notificationEvent" : "SHIPMENT_IS_CREATED"}' localhost:8080/notification/send

Check the output at the console. You will find output like 
2017-08-15 22:21:28.962  INFO 91071 --- [nio-8080-exec-3] c.n.helper.WebChannelNotifier            : Successfully sent notification for user User{id=1, username='Dheeraj Tyagi'} , item Item{id=1, userId=1, name='RADIO'} over WEB channel 

2017-08-15 22:21:28.963  INFO 91071 --- [nio-8080-exec-3] c.n.helper.SmsChannelNotifier            : Successfully sent notification for user User{id=1, username='Dheeraj Tyagi'} , item Item{id=1, userId=1, name='RADIO'} over SMS channel 

2017-08-15 22:21:28.963  INFO 91071 --- [nio-8080-exec-3] c.n.helper.EmailChannelNotifier          : Successfully sent notification for user User{id=1, username='Dheeraj Tyagi'} , item Item{id=1, userId=1, name='RADIO'} over EMAIL channel 

