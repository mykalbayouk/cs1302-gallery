# Learning Outcomes

* Used shell commands to compile new and existing software solutions that
are organized into multi-level packages and have external dependencies.
* Created class, interface, method, and inline documentation that satisfies a set of requirements.
* Utilized build tool Maven to create and manage a complex software solution involving external dependencies.
* Designed and implemented a graphical user interface in a software project.
* Used common abstract data types and structures, including lists, queues, arrays, and stacks in solving typical problems.


## Project Description

The goal was to implement a GUI application in Java using JavaFX 17 that displays a
gallery of images based on the results of a search query to the
[iTunes Search API](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching).
This required me to lookup things in Javadoc and apply your knowledge of
things like inheritance, polymorphism, and interfaces. The functional
and non-functional requirements for this project are outlined later in this
document. Here is an example of what your program might look like:

[![screenshot1](https://raw.githubusercontent.com/cs1302uga/cs1302-gallery/master/resources/screenshot.png)](https://youtu.be/5SsO63m-Q5A)

Click the image above or [here](https://youtu.be/5SsO63m-Q5A) for a video demo of the app (no audio).

Part of software development is being given a goal but not necessarily being
given instruction on all of the details needed to accomplish that goal. For example,
even though working with things like images, threads, JSON, and the iTunes Search API
haven't been covered in my classes, I had to lookup how to do these things
in order to complete this project. 

This project was also designed to help me better understand the usefulness of good
class design. While I could have technically wrote the entire JavaFX-based
GUI application entirely in the `start` method, this will have made my code messy,
hard to read, possibly redundant, likely more prone to errors. Before I wrote any code, 
I planned out the application's scene graph (i.e., the containment hierarchy), and designed custom components as needed.

