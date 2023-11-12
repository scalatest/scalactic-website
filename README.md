scalactic-website
==================

Scalactic Official Website

# Development

To run the site locally: 

```
> export APP_SECRET=12345678
> sbt run
```

# Docker

Update version in build.sbt, then publish docker image locally: 

```
> sbt docker:publishLocal
```

Optionally, you can run published local docker image (please replace APP_SECRET value): 

```
docker container run --env APP_SECRET=<replace_secret_here> --publish 9000:9000 --detach --name scalactic-website.svc artima/scalactic-website
```

To tag and push built image to GitHub Package: 

```
> ECR_IMAGE_VERSION=<replace_version_here>
> docker tag artima/scalactic-website:scalactic-$ECR_IMAGE_VERSION-ecr ghcr.io/scalatest/scalactic-website:scalactic-$ECR_IMAGE_VERSION-ecr
> docker tag artima/scalactic-website:latest ghcr.io/scalatest/scalactic-website:latest
> docker push ghcr.io/scalatest/scalactic-website:scalactic-$ECR_IMAGE_VERSION-ecr
> docker push ghcr.io/scalatest/scalactic-website:latest
```