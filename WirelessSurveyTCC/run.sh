#!/bin/bash

## CLEAN UP
# ant clean 1> /dev/null
#ant compile 

## Compile java, generate jar and then run (if successfull)
ant jar && gksu 'java -cp ./ -jar ./dist/WirelessSurveyTCC.jar'

#gksu 'java -cp ./ -jar ./dist/WirelessSurveyTCC.jar principal.TelaPrograma'
#gksu 'java -cp ./build/classes/:./ principal.TelaPrograma'
