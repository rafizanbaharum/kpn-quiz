export CLUSTER_HOME=/app/cluster

for i in {0..9}
do
rm -rf $CLUSTER_HOME/t$i/logs/*
done
