# Game Score  
###### Projeto Back-end para mini jogo
Este projeto tem como objetivo a criação back-end de um mini-jogo baseado em HTTP em Java
que registre pontos de pontuação para diferentes usuários, com a capacidade de retornar a posição atual do usuário e a lista de pontuações mais altas.



## Tecnologias

- Java JDK 8   -> https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- Gradle       -> https://docs.gradle.org
- Swagger      -> https://swagger.io/
- SpringBoot   -> https://spring.io/projects/spring-boot
- Simple Logging Facade for Java (SLF4J) -> http://www.slf4j.org/



## Executando e Testando o Projeto"
Faça um Donwload ou Clone o projeto atraves do botão *Clone or Download* 

Importe para sua IDE de preferencia.

Para gerenciar as depencias, este projeto utiliza o *Gradle*, como citado a cima.

Após as depencias instaladas execute o projeto através da classe main: **ApplicationMain**

Por padrão o projeto esta configurado para executar na porta **8091**.

Basta digitar a Url *http://localhost:8091/swagger-ui.html#/*

O Swagger já esta pronto para os testes, cliquem em game-controller, para acessar os end-points.

Clique em um dos end-points e em seguida clique no botao **try it out**.

Preencha os payloads (dados do jogador), caso seja obrigatorio, e clique em **Execute**

## Serviços


|   End-Point                 |  Metodo |  Payload                  |  Tipo de Retorno                                                |
|-----------------------------|---------|---------------------------|-----------------------------------------------------------------|
| /v1/game/score              |  POST   |{ "score": 0,<br> "userId": 0 }| Não possui retorno                                              |
| /v1/game/highscorelist      |  GET    | Não Possui                | Lista de Objetos Json <br> [{"position": 0, "score": 0,"userId": 0}]|	
| /v1/game/{userId}/position  |  GET    | {"userId": 0}             | Objeto  Json    {"position": 0, "score": 0,"userId": 0}         |	


  
  
  **Contato**
* leonardobarrosbhz@gmail.com 
  
