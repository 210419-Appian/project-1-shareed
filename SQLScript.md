```
--	role_id SERIAL PRIMARY KEY,
--	user_role  VARCHAR(30) NOT NULL UNIQUE
--);

--account status table
--CREATE TABLE account_status (
--	status_id SERIAL PRIMARY KEY,
--	status VARCHAR(30) NOT NULL UNIQUE 
--);


--account type table
--DROP TABLE IF EXISTS account_type
--CREATE TABLE account_type (
--	type_id SERIAL PRIMARY KEY,
--	account_type VARCHAR(30) NOT NULL UNIQUE 
--);

--users table
--CREATE TABLE users (
--	user_id SERIAL PRIMARY KEY,
--	user_name VARCHAR(30) UNIQUE NOT NULL,
--	user_password VARCHAR(20) NOT NULL,
--	first_name VARCHAR(30) NOT NULL,
--	last_name VARCHAR(30) NOT NULL,
--	email VARCHAR(50) NOT NULL,
--	user_roleId INT REFERENCES roles(role_id)
--);

--account table
--CREATE TABLE account (
--	account_id SERIAL PRIMARY KEY,
--	user_id INTEGER REFERENCES users(user_id),
--	balance FLOAT NOT NULL,
--	status INTEGER REFERENCES account_status(status_id),
--	account_type INTEGER REFERENCES account_type(type_id)
--);



--INSERT INTO roles(user_role)
--	VALUES ('Admin'), ('Employee'), ('Standard'), ('Premium');
	

--INSERT INTO account_type(account_type)
--	VALUES ('Checking'), ('Savings');

--INSERT INTO account_status(status)
--	VALUES ('Pending'), ('Open'), ('Closed'), ('Denied');

--INSERT INTO users(user_name, user_password, first_name, last_name, email, user_roleId)
--	VALUES ('user1', 'user1pass', 'Shannon', 'Reed', 'shannon@email', 1);

--TRUNCATE TABLE users;
```