### Todo
#### Endpoints
- register(almost complete just need to add it to the real project)
- withdraw
- deposit
- transfer

#### RESTful endpoints
- Find User
- Find User By Id
- update user
- Fin accounts
- find accounts by id
- find accounts by status
- find Accounts by user
- submit account
- update account

### Completed
#### Database
##### Tables
- Roles
- Users
- Accounts
- AccountType
- AccountStatus
- UserAccounts

#### Models
- Users
- Role
- Employee
- Admin
- Account
- AccountType
- AccountStatus

#### RPC Endpoints
- User Login
- User Logout
- Success route to show when s uaer is logged in

#### RESTful endpoints

- Get all users(Employees)
    * Employees and Admin can view all customer information, but not modify in any way

### BUGS

- When I logout and there is no user session the code to handle that is broken

- There is something going on with my databse, when I try to login I have to use the value in the first name field for the password

- when i add a account i get a 0 back but the user is being added
- When I get the list of users back the id field value is 0