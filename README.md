# Package delivery demo

A command line program that keeps a record of packages processed.
Each package information consists of weight (in kg) and destination postal code.
Think about these packages in the same way, when you send one using postal office. 
Data are kept in memory (no database engine). 


## Installation

Standard gradle way.

### Prerequisites
Needs to run on a Java SE Runtime Environment 8. //TODO 8 or 11 ?


## Getting Started

To run the application execute command:

```
gradlew run
```

To build the executable jar run:

```
gradlew clean
gradlew fatJar
```

The jar file can be found in build/libs folder and can be run by command:

```
java -jar PackageDelivery-1.0-SNAPSHOT.jar
```


## Running the tests

To run unit tests run

```
gradlew test
```

To run integration tests run

```
gradlew intTest

```


## Author

**Martin Belas** <martin.belas@outlook.com>

