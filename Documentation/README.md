## RevatureProject1

1. Import project
2. Change version from 1.5 to 1.8
    - Go to the project's properties
    - Click `Java Build Path
    - Click the `Libraries` tab in the Java Build Path Window 
    - Click `JRE System Library` then `Remove`
    - Click `Add Library` then `JRE System Library`
    - Select `Execution environment` then click the drop down and select `JavaSE-1.8(jre)`
    - Click Finish, you should see the new version now in the Java Buil Path window
    - Click `Apply and Close`


_______________________
<!-- ### Project Setup

#### User
- An abstract User superclass that defines the general structure of user objects
    - parameterized constructors to initialize fields
    - Extended By:
        - Role class

#### Employee Interface

### Standarad Users / Customer Interface
________________________________

### Java Application
#### Internet
- sends http request to the Java's app **Controllers/Servlets**

#### Controllers/Servelet Layer
- collects the information from the https request and passes it to **SERVICES** as objects

#### Services Layer
- services such as user and account services are located here
- takes the infoemation from the **Controllers/Servlets**(as params in methods) to perform business logic
    - E.g. compare passwords, subtract from account balance
- this will call the DAO(Database Access Layer) for stored informationlike account balance or user credentials

#### DAO Layer
- repositories, UserDAO, AccountDAO
- calls the database for stored information and returns it as Java objects
- the DAO passes the needed information back to the Services layer and all the logic happens there

### Models
- objects that will be manipulated
    - E.g User, Account, UserRole
### Utils
- utility classes your program needs to function
    - e.g Connection Utils

### Exceptions/Throwables
- Custom Throwables -->