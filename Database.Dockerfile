FROM container-registry.oracle.com/database/express:latest

ENV ORACLE_PWD=igotthepower

ADD sql/setup/* /opt/oracle/scripts/setup

EXPOSE 1521