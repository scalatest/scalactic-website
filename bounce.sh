#!/bin/sh

docker container stop scalactic-website.svc
docker container rm scalactic-website.svc
cd /home/ec2-user/
runuser -l ec2-user -c 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website'
runuser -l ec2-user -c 'docker pull 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website:latest'
runuser -l ec2-user -c 'docker container run --env APP_SECRET="8^_3k71A6luPrib>Uzg?ToZdZ6/dUP=wESeWTc/ZK[H8A;5fM^3ZNihi31;[1Lfd" --publish 9000:9000 --detach --name scalactic-website.svc 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website:latest'