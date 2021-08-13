# Allen Habibovic CS 420 - Final Project
## Project #10: Database Model


The main goal of this project was to build a relational database model and a command line terminal from scratch in the Java programming language and save all the records into a single file. It incorporates a wide variety of techniques and concepts that we have learned throughout the semester. No external libraries were used, only standard libraries provided in the standard java library packages. I was not able to fully implement the program as intended and had issues creating the command line interperter for simple SQL like commands such as SELECT, INSERT, AND CREATE.



## Features

- Create a relation(SQL-LIKE) table to hold records
- Select records from a particular table based on column fields.
- Insert new records into a table
- Store all this information in a single file.

## How To Use

The main program is located in the Main.java class inside of the main method. Inside the main method of the main class, I used a single lambda expression to go through the key value pairs of the table hashmap. The Database class holds all of the tables, and the Table class is the blueprint for instantianting new table objects. Once ran, the user is displayed a small and simple menu. Users can create many unique tables inside of the database which is stored as a hashmap. The user can quit the program by pressing the '0' number key. To create a new table, the user enters option #1, and enters a unique name for a new table and also enters the columns or fields of the relation(comma separated list). Option #2 allows users to insert rows or records to this table. Option #3 allows the user to retrieve and display on screen records from a particular table. Finally, option #4 allows the user to save all of these tables inside of a single .txt file. 


