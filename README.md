# Text File Indexer API

This Java API provides a suite of methods that can parse a text file and output every word, its definition, and page location to a CSV file. It utilizes a variety of tools to provide this service including:
- Virtual Threads to concurrently load the Google most-common words and dictionary text files. 
- Data structures such as Hash Maps to quickly access word definitions in constant time.
- Object-Oriented Concepts such as SOLID principles and abstraction, polymorphism, inheritance, and encapsulation to maximize reusability, and ensure high cohesion and low coupling. 

## Installation & Usage

- Compile and run all the Java classes in the src directory with Java 19+. (Ensure previews are enabled)
- Download the dictionary and google-1000 text files from the repo and move them to the same directory as the source code.
- Run in the terminal with previews enabled and follow instructions.
#### N.B Make sure full file paths are entered and a .txt file is specified for the output file. 
- If successful, a text file will appear in the directory with every word found in the text, its page location(s), and definition(s). (Duplicates and Google 1000 most common words are excluded).

## Demo Images
### Main menu
![image](https://user-images.githubusercontent.com/64744056/222973895-0f2e8cdd-c1b2-41f7-9547-67a11ff97ed4.png)
### Loading up config files
![image](https://user-images.githubusercontent.com/64744056/224584166-6eeeaafe-b3da-4bfa-8942-8d999e329f6f.png)
### Specify the output file
![image](https://user-images.githubusercontent.com/64744056/224584199-1ac1be6c-6d65-42fa-8428-907b567c1a89.png)
### Running indexer
![image](https://user-images.githubusercontent.com/64744056/224584238-71fb48ed-ac15-4a60-b220-5a5d7d25ee7a.png)
### Output in a text file
![image](https://user-images.githubusercontent.com/64744056/224584286-e2269f88-2fe5-4355-bf6e-7c7da2c08b36.png)




