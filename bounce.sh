#!/bin/sh

docker container stop scalactic-website.svc
docker container rm scalactic-website.svc
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website
docker pull 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website:latest
docker container run --env APP_SECRET="<replace_secret_here>" --publish 9000:9000 --detach --name scalactic-website.svc 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website:latest