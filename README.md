# DSL Architecture Demo
### Demonstrating Clean Architecture Using DSL
EN | [RU](README_ru.md)
---
This application provides an example of implementing clean architecture combined with a computational 
core based on DSL (Domain-Specific Language), utilizing readable and maintainable solutions.


## System Requirements
- JDK 20

The multi-module application consists of two modules:
> #### Module [core](core/README.md)
> Defines entities and their behavior. 

> #### Module [service](service/README.md)
> Contains the implementation of entities and their behavior.

The modules are structured according to the principle of separation of concerns and dependency direction. The primary goal is to achieve independence from frameworks.
Upon startup, the application loads rules from a YAML file, converts them into validation and action functions, which are executed after processing. 
Storing rules in a file is convenient, allowing analysts to edit rules without modifying the code. Optionally, rule loading from a database can also be implemented.
---
# Steps to Develop New Features:
* An analyst describes the rules in a YAML file, for example, for input data validation.
* When the application starts, the rules are loaded and converted into objects.
* These objects are interpreted based on your DSL.
* The controller receives requests and passes them to the service, where the rules are applied to the data.
---
[Testing](Testing.md)