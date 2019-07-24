# Application Setup Instructions

This application is intended to be deployed in a docker container. In order to deploy the application in the docker, please follow the instructions given below. 

&nbsp;
&nbsp;
&nbsp;

## docker  network set up

All the containers are intercommunicated through a shared network called **<mark>autostreet_shared</mark>**.  

&nbsp;
&nbsp;


### Listing the docker networks 
First check whether the network is already created in the docker platform. This can be done with the following console command. 

```
docker network ls 
```


### Creating the docker network 

If the **<mark>autostreet_shared</mark>** network is not listed, it can be created as follows. 


```
docker network create
```
&nbsp;
&nbsp;


## Building docker image and deploying in container


### Compiling and building the application
```
mvn clean install -Dskiptests
```
&nbsp;
&nbsp;


### building the docker image
```
docker-compose build
```

&nbsp;
&nbsp;


### deploying the application in the docker container
```
docker-compose up -d
```

&nbsp;
&nbsp;


## Run as a single command

The following single command (combination of all above commands) can be run to compile and build the application, build the docker image out of it and deploy the image in a docker container. 

```
mvn clean install -DskipTests && docker-compose build && docker-compose up -d
```

&nbsp;
&nbsp;


## Shutting down the docker container

The following command will stop the created containers and remove them. 

```
docker-compose down
```
