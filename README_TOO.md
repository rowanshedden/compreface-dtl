# Exadel CompreFace Modified for SITA DTL Integration

Main changes in the API module, plus an additional table added.

# Deployment
Generate the modified API docker image using the build-docker-image script which will generate an image called compreface-dtl.
```
cd java
sudo ./build-docker-image.sh
sudo docker images
```
Check for the image compreface-dtl

To continue ... go back to the root directory and bring up the docker instances
```
cd ..       (back to root directory)
sudo docker compose up -d
```

Once everything is up and running add the SubjectDetails table to the Postgres DB using the SubjectDetails.sql script provided in the /db folder.   

If all is successful you can login using a local browser to http://localhost:8000/login ... 
once an account is created you can set up the services and note down the api keys.

Next we have to configure the DTL relay which handles the ADD and UPDATE messages from the DTL and turns them into 
API calls to CompreFace to add and update the subjects. 

The latest build can be pulled from the Github repo.
```
cd ..
git clone https://github.com/rowanshedden/compreface-relay-service.git
```

Edit the application.yml file to contain the correct compreface-dtl-api URL and api key.
```
cd compreface-relay   
cd src/main/resources/
```

Run the build step, then run the docker compose up step.
```
mvn clean install
sudo docker compose up -d
```
