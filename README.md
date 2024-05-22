<p align="center">
  <a href="" rel="noopener">
  <img width=200px height=200px src="src\main\resources\images\anaconda.png" alt="Project logo"></a>
</p>

<h3 align="center">Snake Game</h3>


<p align="center"> This is the remastered version of the popular Snake Game realized using the Java Swing classes.
    <br> 
</p>

## 📝 Table of Contents
- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Preview](#preview)
- [Built Using](#built_using)
- [TODO](./TODO.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>
Snake is the common name for a video game concept where the player maneuvers a line
which grows in length, with the line itself being a primary obstacle. The concept
originated in the 1976 arcade game Blockade, and the ease of implementing Snake has led
to hundreds of versions (some of which have the word snake or worm in the title) for
many platforms. After a variant was preloaded on Nokia mobile phones in 1998, there was
a resurgence of interest in the snake concept as it found a larger audience.

## 🏁 Getting Started <a name = "getting_started"></a>
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
To check if you already have the requirements
run the following command(cmd/linux terminal):
- for __Java__: ``` java --version```
- for __Maven__: ``` mvn --version ```

If you don't have the requirements above mentioned you should follow the following links to install them:
- [Maven](https://maven.apache.org/)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)

### Installing
To run the app you should follow the next steps, after installing the requirements. In the root folder of the project type:

```
mvn install
```

If the above command succeeds you should have a new folder called target. After this to run the app you should type:
```
mvn exec:java
```

## 🔧 Running the tests <a name = "tests"></a>
To run the unit-tests on your local computer type the following command: ```mvn test```

## 🎈 Usage <a name="usage"></a>
After running the ```mvn exec:java``` command you should be ready to use the Snake Game developed in this project.

## 👀 Preview <a name = "preview"></a>
 <img width=900px height=630px src="src\main\resources\images\screenshot.png" alt="Project preview">

## ⛏️ Built Using <a name = "built_using"></a>
- [Maven](https://maven.apache.org/) - build tool
- [Java 14 JDK](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) - virtual machine needed to run & compile the Java code
- [Visual Studio Code](https://code.visualstudio.com/) - code editor

## ✍️ Authors <a name = "authors"></a>
- [@gabriel-rusu](https://github.com/gabriel-rusu) - Idea & Initial work

## 🎉 Acknowledgements <a name = "acknowledgement"></a>
- [@Vulcalien](https://github.com/Vulcalien) - bug fixes & improvements
