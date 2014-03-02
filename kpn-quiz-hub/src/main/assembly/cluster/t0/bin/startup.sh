#!/bin/sh
export CATALINA_BASE=/app/cluster/t0
export CATALINA_HOME=/usr/local/apache-tomcat/apache-tomcat-7.0.52
export CATALINA_OPTS="-server -Xmx2g -Xms2g -XX:MaxNewSize=512m -XX:MaxPermSize=512m  -XX:ParallelGCThreads=4 -Dorg.apache.catalina.session.StandardSession.ACTIVITY_CHECK=true"
${CATALINA_HOME}/bin/startup.sh

