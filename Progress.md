### Todo
#### Endpoints

- withdraw
- deposit
- transfer

#### RESTful endpoints

- update user


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
- Find User
- Find User By Id
- User Login
- User Logout
- Fin accounts
- find accounts by id
- find accounts by status
- find Accounts by user
- submit account
- update account
<!-- - Success route to show when s uaer is logged in -->

#### RESTful endpoints

- Get all users(Employees)
    * Employees and Admin can view all customer information, but not modify in any way
- register
### BUGS

- When I logout and there is no user session the code to handle that is broken

- There is something going on with my databse, when I try to login I have to use the value in the first name field for the password

- when i add a account i get a 0 back but the user is being added
- When I get the list of users back the id field value is 0
- Error when trying to update users
    - ERROR: duplicate key value violates unique constraint "users_user_name_key"
      Detail: Key (user_name)=(What) already exists.
__________________

## Project Completion Summary
- Employees can view all the users
- Method to update for Admin and Users is not work properly
- Standard users are able to log into their accounts