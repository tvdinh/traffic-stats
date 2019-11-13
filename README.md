## Content

The zip contains the following file/folder

1. pom.xml: Maven build file
2. src/ : All the Java source code and resource file
3. executables/WebStatApp.jar : compiled binary file, ready to use. But steps to build the app from sources code also provided
4. logs/
    4.1 programming-task-example-data.log: Given sample log
    4.2 test1.log: Extra log to test other case

## Build

### System/Tool requirements

1. Java 8
2. Maven >= 3.3.3

### Step

Build the project with maven

```
mvn clean install
```

A final jar file, named "WebStatApp.jar" produced in target/

## Run

Use the following command:

```
java -jar <path/to/WebStatApp.jar> <path/to/input_file>
```

For example:

In the root folder, run

```
java -jar executables/WebStatApp.jar logs/programming-task-example-data.log  
```

Output:

```
Web traffic statistics:
Number of Unique IP addresses:11
Top 3 active IPs - (including all IP with same rank) :
168.41.191.40 - count = 4
177.71.128.21 - count = 3
50.112.00.11 - count = 3
72.44.32.10 - count = 3
==============
Top 3 most visited url - (including all url with same rank) :
/docs/manage-websites/ - count = 2
/intranet-analytics/ - count = 1
http://example.net/faq/ - count = 1
/this/page/does/not/exist/ - count = 1
http://example.net/blog/category/meta/ - count = 1
/blog/2018/08/survey-your-opinion-matters/ - count = 1
/docs/manage-users/ - count = 1
/blog/category/community/ - count = 1
/faq/ - count = 1
/faq/how-to-install/ - count = 1
/asset.js - count = 1
/to-an-error - count = 1
/ - count = 1
/docs/ - count = 1
/moved-permanently - count = 1
/temp-redirect - count = 1
/faq/how-to/ - count = 1
/translations/ - count = 1
/newsletter/ - count = 1
/hosting/ - count = 1
/download/counter/ - count = 1
/asset.css - count = 1
COMPLETED!!!
```

Note that even though it asks for the top 3, but we also return all IPs/urls with the same rank count. In this particular case, all 3 "177.71.128.21", "50.112.00.11", "72.44.32.10" rank 2nd, and have the same count (e.g 3), so they should all be returned.

To test the case where the counts are more distinctive, a different test1.log is provided. So if run:

```
 java -jar executables/WebStatApp.jar logs/test1.log 
```

Output:

```
Web traffic statistics:
Number of Unique IP addresses:11
Top 3 active IPs - (including all IP with same rank) :
168.41.191.40 - count = 7
177.71.128.21 - count = 5
50.112.00.11 - count = 4
==============
Top 3 most visited url - (including all url with same rank) :
http://example.net/faq/ - count = 4
/intranet-analytics/ - count = 3
/docs/manage-websites/ - count = 2
/asset.css - count = 2
COMPLETED!!!
```
