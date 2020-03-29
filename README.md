scalactic-website
==================

Scalactic Official Website

# Docker

Update version in build.sbt, then publish docker image locally: 

```
> sbt docker:publishLocal
```

Optionally, you can run published local docker image (please replace APP_SECRET value): 

```
docker container run artima/scalactic-website:latest
```

```
docker container run --env APP_SECRET=testing --publish 9000:9000 --detach --name scalactic-website.svc 434855870045.dkr.ecr.us-east-1.amazonaws.com/artima/scalactic-website
```