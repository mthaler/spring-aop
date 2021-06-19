# spring-aop

Aspect-oriented programming (AOP) is a core feature of the Spring framework. AOP is useful for implementing *crosscutting concerns*, that is, application logic that cannot be decomposed from the rest of the application and may result in code duplication and tight coupling. Logging and security are typical examples of crosscutting concerns that are present in many applications.

The example code demonstrates how to implement a before advice that checks user credentials before allowing the method invocation to proceed.
This is a Kotlin port of the code from the book Pro Spring 5: An In-Depth Guide to the Spring Framework and Its Tools.
