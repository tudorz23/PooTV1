*Designed by Marius-Tudor Zaharia, September 2023*

# PooTV

---

## Table of contents
1. [What is PooTv?](#what-is-pootv)
2. [Platform presentation](#platform-presentation)
3. [Platform structure](#platform-structure)
4. [Navigation details](#navigation-details)
5. [I/O](#io)
6. [Implementation details](#implementation-details)
    * [Design choices](#design-choices)
    * [Design patterns used](#design-patterns-used)
    * [Program flow](#program-flow)
    * [OOP principles used](#oop-principles-used)

---

## What is PooTV?
* PooTv is a TV series and movie streaming service backend written in the Java
language.

---

## Platform presentation
* The platform's structure is based on a file system's principle.
* Thus, each test begins on an "Unauthenticated Homepage". This is a standard
page for a user that wants to access the platform, but is yet to login or
register using his account.
* Depending on the page the current user finds himself at a given moment of
time, he can perform two types of actions:
    * navigate to the next page;
    * perform one of the allowed operations on the current page.
* Any other action apart those described above will be signaled by an error
printed at the output.

---

## Platform structure
* The following scheme presents the supported pages and actions, but also which
pages can be accessed from any given page.
* In **bold** will be **pages**, while in *italic* will be *actions*.

* **Unauthenticated Homepage** - starting page of the program
  * **Login** - login page for an already registered user
    * *login* - the explicit login *action*
  * **Register** - register page for a new user
    * *register* - the explicit register *action*
* **Authenticated Homepage** - opening page after a successful login or register action
  * **Movies** - specific page where available movies are displayed to the user
    * **Authenticated Homepage**
    * *Search* - search for a movie tht stats with a certain prefix
    * *Filter* - apply given filters to the currently displayed movie list
    * **See Details** - page for displaying details of a specific movie
      * **Authenticated Homepage**
      * **Movies**
      * **Upgrades**
      * *Purchase* - specific action for purchasing the displayed movie
        * *Watch* - action for watching the displayed movie
          * *Like* - action for liking the displayed movie
          * *Rate* - action for rating the displayed movie
      * **Unauthenticated Homepage** - logging out
    * **Unauthenticated Homepage** - logging out
  * **Upgrades** - page where the user can upgrade his account
    * **Authenticated Homepage**
    * **Movies**
    * **Unauthenticated Homepage** - logging out
    * *Buy premium account*
    * *Buy tokens*
  * **Unauthenticated Homepage** - logging out

---

## Navigation details
* If an illegal action is performed on the **login** or **register** pages,
the user will be sent back to the **unauthenticated homepage**.
* The order of the possible performed actions on a movie is as follows:
*purchase*, *watch* and only then *like* or *rate*.

---

## I/O
* The input is read from a JSON file.
* First, a list of already registered users is given.
* Then, a list of available movies is given.
* Lastly, the actions list consists of several commands to be applied, with
different input varying from case to case.
* The output is also a JSON file and contains both error and success messages.
* To run the tests, the main method of ***Test*** class should be run.

---

## Implementation details
### Design choices
* The class that controls the flow of the program is ***UserInteraction***.
* The ***Database*** class is responsible for storing the registered users and
available movies.
* The ***Session*** class serves as the bridge between the user and the database,
as it manages the current page of the app, the currently logged-in user and the
movie list displayed to the user at a given time.
* Each concrete page class extends the base ***Page*** class, adding their particular
details.
* Enums are used for labeling different commands and pages.
* To check the validity of a 'change page' actions, each page stores the possible
next pages in a field, using an ArrayList.

### Design patterns used
* 3 design patterns have been used for this first stage:
#### Command pattern
* Used for separating the implementations of the multiple actions.
* Based on the usage of the ***ICommand*** interface, which exposes the `execute()`
method, thus abstracting the use of a command.
* The ***UserInteraction*** class iterates through the actions given as input
and calls the `execute()` method of the ***Invoker*** class, which, in turn,
calls the `execute()` method of ***ICommand*** interface.

#### Strategy pattern
* Used for diverging in implementation between the various ways of changing a page.
* Also used for the different implementations of the *Filter* command.
* Thus, two interfaces are used: ***IChangePageStrategy*** and ***IFilterStrategy***.
* The exposed methods are `changePage()` for ***IChangePageStrategy*** and `filter()`
for ***IFilterStrategy***.

#### Factory pattern
* Used for creating **Page** instances in ***PageFactory*** class.
* Used for creating **ICommand** instances in ***CommandFactory*** class.
* Used for creating **IChangePageStrategy** instances in
***ChangePageStrategyFactory*** class.

### Program flow
* ***Main*** class calls the `startUserInteraction()` method.
* ***UserInteraction*** iterates through the actions and uses the command factory
to generate ***ICommand*** classes, the ***Invoker*** class serving as an intermediary
to call the `execute()` method.
* Depending on the type of command, actions are performed, usually modifying the state
of the ***Session*** instance.
* In case of the 'change page' command, the factory is used for generating the necessary
strategy, which, in turn, checks if the action can be performed. If it can, it
uses te ***PageFactory*** to create the wanted **Page** instance and updates the *page*
field of the **Session** instance. All these actions are triggered by the
***ChangePageCommand*** instance calling the `changePage()` method of the interface.

### OOP principles used
* ***Inheritance***
  * Each concrete **Page** class extends the base ***Page*** class.
* ***Abstraction***
  * Command and Strategy patterns are based on interfaces, which present abstract methods.
* ***Polymorphism***
  * The Command and Strategy patterns also use the polymorphism, as at runtime it is
  unknown which concrete objects will call the implementations of the abstract methods.
* ***Encapsulation***
  * All classes have *private* fields and *getter* and *setter* methods are implemented.
  * The main goal of using design patterns is to achieve encapsulation, for each class
  to have a single responsibility.
