FROM container-registry.oracle.com/database/express:latest

LABEL org.opencontainers.image.authors="gonzalo.ruiz@estudiantes.utec.edu.uy"

ARG ADMIN_PWD=igotthepower
ENV ORACLE_PWD=${ADMIN_PWD}

ADD sql/startup/* /opt/oracle/scripts/startup

EXPOSE 1521