# Assignment

[Click here to read the assignment](./docs/assignment.md)

## ClipBoardHealthAssessment

The suite is built on BDD framework using Cucumber , Java and Selenium. Most of the code segments provided in vanilla framework are reused.

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

## Getting Started

For easiest way to getting started, extract this project and open it from Eclipse.

1.Open the src/test/java/amazon/runner/TestRunner.java file and run as Junit test.

2.Open the file target/cucumber-reports/index.html in Chrome or other browsers to view the report

## Architecture
The following files are retained from the vanilla framework as utilities to select and configure application environment, browser , host
1. amazon.choices 
2. amazon.config 
3. amazon.factories 
4. src/main/resources

The following packages/files are added for the new framework.

1.amazon.helper

1.1. PageHelper.java - utilities for page level functions

1.2. VerificationHelper.java - utilities for verifying expected results.The static texts to be verified are entered in src/test/resources/Properties/verification.properties file.
 VerificationHelper.java fetches the static texts for any attribute to be verified.

2.amazon.pages
 For each page , a Java class is created to hold the web elements
 
3.amazon.runner
 This has the class to run the suite
 
4.amazon.stepdef
 The step definitions for the scenarioes are added in stepdef file. The features are added in the src/test/resources/Feature folder
 
5.logs/output.log -- The log statements are stored here.The 'About this Item ' description is logged to the output.log file.

## Success
