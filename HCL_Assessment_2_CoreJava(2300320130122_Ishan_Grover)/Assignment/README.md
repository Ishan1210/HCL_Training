# Library Management System

**Name:** Ishan Grover  
**Roll No.:** 2300320130122  


## Run Statements

Compile the project from the `Assignment` directory:

```bash
javac -d out src/com/hcl/library/exception/*.java src/com/hcl/library/model/*.java src/com/hcl/library/repository/*.java src/com/hcl/library/util/*.java src/com/hcl/library/service/*.java src/com/hcl/library/Main.java
```

Run the application:

```bash
java -cp out com.hcl.library.Main
```

## Test Cases

**Test Case 1: Borrow an available book**

- Add a book with a valid title and publication year.
- Register a member with a valid email.
- Borrow the book using its item ID and the member ID.
- **Expected Result:** The book is issued successfully and its availability changes to `false`.

**Test Case 2: Exceed the borrowing limit**

- Register a member and add four available library items.
- Let the member borrow three items, then attempt to borrow the fourth.
- **Expected Result:** The system throws `BorrowLimitExceededException` and rejects the fourth borrowing request.

