set JAVA_HOME = C:\Program Files\Java\jdk-16.0.2
set M2_HOME = C:\Program Files\apache-maven-3.8.2
set PATH = %PATH%;%JAVA_HOME%\bin;%M3_HOME%\bin
mvn clean install
./mvn spring-boot:run

