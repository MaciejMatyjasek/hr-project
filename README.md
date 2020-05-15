# hr-project
Test project for technical verification.

## Technical stack
Application
- Java 8
- Maven
- Oracle XE
- Docker

##Project Structure
- Docker (initial docker-compose and SQL scripts)
- Configuration (URL and Properties for database connection)
- Dao (Database communication layer)
- Query (SQL statements)
- Service (Business logic layer)

##How to run developer environment
- Create an account at https://hub.docker.com/ (skip this step if you already have)
- Launch the command line console in  ```hr-project/docker``` directory and enter ```docker login```
- Enter your login and password
- After logging in, enter the command: ```docker-compose up``` (the Oracle 12.2 database image will be downloaded once and then launched)
- Create a new connection using SqlDeveloper or another application cooperating with the Oracle database
 ```
         Username: sys as SYSDBA
         Password: Oradoc_db1
         Hostname: localhost
         SID: ORCLCDB
         PORT: 1521
 ```
 
-  On the newly created connection, run statements contained in the ```createnewuser.sql``` file (username and password can be changed to any one before executing SQL commands) and ```schema.sql``` (in this order!). The files are located in the ```hr-project/docker``` directory.

<h3>Caution!<p>
- If You already have oracle installed with given structure, just change ```url``` and  ```properties``` in ```DataSourceConfiguration.class```

#Branch and commit structure 
```<TYPE>/<DESCRIPTION>```

TYPE:
- feature - for new functionalities, 
- hotfix - for issues blocking development process, 
- build - for non application changes ex. Maven,
- docks - for project documentation

DESCRIPTION - issue description

all branches are marging to ```master```


