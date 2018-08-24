# COnfiguração do JAAS e Data Source
Repositório dos projetos utilizados como exemplo na disciplina de Desenvolvimento de Aplicações Web II no curso técnico integrado em informática do IFPB Campus Esperança.

1. NÃO implante a aplicação ainda antes de realizar todas essas configurações;
2. Certifique-se que o Wildfly está executando;
3. As configurações serão feitas via linha de comando. Para isso, acessem a pasta "<WILDFLY_HOME>\bin" e executem o seguinte comando:

jboss-cli.bat

4. Execute os seguintes comandos:

connect

module add --name=org.postgres --resources="C:\Users\hugof\.m2\repository\org\postgresql\postgresql\9.4.1212\postgresql-9.4.1212.jar" --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres", driver-module-name="org.postgres", driver-class-name="org.postgresql.Driver")

/subsystem=datasources/data-source=PostgreSQLPool:add(driver-name="postgres", jndi-name="java:/ifotoDS", connection-url="jdbc:postgresql://localhost:5432/ifoto", user-name="ifotouser", password="ifotopassword")

/subsystem=security/security-domain=ifotoJdbcRealm/:add(cache-type=default)

/subsystem=security/security-domain=ifotoJdbcRealm/authentication=classic:add(login-modules=[{code=Database, flag=Required, module-options={ \
    dsJndiName="java:/ifotoDS", \
    principalsQuery="select password from usuario where username = ?", \
    rolesQuery="select grupo, 'Roles' from usuario where username = ?", \
    hashAlgorithm="SHA-256", \
    hashEncoding="base64" \
}}])

reload

quit
