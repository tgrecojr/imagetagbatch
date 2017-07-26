# ImageTagging


This is the start of a personal project of mine.  The goal of this project is to use Amazon Rekognition (fed by pictures in S3 buckets) to detect labels and faces, and then store this information in Amazon RDS for later retrieveal and search in a front end applicaiton.  

I was tired of only being able to search my pictures by directory names, and wanted to use machine learning and Amazon Rekognition to create my personal image search engine.
  
### Tech

Image Tagging makes use of:

* Spring Boot
* Spring ~~JPA~~ JDBC
* Hibernate
* Amazon RDS
* Amazon Rekognition
* Amazon S3

### Configuration

The following properties will have to be supplied to your application in order to make the application function:

* *s3.bucket* - The S3 bucket that houses your pictures
* *aws.profile* - The profile that the AWS SDK uses to get your credentials
* *rekognition.maxlabels* - The maximum number of labels to return from the AWS Rekognition service
* *rekognition.minconfidence* - The minimum confidence threshold for Rekognition labels
* *rekognition.allowedextensions* - The photo types that Rekognition supports (default) [JPG,jpg,JPEG,jpeg,PNG,png]
* *spring.datasource.url* - JDBC URL
* *spring.datasource.username* - JDBC Username
* *spring.datasource.password* - JDBC Password
* *spring.datasource.driver-class-name* - JDBC Driver Class name
* *spring.datasource.hikari.connection-timeout* - JDBC Connection pool timeout (in ms)
* *spring.datasource.hikari.maximum-pool-size* - The maximum JDBC Connection pool size

