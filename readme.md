## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [API](#api)
* [Setup](#setup)
* [Screens](#screens)


## General info
TopMMA give you possibility ( after registration and log in ) to check information about UFC fighters from sherdog.com. You can also create list of favorite fighter and send this result on email. Basically, this app works like this:
- sherdog.com usualy update ranking once a week so we dont need refresh this site all time. Due to you can just delete data base and start application with filled new updated records with up to date rankings from all fighter weight categories.
- when start app, TOPMMA will scratch sherdog.com page to get all top fighter by weight category and then save this records to data base.
	
## Technologies
Spring (Boot, Data JPA, Web, Security), JavaMail

## API
|              endpoint              | method | data sent with request  |                                                                                                                                                                                 description                                                                                                                                                                                 |
|:----------------------------------:|:------:|-------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| /users/register                    | POST   | User JSON               | Register user                                                                                                                                                                                                                                                                                                                                                               |
| /users/userDetails                 | POST   | UserDetailsDTO JSON     | Add details about user ( not necessary )                                                                                                                                                                                                                                                                                                                                    |
| /users/userDetails                 | PUT    | UserDetailsDTO JSON     | Edit users details                                                                                                                                                                                                                                                                                                                                                          |
| /users/userDetails                 | GET    |                         | Get user details                                                                                                                                                                                                                                                                                                                                                            |
| /api/TopMMA/X                      | GET    |                         | Where X is responsible for the appropriate weight category. If we replace Heavyweight for X (eg. /api/TopMMA/Heavyweight/) we will get the top 10 fighters from this weight category.  Similarly, we can choose the rest of the categories:  LightHeavyweight, Middleweight, Welterweight, Lightweight, Featherweight, Bantamweight, Flyweight.                             |
| /api/TopMMA/X/{fighterId}          | GET    |                         | Where X is responsible for the appropriate weight category. If we replace Heavyweight for X (eg. /api/TopMMA/Heavyweight/1) we will get fighter from given position of weight category.  Similarly, we can choose the rest of the categories:  LightHeavyweight, Middleweight, Welterweight, Lightweight, Featherweight, Bantamweight, Flyweight.                           |
| /api/TopMMA/favorite/X/{fighterId} | POST   |                         | Where X is responsible for the appropriate weight category. If we replace Heavyweight for X (/api/TopMMA/favorite/Heavyweight /1) we will add fighter from current position of weight category to favourite list.  Similarly, we can choose the rest of the categories:  LightHeavyweight, Middleweight, Welterweight, Lightweight, Featherweight, Bantamweight, Flyweight. |
| /api/TopMMA/favorite/              | GET    |                         | Get list of all fighter from favorite list                                                                                                                                                                                                                                                                                                                                  |
| /api/TopMMA/favorite/{fighterId}   | GET    |                         | Get fighter from favorite list by id (according to the position in which you added it in turn)                                                                                                                                                                                                                                                                              |
| /api/TopMMA/favorite/{fighterId}   | DELETE |                         | Delete fighter from favorite list by id                                                                                                                                                                                                                                                                                                                                     |
| /api/TopMMA/email/                 | GET    |                         | Send favorite fighters list to your email address (so now your user details is advisable)                                                                                                                                                                                                                                                                                   |
## Setup
To run this project:
```
git clone https://github.com/EmilFrankiewicz/TopMMA

create database topmma (by default in application.properties is username: root, password: password)

mvn clean package

java -jar target/TopMMA-0.0.1-SNAPSHOT.jar
```

## Screens
![DataBase](https://github.com/EmilFrankiewicz/TopMMA/blob/master/screens/db.png)

![RegisterUser](https://github.com/EmilFrankiewicz/TopMMA/blob/master/screens/register.png)

![AddUserDetails](https://github.com/EmilFrankiewicz/TopMMA/blob/master/screens/userdetails.png)

![GetAllByCategory](https://github.com/EmilFrankiewicz/TopMMA/blob/master/screens/getallbycategory.png)

![favoritelist](https://github.com/EmilFrankiewicz/TopMMA/blob/master/screens/favoritelist.png)
