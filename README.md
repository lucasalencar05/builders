# Builders - Spring - Docker
* No terminal dentro do seu projeto maven gere um jar da sua aplicação.
    * ```./mvnw clean package -DskipTests```
* Gere a imagem com ```docker build -t [name-for-your-image] . ```
* Execute o ambiente com: ```docker run -p [your-port]:8080 [name-for-your-image]```