export CATALINA_BASE=/app/cluster/t9
export CATALINA_HOME=/usr/local/apache-tomcat/apache-tomcat-7.0.52
export CATALINA_OPTS="-server -Xms1024m -Xmx3072m -Dorg.apache.catalina.session.StandardSession.ACTIVITY_CHECK=true"
$CATALINA_HOME/bin/startup.sh

