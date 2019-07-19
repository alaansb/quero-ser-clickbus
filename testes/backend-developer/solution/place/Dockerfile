FROM java:openjdk-8
WORKDIR /code
ADD pom.xml /code/pom.xml
ADD src /code/src
ADD Dockerfile /code/Dockerfile
ARG project_name
ARG project_version
COPY target/${project_name}-${project_version}.jar /code/${project_name}.jar
CMD java -jar /code/place.jar