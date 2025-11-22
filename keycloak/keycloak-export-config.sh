#!/bin/bash
docker exec keycloak /bin/bash -c "mkdir -p /opt/keycloak/data/export && /opt/keycloak/bin/kc.sh export --file /opt/keycloak/data/export/realm.json >&2 && cat /opt/keycloak/data/export/realm.json" > import/realm.json
