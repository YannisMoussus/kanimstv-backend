# Derived from official mysql image
FROM postgres:14.2

RUN localedef -i fr_FR -c -f UTF-8 -A /usr/share/locale/locale.alias fr_FR.UTF-8
ENV LANG fr_FR.utf8

COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

RUN chown -R postgres:postgres /var/lib/postgresql/data \
  && chmod -R 777 /var/lib/postgresql/data
