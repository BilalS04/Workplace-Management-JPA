# Workplace Management System (JPA + PostgreSQL)

This is a Java-based workplace management system using JPA (Java Persistence API) and PostgreSQL for data persistence. The application is structured using the DAO (Data Access Object) pattern and demonstrates how to interact with a relational database in a modular and testable way.

---

## 🧩 Project Structure

### 1. **Entities**
Entity classes map Java objects to PostgreSQL tables using JPA annotations. These classes define table structure and include relationships (e.g. `@OneToMany`, `@ManyToOne`).

### 2. **DAO (Data Access Objects)**
Classes that encapsulate database access logic using JPA's `EntityManager`. These methods include:
- Insert (persist)
- Update (merge)
- Delete (remove)
- Query (JPQL)

### 3. **Main**
Contains the entry-point (`main` method) which demonstrates the use of DAO methods to:
- Insert test data
- Fetch and display information
- Validate entity relationships and CRUD operations

---

## 🔧 Technologies Used

- Java 17+
- JPA (with Hibernate)
- PostgreSQL
- JDBC
- Eclipse
