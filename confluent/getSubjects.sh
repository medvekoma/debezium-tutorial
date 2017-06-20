set -eu

curl -X GET http://localhost:8081/subjects |jq .
