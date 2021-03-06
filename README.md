# Package delivery demo

A command line program that keeps a record of packages processed.
Each package information consists of weight (in kg) and destination postal code.
Think about these packages in the same way, when you send one using postal office. 
Data are kept in memory (no database engine). 

The behavior of the application is slightly different from the assignment, 
the console print is performed every 10 seconds to make it clearer what is happening in the application.

There is prepared a file with packages data in /data folder. It contains about 70k records, it is read by ParcelsInfoFromFileReader
and the reading is intentionally slowed down to show how it works together with writing to the console the non-blocking way in different threads.

## Installation

Standard gradle way.

### Prerequisites
Needs to run on JRE 8 or higher.


## Getting Started

To run the application execute command:

```
gradlew run --console=plain
```
If you run the application this way, you can't provide argument with input file.

To build the executable jar run:

```
gradlew clean
gradlew fatJar
```

The jar file can be found in build/libs folder and can be run by command:

```
java -jar PackageDeliveryApp.jar
```

or you can provide a csv file with prepared packages info:

```
java -jar PackageDeliveryApp.jar inputFilePath

for example:
java -jar PackageDeliveryApp.jar ../../data/packages.csv
```


## Running the tests

To run unit tests run:

```
gradlew test
```


## Not finished yet
- Javadoc
- Integration tests
- Input validation
- Fees feature
- solve TODOs
- remove "Thread sleeping" in ParcelsInfoFromFileReader !!



## Author

**Martin Belas** <martin.belas@outlook.com>

