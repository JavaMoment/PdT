FROM container-registry.oracle.com/database/express:latest

ENV ORACLE_PWD=igotthepower

ADD sql/startup/*.sql /opt/oracle/scripts/startup
ADD sql/setup/*.sql /opt/oracle/scripts/setup

EXPOSE 1521