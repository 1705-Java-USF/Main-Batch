/*
    Create the lookup table of user roles
*/
CREATE TABLE User_Roles
    (
        RoleID NUMBER(6),
        RoleName VARCHAR(80),
        CONSTRAINT Role_PK PRIMARY KEY (RoleID),
        CONSTRAINT UniqueFields UNIQUE (RoleName)
    );
    
/*
    Create the Users table
*/
CREATE TABLE Users
    (
        UserID NUMBER(6),
        FirstName VARCHAR2(100) NOT NULL,
        LastName VARCHAR2(100) NOT NULL,
        Address VARCHAR2(200),
        City VARCHAR2(80),
        State VARCHAR2(10),
        Zip VARCHAR2(20),
        Phone VARCHAR2(40),
        eMail VARCHAR2(100),
        Role NUMBER(6),
        UserName VARCHAR2(40) NOT NULL,
        Password VARCHAR2(40) NOT NULL,
            -- Passwords will not be stored encrypted in this
            -- particular database although it will normally
            -- be stored in a separate security table.
        CONSTRAINT Users_PK PRIMARY KEY (UserID),
        CONSTRAINT Users_UniqueFields UNIQUE
            (eMail, UserName),
        CONSTRAINT Users_Role FOREIGN KEY (Role)
            REFERENCES User_Roles(RoleID)
    );

/*
    Create the Reimbursements Status table
*/
CREATE TABLE Status
    (
        StatusID NUMBER(6),
        Status VARCHAR2(40),
        CONSTRAINT Status_PK PRIMARY KEY (StatusID)
    );

/*
    Create the Reimbursement Type table
*/
CREATE TABLE Types
    (
        TypeID NUMBER(6),
        TypeName VARCHAR(40),
        CONSTRAINT Type_PK PRIMARY KEY (TypeID)
    );
    
/*
    Create the Reimbursements table
*/
CREATE TABLE Reimbursements
    (
        ReimbID NUMBER(6),
        Descrip VARCHAR2(100),
        DateCreated TIMESTAMP NOT NULL,
        DateResolved TIMESTAMP,
        CreatedByID NUMBER(6) NOT NULL,
        ResolvedByID NUMBER(6),
        Amount NUMBER(8,2),
        Receipt BLOB,
        TypeID NUMBER(6),
        StatusID NUMBER(6),
        CONSTRAINT Reimb_PK PRIMARY KEY (ReimbID),
        CONSTRAINT Created_FK FOREIGN KEY (CreatedByID)
            REFERENCES Users(UserID),
        CONSTRAINT Resolved_FK FOREIGN KEY (ResolvedByID)
            REFERENCES Users(UserID),
        CONSTRAINT Type_FK FOREIGN KEY (TypeID)
            REFERENCES Types(TypeID),
        CONSTRAINT Status_FK FOREIGN KEY (StatusID)
            REFERENCES Status(StatusID)
    );

/*
    Populating the database with some of the necessary data
*/
INSERT INTO User_Roles VALUES(1, 'Employee');
INSERT INTO User_Roles VALUES(2, 'Manager');
INSERT INTO User_Roles VALUES(3, 'Terminated');
COMMIT;

INSERT INTO Types VALUES(1, 'Travel');
INSERT INTO Types VALUES(2, 'Training');
INSERT INTO Types VALUES(3, 'TPS Reports');
COMMIT;

INSERT INTO Status VALUES(1, 'Pending');
INSERT INTO Status VALUES(2, 'Approved');
INSERT INTO Status VALUES(3, 'Rejected');
COMMIT;
    
/*
    This stored procedure will be called whenever a new
    employee is to be inserted into the database
*/
CREATE OR REPLACE PROCEDURE Insert_New_Emp (
            id IN Users.UserID%TYPE,
            fn IN Users.FirstName%TYPE,
            ln IN Users.LastName%TYPE,
            addr IN Users.Address%TYPE,
            city IN Users.City%TYPE,
            st IN Users.State%TYPE,
            zip IN Users.Zip%TYPE,
            ph IN Users.Phone%TYPE,
            email IN Users.eMail%TYPE,
            role IN Users.Role%TYPE,
            username IN Users.UserName%TYPE,
            pwd IN Users.Password%TYPE
        )
    IS
    BEGIN
        INSERT INTO Users VALUES (
                id, fn, ln, addr, city, st, zip, ph, email, role,
                username, pwd
            );
        COMMIT;
    END;

/*
    This stored procedure will be called whenever a new
    reimbursement is added to the database
*/
CREATE OR REPLACE PROCEDURE Insert_New_Reimb (
            id IN Reimbursements.ReimbID%TYPE,
            descr IN Reimbursements.Descrip%TYPE,
            dCr IN Reimbursements.DateCreated%TYPE,
            dRe IN Reimbursements.DateResolved%TYPE,
            CrId IN Reimbursements.CreatedByID%TYPE,
            ReId IN Reimbursements.ResolvedByID%TYPE,
            amt IN Reimbursements.Amount%TYPE,
            rcpt IN Reimbursements.Receipt%TYPE,
            type IN Reimbursements.TypeID%TYPE,
            stat IN Reimbursements.StatusID%TYPE
        )
    IS
    BEGIN
        INSERT INTO Reimbursements VALUES (
                id, descr, dCr, dRe, CrId, ReId, amt, rcpt, type, stat
            );
        COMMIT;
    END;
    
-- Test the query that is used for logins
SELECT Password, Role FROM Users WHERE UserName="hsimpson";

-- Test the query that will be used to view reimbursement requests from a
-- single employee
SELECT r.Descrip, r.Amount, r.DateCreated, u.FirstName, u.LastName,
        t.TypeName, s.Status
    FROM Reimbursements r
    INNER JOIN Users u ON r.CreatedByID = u.UserID
    INNER JOIN Types t ON r.TypeID = t.TypeID
    INNER JOIN Status s ON r.StatusID = s.StatusID
    WHERE u.UserID = 3;
    
-- Test the query that will be used to view resolved requests from all
-- employees and which manager resolved it
SELECT r.Descrip, r.Amount, e.FirstName AS EmployeeFirstName,
        e.LastName AS EmployeeLastName,
        m.FirstName AS ManagerFirstName,
        m.LastName AS ManagerLastName,
        r.DateCreated, r.DateResolved
    FROM Reimbursements r
    INNER JOIN Users e ON r.CreatedByID = e.UserID
    INNER JOIN Users m ON r.ResolvedByID = m.UserID
    WHERE r.ResolvedByID IS NOT NULL;
    
-- Test the query that will be used to view pending requests from
-- all employees
SELECT r.Descrip, r.Amount, u.FirstName AS EmployeeFirstName,
        u.LastName AS EmployeeLastName, r.DateCreated
    FROM Reimbursements r
    INNER JOIN Users u ON r.CreatedByID = u.UserID
    WHERE r.ResolvedByID IS NULL;
    
-- Test the query that will change the user's password
UPDATE Users SET Password='kill' WHERE UserName='hsimpson';

-- Test the query that will update an employee's personal information
UPDATE Users SET Address='123 Penny Lane', City='New York', State='NY',
Zip='12345', Phone='(213) 323-4167', eMail='pgibbons@initech.com' WHERE Username='pgibbons';

-- Test the query that will return the max user ID
SELECT MAX(UserID) FROM Users;