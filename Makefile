CLASSPATH=.:/usr/share/java/junit4.jar
JAVA_CLASS=src/PriorityQueueTest.java
JUNIT4=org.junit.runner.JUnitCore

all: compile

compile:
	mkdir -p bin
	javac -cp $(CLASSPATH) $(JAVA_CLASS) -d bin

test:
	cd bin; java -cp $(CLASSPATH) $(JUNIT4) PriorityQueueTest

clean:
	rm -rf bin *.class

.PHONY: all compile test clean
