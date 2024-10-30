#!/bin/bash
echo "#"
echo "# Build Docker image from JAR file"
echo "#"
if ls java/api/target/frs-core*.jar 1> /dev/null 2>&1; then
	echo "Build docker image using JAR file: " `ls java/api/target/frs-core*.jar`
    echo
else
	echo "The JAR file cannot be found - build stopped"
	echo "Re-run the script with the JAR file placed in the directory: " `pwd` java/api/target/
	echo
	exit
fi
docker build . -f Dockerfile -t compreface-dtl --build-arg SPRING_PROFILE=prod
echo
