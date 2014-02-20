export CLUSTER_HOME=/app/cluster

for i in {0..9}
do
rm -rf $CLUSTER_HOME/t$i/webapps/ROOT
cp -v /app/GitHub/kpn-quiz/kpn-quiz-hub/target/ROOT.war $CLUSTER_HOME/t$i/webapps/.
done
