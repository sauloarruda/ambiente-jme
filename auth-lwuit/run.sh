#!/bin/sh
if [ "$1" = "-b" ] ; then
	mvn clean package -Dmaven.test.skip=true
fi
java -agentlib:jdwp=transport=dt_socket,address=8010,server=y,suspend=n -jar /Java/mpp-sdk/player.jar -metal /Users/jeffmor/.m2/repository/br/com/javamagazine/jme/auth-lwuit/1.0.0/auth-lwuit-1.0.0-me.jad
fi