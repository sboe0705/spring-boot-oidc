#!/bin/bash
docker compose up -d

interval=10
timeout=5
retries=5
start_period=10

echo "[INFO]  Waiting for Keycloak to start ..."
sleep $start_period
iteration=0
while [ $iteration -lt $((retries)) ]; do
  curl --head -f --max-time $timeout http://localhost:9000/health/ready > /dev/null 2>&1 && echo "[INFO]  Keycloak started successfully!" && exit 0
  iteration=$((iteration + 1))
  sleep $interval
done
echo "[ERROR] Keycloak start failed! Use \"docker compose up\" to see the logs."
exit 1
