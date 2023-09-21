*Designed by Marius-Tudor Zaharia, September 2023*

# PooTV

---

## Table of contents
1. [What is PooTv?](#what-is-pootv)
2. [Platform presentation](#platform-presentation)
3. [Platform structrue](#platform-structure)
4. [Navigation details](#navigation-details)

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