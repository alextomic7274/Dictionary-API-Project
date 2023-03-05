# Text-to-Definitions API

This java API provides a suite of methods that can parse a text file and output every word, its definition, and page location to a CSV file. It utilizes a variety of tools to provide this service including:
- Virtual Threads from Project Loom to concurrently load the google most-common words and dictionary text files. 
- Data structures such as Hash Maps to quickly access word definitions with a constant time complexity.
- Object-Oriented Concepts such as SOLID principles and abstraction, polymorphism, inheritance, and encapsulation to maximize reusability, and ensure high cohesion and low coupling. 

## Installation & Usage

- Compile and run all the java classes in the src directory with java 19+. (Ensure previews are enabled)
- Download the dictionary and google-1000 text files from the repo and move them to the same directory as the source code.
- Run in the terminal with previews enabled and follow instructions. 
- If successful, a CSV file will appear in the directory with every word found in the text, its page location(s) and definition(s). (Duplicates and google 1000 most common words are excluded).

## Application in Action

![image](https://user-images.githubusercontent.com/64744056/222973895-0f2e8cdd-c1b2-41f7-9547-67a11ff97ed4.png)


