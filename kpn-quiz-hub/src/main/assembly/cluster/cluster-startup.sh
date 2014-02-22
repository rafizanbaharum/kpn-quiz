#!/bin/sh

export CLUSTER_HOME=/app/cluster

for i in {0..9}
do
    sh ${CLUSTER_HOME}/t${i}/bin/startup.sh
done
