scalactic-website
==================

Scalactic Official Website

# Docker

To publish docker image locally: 

```
> sbt docker:publishLocal
```

To run published local docker image: 

```
docker container run --publish 9000:9000 --detach --name scalactic-website.svc artima/scalactic-website
```