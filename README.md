A aplicacao esta preparada para fazer deploy em docker,
basta executar o comando  **mvn clean install dockerfile:build** na raiz de cada projeto


A documentacao do projeto foi feita no swagger basta acessar **http://{IP}}:8080/api/swagger-ui.html**

Foram liberadas a ulr do prometheus e actuator para as aplicacoes sejam monitoradas pelo propio promehtues e um aplicaco como o grafana


Para logs, interessante centralizar os logs com  filebeats com logstash.
