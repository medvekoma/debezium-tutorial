set -eu
SUBJECT=$1
echo "Subject: ${SUBJECT}"

curl -X GET http://localhost:8081/subjects/${SUBJECT}/versions/ |jq .
