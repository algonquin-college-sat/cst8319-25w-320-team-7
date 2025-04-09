# What is Flyway?

**Flyway** is a database version control tool. With it, you can:

✅ Track the history of changes in your database schema (like Git, but for the database)  
✅ Automatically run SQL scripts when your application starts  
✅ Avoid conflicts between environments (development, staging, production)  
✅ Keep your database in a consistent and reliable state

---

## Where is Flyway used?

Our database tables and some initial parameters are controlled and versioned using Flyway.

---

## How can I make changes to the database?

### 1. Create a migration file

Flyway uses the following naming convention for migration files:

```
V<version>__<description>.sql
```

For example:

```
V1__create_users_table.sql  
V2__insert_initial_users.sql
```

This file must be created in the following directory:

```
backend/src/main/resources/db/migration
```

---

### 2. Add DDL and/or DML commands to the file

**Example of DDL (creating a table):**

```sql
-- V1__create_users_table.sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

**Example of DML (inserting data):**

```sql
-- V2__insert_initial_users.sql
INSERT INTO users (name, email) VALUES
('Alice', 'alice@example.com'),
('Bob', 'bob@example.com');
```

You can mix DDL and DML commands in the same file, but it's better to separate them to keep things organized.

---

### 3. Run the application

When you run the application, Flyway will detect the new files and automatically apply the migrations to the database.

---

### 4. Check the database

Flyway creates a table called `flyway_schema_history` to keep a log of all applied migrations.  
There, you can see which migration files have already been executed.

---