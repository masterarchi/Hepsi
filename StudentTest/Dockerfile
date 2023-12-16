# ilk olarak kullanılacak JDK sürümünü belirtmek gerekli
FROM amazoncorretto:19
#Jar dosyasını Docker'a kopyalama:
# 1. Yol
# COPY build/libs/Maraton5-0.0.1-SNAPSHOT.jar app.jar
# 2. Yol
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Docker'a kopyaladıığımız jar dosyaasını çalıştırma
ENTRYPOINT ["java","-jar","/app.jar"]
