# Database Analytics

## Open in IntelliJ

* Open Intellij and have Gradle plugin installed
* Click on File>New>Project From Existing Sources
* Select build.gradle in the root directory

* Download Oracle JDBC Driver
* Open Open the Project Structure dialog (Ctrl+Shift+Alt+S or File->Project Structure)
* Add ojdbc6.jar to Libraries


## Run Configuration
test

## Update Databse
* This Project uses liquidbase to keep the integration Test Database current.
* Reset the Integration Test Database with: $ gradlew dropAll
* Update the Integration Test Database with: $ gradlew update

## Gradle Targets
Usefule Gradle targets are:
### Build
* Build with: gradle build
* Clean with: gradle clean
### Integration Test
* Liquibase upgrade: gradle upgrade
### IDE
* Generate IntelliJ IDEA project: gradle idea
* Clean IntelliJ IDEA project: gradle ideaClean
### Report
* Serenity-BDD Report (Report in target/site/serenity): gradle clean test aggregate
* Clear Serenity-Reports: gradle clearReports