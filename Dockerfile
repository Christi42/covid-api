FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

#RUN <<EOF
#apt-get update
#apt-get install --yes \
#git=1:2.30.2-1+deb11u2 \
#apt-get install -y apache2 \
#a2enmod rewrite \
#service apache2 restart \
#wget \
#ffmpeg \
#lsb-release
#EOF

#RUN <<EOF
#docker-php-ext-install bcmath
#docker-php-ext-install sockets
#EOF

#RUN <<EOF
#curl --silent --show-error https://getcomposer.org/installer --output /tmp/composer-setup.php
#php /tmp/composer-setup.php --install-dir=/usr/local/bin --filename=composer --version=2.6.2
#EOF

EXPOSE 8080

COPY build/libs/covid-api-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar","covid-api-0.0.1-SNAPSHOT.jar"]


#RUN composer update
#RUN composer install



