FROM openjdk:8
COPY ./src /usr/src/app
WORKDIR /usr/src/app
RUN javac com/igor/*.java
RUN jar cfe BalancedBrackets.jar com.igor.BalancedBrackets com/igor/*.class
CMD ["java", "-jar", "BalancedBrackets.jar"]