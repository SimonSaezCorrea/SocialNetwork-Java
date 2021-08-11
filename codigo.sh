#!/bin/bash

javac -d Codigo/src/main/java/Codigo/ Codigo/src/main/java/Codigo/*.java

java -classpath Codigo/src/main/java/Codigo Codigo.Main
