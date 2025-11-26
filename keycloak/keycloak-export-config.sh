#!/bin/bash
docker exec keycloak /bin/bash -c "mkdir -p /opt/keycloak/data/export && /opt/keycloak/bin/kc.sh export --file /opt/keycloak/data/export/export.json --http-management-port=0 --optimized >&2 && cat /opt/keycloak/data/export/export.json" > export-$(date +"%H%M%S").json
