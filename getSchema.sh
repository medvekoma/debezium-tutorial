set -eu
SUBJECT=$1
VERSION=$2
echo "Subject: ${SUBJECT}"
echo "Version: ${VERSION}"

function cutFirstLastQuote {
	sed -e "s/^.//"|sed -e "s/.$//"
}

curl -X GET http://localhost:8081/subjects/${SUBJECT}/versions/${VERSION} |jq .schema|xargs -0 printf| cutFirstLastQuote |jq .
