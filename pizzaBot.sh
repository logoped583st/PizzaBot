#!/bin/bash

FILE=./PizzaBotConsole/build/libs/PizzaBotConsole-1.0-SNAPSHOT.jar
if [ ! -f "$FILE" ]; then
   ./gradlew PizzaBotConsole:jar
fi
cp $FILE ./
java -jar ./PizzaBotConsole-1.0-SNAPSHOT.jar "$@"