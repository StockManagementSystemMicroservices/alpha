FROM adoptopenjdk/openjdk11:latest
MAINTAINER Stock Management System Developers
WORKDIR /opt/app
COPY target/stock.management.system-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "stock.management.system-0.0.1-SNAPSHOT.jar"]
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 CMD curl -f http://localhost:8090/ || exit 1
