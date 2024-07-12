# EJECUTAR DESDE NIVEL ROOT EN SERVERSIDE REPO

# Importar imagen oficial de wildfly con java 17
FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk17

LABEL org.opencontainers.image.authors="gonzalo.ruiz@estudiantes.utec.edu.uy"

# Parametros CLI
ARG dbHost=172.17.0.1
ARG dbPort=1521

# Donde vivirá Wildfly como variable
ENV JBOSS_HOME=/opt/jboss/wildfly

# Agregar usuario de admin para poder acceder a la consola de administradores
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

# Crear directorio para guardar los logs files
RUN mkdir /opt/jboss/wildfly/standalone/log

# Instalar/deployear oracle driver y datasource
RUN /bin/sh -c '$JBOSS_HOME/bin/standalone.sh &' && \
  sleep 10 && \
  cd /tmp && \
  curl --location --output ojdbc11.jar --url https://download.oracle.com/otn-pub/otn_software/jdbc/2113/ojdbc11.jar && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="deploy /tmp/ojdbc11.jar" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command="data-source add --name=PDT_DS --jndi-name=java:/PDT_DS --driver-name=ojdbc11.jar --connection-url=jdbc:oracle:thin:@${dbHost}:${dbPort}:xe --user-name=c##proyecto --password=proyecto" && \
  $JBOSS_HOME/bin/jboss-cli.sh --connect --command=:shutdown && \
  rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/ $JBOSS_HOME/standalone/log/* && \
  rm /tmp/ojdbc11.jar && \
  rm -rf /tmp/ojdbc*.jar

# Cambio de nivel de usuario a root
USER root

# Añadir nuestra aplicación a ser deployeada
ADD TecnicaturaUtec.ear /opt/jboss/wildfly/standalone/deployments/

# Cambiar ownership a jboss
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/TecnicaturaUtec.ear

USER jboss

EXPOSE 8080 9990 8009

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug", "-c", "standalone.xml"]