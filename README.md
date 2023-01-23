# CSCI 1302 - Gallery v2022.fa

![Approved for: Fall 2022](https://img.shields.io/badge/Approved%20for-Fall%202022-darkgreen)

This document contains the description for the `cs1302-gallery` project
assigned to the students in the Fall 2022 CSCI 1302 classes
at the University of Georgia.

## Deadline Options

## Course-Specific Learning Outcomes

* **LO1.d:** Use shell commands to compile new and existing software solutions that
are organized into multi-level packages and have external dependencies.
* **LO2.e:** Utilize existing generic methods, interfaces, and classes in a software solution.
* **LO3.a:** Create and update source code that adheres to established style guidelines.
* **LO3.b:** Create class, interface, method, and inline documentation that satisfies a set of requirements.
* **LO5.b:** Utilize a build tool such as Maven or Ant to create and manage a complex software solution involving external dependencies.
* **LO7.a:** Design and implement a graphical user interface in a software project.
* **LO7.c:** Use common abstract data types and structures, including lists, queues, arrays, and stacks in solving typical problems.

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus.
In accordance with this notice, I must caution you **not** to
fork this repository on GitHub if you have an account. Doing so will more than
likely make your copy of the project publicly visible. Please follow the
instructions contained in the
[How to Download the Project](#how-to-download-the-project)
section below in order to do your development on odin. Furthermore, you must adhere
to the copyright notice and licensing information at the bottom of this document.


## Project Description

Your goal is to implement a GUI application in Java using JavaFX 17 that displays a
gallery of images based on the results of a search query to the
[iTunes Search API](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching).
This will require you to lookup things in Javadoc and apply your knowledge of
things like inheritance, polymorphism, and interfaces. The functional
and non-functional requirements for this project are outlined later in this
document. Here is an example of what your program might look like:

[![screenshot1](https://raw.githubusercontent.com/cs1302uga/cs1302-gallery/master/resources/screenshot.png)](https://youtu.be/5SsO63m-Q5A)

Click the image above or [here](https://youtu.be/5SsO63m-Q5A) for a video demo of the app (no audio).

Part of software development is being given a goal but not necessarily being
given instruction on all of the details needed to accomplish that goal. For example,
even though working with things like images, threads, JSON, and the iTunes Search API
haven't been covered in class, you are going to need to lookup how to do these things
in order to complete this project. Starter code and a generously helpful [FAQ](#faq)
are provided. After actively reading through the main parts of this project description
and taking notes, please read through the [FAQ](#faq) to see if it answers any of your
questions.

This project is also designed to help you better understand the usefulness of good
class design. While you can technically write your entire JavaFX-based
GUI application entirely in the `start` method, this will make your code messy,
hard to read, possibly redundant, likely more prone to errors, and it wouldn't pass
a style audit. Before you write any code, you should plan out your application's
scene graph (i.e., the containment hierarchy), and design custom components as needed.
If you find that you are writing a lot of code related to a specific component
(e.g., setting styling, adding event handlers, etc.), then it's probably
a good idea to make a custom version of that component in order to reduce
clutter.


//creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
