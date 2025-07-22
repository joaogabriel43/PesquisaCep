# BuscaCEP-CLI ☕

![Java CI with Maven](https://img.shields.io/github/actions/workflow/status/joaogabriel43/PesquisaCep/maven.yml?branch=main&logo=github&style=for-the-badge)
![License](https://img.shields.io/github/license/joaogabriel43/PesquisaCep?style=for-the-badge)
![Java Version](https://img.shields.io/badge/java-17%2B-orange?style=for-the-badge&logo=java)
![Version](https://img.shields.io/badge/version-v1.0.0-blue?style=for-the-badge)

> Uma ferramenta de linha de comando (CLI) simples e eficiente, escrita em Java, para consultar endereços a partir de um CEP e salvar os resultados em um arquivo JSON.


---

### Tabela de Conteúdos
* [Sobre o Projeto](#sobre-o-projeto)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Começando](#começando)
    * [Pré-requisitos](#pré-requisitos)
    * [Instalação](#instalação)
* [Uso](#uso)
* [Contribuição](#contribuição)
* [Licença](#licença)
* [Contato](#contato)

---

### Sobre o Projeto

O **BuscaCEP-CLI** nasceu como um projeto de estudo para aplicar conceitos modernos de Java e boas práticas de engenharia de software. O objetivo é fornecer uma interface de linha de comando direta e sem complicações para que desenvolvedores e usuários possam rapidamente buscar informações de endereço de um CEP brasileiro e armazenar esses dados de forma estruturada.

O projeto demonstra:
* Consumo de APIs externas (`ViaCEP`).
* Manipulação e persistência de dados em formato JSON.
* Uma estrutura de aplicação de console interativa e robusta.

---

### Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Maven](https://img.shields.io/badge/Maven-4.0.0-blue?style=for-the-badge&logo=apache-maven)
![Gson](https://img.shields.io/badge/Gson-2.10-blue?style=for-the-badge&logo=google)

---

### Começando

Para executar o projeto localmente, siga os passos abaixo.

#### Pré-requisitos
Antes de começar, certifique-se de que você tem os seguintes softwares instalados:
* JDK 17 ou superior
* Apache Maven

#### Instalação

1.  Clone o repositório:
    ```sh
    git clone [https://github.com/joaogabriel43/PesquisaCep.git](https://github.com/joaogabriel43/PesquisaCep.git)
    ```
2.  Navegue até o diretório do projeto:
    ```sh
    cd PesquisaCep
    ```
3.  Compile o projeto e instale as dependências com o Maven:
    ```sh
    mvn clean install
    ```
---

### Uso

Após a compilação, você pode executar a aplicação a partir da linha de comando. O arquivo `.jar` executável estará no diretório `target/`.

Execute o seguinte comando na raiz do projeto:
```sh
java -jar target/PesquisaCep-1.0-SNAPSHOT.jar