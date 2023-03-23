# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

### Entry
Entry class is the underlying superclass for Expense and Income classes. It establishes the common attributes and methods that are necessary to represent Expenses and Incomes. Abstract class is used to represent their common features to maximize code reusability and increase maintainability. 

Private attributes
Info: String that stores the description of the entry
Amount: Double that stores the monetary value of entry
Time: LocalDateTime that stores the date and time of entry

**Methods**

Getters can be used to provide the private attributes to other classes

editDescription(), editAmount(), editTime()
* Takes in corresponding parameters to edit the private attributes.
* Used by EntryList to make edits

isSameMonth()
* Takes in Integer year and Month month and returns if the entry is made in the date specified by parameters. 

### EntryList

The EntryList class represents a collection of Entry instances. It is an abstract class that serves as a superclass for ExpenseList and IncomeList classes, providing common functionalities to minimize repetitive code and easing code maintenance. It provides underlying methods for adding, removing, editing, and listing entries from the list, which can be expenses or incomes depending on the subclass. 

On top of the methods that provide basic functionality of expense/income lists, the EntryList class provides additional methods such as summing all entries or filtering the entries according to LocalDate provided to the method. Most methods of EntryList take in a List<Entry>, which is because it has to operate on a list of expenses or incomes passed by the IncomeList or ExpenseList subclasses. 

**Methods**

addEntry()
* Takes an Entry instance as a parameter and adds it to the class-level list


listEntry()
* Takes in a list of Entry and passes them to the UI to print to the user.
* Makes use of toString() method of entries.


deleteEntry()
* Takes in the list of entry and index of the entry to be deleted.
* The method acts as an underlying method for subclasses' deletion methods.


editEntry()
* Overloaded method. All methods take in the LinkedList of entries and the index of the entry that has to be edited. Another parameter has to be provided, which can be double, LocalDateTime, or String.
* additional parameter double edits the money amount of the entry in the list.
* additional parameter LocalDateTime edits the time when the entry is made.
* additional parameter String edits the description of the entry in the list.

getTotalAmount()
* Takes in a list of entries and returns the sum of all entry's monetary value.
  
SortEntryByAmount()
* Returns a sorted list of entry by amount of entry.


SortEntryByDate()
* Returns a sorted list of entry by date of entry.
  

### ExpenseList, IncomeList

Classes ExpenseList and IncomeList is responsible for keeping track of the corresponding entry instances added to the program by the user. At a class level, it keeps a **LinkedList** of corresponding entries. They both extend EntryList, the abstract class that represents a collection of Entry instances. It provides static functionalities of managing and viewing entry instances at a class level. Instances of ExpenseList and IncomeList are not created as all functionalities can be provided at the class level. 
  
**Methods**
  
listExpense() / listIncome()
* Overloaded method, may take it no parameter or LocalDate parameter
* If it has no passed parameters, it returns all entries in the list
* If a LocalDate is passed, it returns all entries made in the month specified by LocalDate instance.

  
### Budget
  
The Budget class represents the user’s monthly budget. The class utilize class-level hashmaps to represent the monthly budget, using outer key year and inner key month. It provides a method to set and view budget for different months. 

It makes use of a static HashMap<Integer, HashMap<Month, Double>> to keep track of monthly budget. If the user tries to access budget using keys that are not entered in the HashMap, it will return a warning mentioning that the inquired budget has not been set yet. 
  
## Product scope
### Target user profile

BrokeMan is suitable for students who have to work with tight budgets, students who want to use their money efficiently, and students who want to minimize their spending.

### Value proposition

The program will offer visualization of the user's incomes, expenses and budget, allowing them to recap and be mindful about their financial status. The project will allow division of budget into multiple subcategories of expenses. In essence, the program sets students up for a better financial future.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|user|add, delete, edit, and list my income|manage my income|
|v1.0|user|add, delete, edit, and list my expenses|manage my expenses|
|v1.0|user|set and view my budget|set expectation of how much money I should use|
|v1.0|user|view how much of the budget I spend|manage and change my spending habit as necessary|
|v1.0|user|view all comments that I can enter|get help on the features if necessary|
|v2.0|user|list monthly expenses, income, and budget|refer to financial status in previous months|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
