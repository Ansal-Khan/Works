Prerequisites for the usage of the applications

1. Java v1.8+
2. Spring Boot v2.1+
3. Node v8.12.0+
4. Ionic v4.10.3+
5. Cordova v8.1.2+
6. Maven 3.5.4+
7. MySQL server v5.5.23+

## You can change the configurations of database, and server ports on the 'application.yml' configuration file. However, the spring and angular apps are configured to run on the below ports for smooth working. If you change the port of spring boot app, make sure you change the same in root url inside ionic app (contact-ionic-app/src/app/api/api-configuration.ts). Also if you are changing the port number of Ionic app, make sure you change the same in the CORS configuration on the spring boot application (contact-spring-boot-app/src/main/java/com/illud/contact/config/WebConfig.java).

---------------------------------
Configurations for spring boot.
	Database name: 'mycontacts'
	Tables: Don't create any tables since the application creates and configure those for you.
	usersname: 'root'
	password: 'root'
	server-port: 8085

---------------------------------
Configurations for Ionic.
	Port: 8100 (default port)

