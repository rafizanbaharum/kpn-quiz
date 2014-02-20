export CLUSTER_HOME=/app/cluster

for i in {0..9}
do
cp -v /app/GitHub/kpn-quiz/kpn-quiz-hub/target/kpn-quiz-hub.war $CLUSTER_HOME/t$i/webapps/.
done
