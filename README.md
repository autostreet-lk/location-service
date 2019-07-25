# 1. Introduction

### 1.1 overview
   This is a microservice API developed to get the location based information (such as ***districts*** and ***cities***) as a part of ***AutoStreet.LK*** platform. 
     

### 1.2 Prerequisite
   In order to build, deploy and run the application, the production environment should have the following dependencies. 
 
   **Maven** <br/>
   **Java 12 or Higher** <br/>
   **Docker**
   
   
### 1.3 Deployment Architecture

the diagram should goes here 

   

# 2. Code Quality Analysis and Test Coverage


# 3. Application Setup Instructions

This application is intended to be deployed in a docker container as a part of multi-container docker application. In order to, set up and deploy the application you need to follow the series of instructions given below. 

&nbsp;
&nbsp;
&nbsp;

## 3.1 docker  network set up

All the containers are inter-communicated through a shared network called **<mark>autostreet_shared</mark>**. This must be made available and accessible for all related containers. This network can be configured as follows.  

&nbsp;
&nbsp;


### 3.1.1 Listing the docker networks 
The following command can be executed to list down the available networks in the docker environment. 
&nbsp;
```
docker network ls 
```

&nbsp;
&nbsp;

### 3.1.2 Creating the docker network 

If the **<mark>autostreet_shared</mark>** network is not listed, it can be created by executing the following comand. 
&nbsp;
```
docker network create
```
&nbsp;
&nbsp;
&nbsp;
&nbsp;


## 3.2 Building docker image and deploying in container
&nbsp;
&nbsp;

### 3.2.1 Compiling and building the application

The docker image will be created using the application artifact that we have already built. Therefore we need to create the application artifact before proceeding with creating the docker image. This can be achieved with the following command. 
&nbsp;
```
mvn clean install -DskipTests
```
&nbsp;
&nbsp;


### 3.2.2 building the docker image
After executing the 3.2.1 command, the following command can be used to build the docker image. 
```
docker-compose build
```

&nbsp;
&nbsp;


### 3.2.3 deploying the application in the docker container
Once the docker image is built, the following command can be executed to deploy and run the image in a container. 
```
docker-compose up -d
```

&nbsp;
&nbsp;


### *Run as a single command*

The following single command (combination of all above commands in 3.2) can be run to compile and build the application, build the docker image out of it and deploy the image in a docker container. 

```
mvn clean install -DskipTests && docker-compose build && docker-compose up -d
```

&nbsp;
&nbsp;


### *Shutting down the docker container*

You can execute the following command to stop and remove the running containers (created and executed through ***docker-compose up***).

```
docker-compose down
```

&nbsp;
&nbsp;
&nbsp;
&nbsp;


# 4. Api Documentation

This section describes the list of operations supported through the Api. This can be summarized as follows
&nbsp;


| method  | resource  | description  |
|---|---|---|
| `GET`  | `/districts`  | getting a list of all available districts  |
| `GET`  | `/districts/{district-id}/cities`  |  getting a list of all registered cities under the given district  |

&nbsp;


# GET  /districts
This will return a list of all districts 

**Headers**
 * ```Content-Type: application/json```
 * ```Accept: application/json```
 * ```X-Api-Version: v1```
 
&nbsp;

**Sample Request**

```GET  http://localhost:8080/districts```

&nbsp;

**Response Body**

* ``Status : 200``
* ``Content-Type : application/json``

```
{  
      "districts":[  
         {  
            "id":26,
            "name":"All of Sri Lanka",
            "represent":"all-districts"
         },
         {  
            "id":4,
            "name":"Ampara",
            "represent":"individual"
         },
         {  
            "id":5,
            "name":"Anuradhapura",
            "represent":"individual"
         },
         {  
            "id":6,
            "name":"Badulla",
            "represent":"individual"
         }
      ]
 }
```


&nbsp;
&nbsp;


# GET  /districts/{district-id}/cities
This will return a list of cities registered under the given district

**Params**
* ```district-id```  - id (identifier) of the desired district 


**Headers**
 * ```Content-Type: application/json```
 * ```Accept: application/json```
 * ```X-Api-Version: v1```
 
&nbsp;

**Sample Request**

```GET  http://localhost:8080/districts/{district-id}/cities```

&nbsp;

####**Response Body** - *success response*
list of cities registered under the given district 
 

* ``Status : 200``
* ``Content-Type : application/json``

```
{
    "cities": [
        {
            "id": 5,
            "name": "All of Colombo",
            "represent": "all-cities"
        },
        {
            "id": 4,
            "name": "Athurugiriya",
            "represent": "individual"
        },
        {
            "id": 3,
            "name": "Battaramulla",
            "represent": "individual"
        },
        {
            "id": 2,
            "name": "Kaduwela",
            "represent": "individual"
        },
        {
            "id": 1,
            "name": "Malabe",
            "represent": "individual"
        }
    ]
}
```


&nbsp;
&nbsp;

####**Response Body** - *error response*
The following response will return if the district id does not exist

* ``Status : 404``
* ``Content-Type : application/json``

```
{
    "message": "no district found with id [900]"
}
```

&nbsp;
&nbsp;
# 5. Contact Me
If you need any clarification, you can reach me through following ways.

**Name** Chathuranga Tennakoon 

**Email** chathurangat@gmail.com

**Blog** www.SpringBootDev.com

**Phone** +94716329281
