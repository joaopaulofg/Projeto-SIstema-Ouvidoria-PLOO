# Sistema de Ouvidoria

Este é um sistema de ouvidoria desenvolvido em Java como projeto final da disciplina Programar em Linguagem Orientada a Objetos Básica, do curso de Análise e Desenvolvimento de Sistemas, da Unifacisa. O sistema permite aos usuários registrar manifestações, como reclamações, sugestões ou elogios, e aos administradores visualizar, pesquisar e excluir essas manifestações. O sistema utiliza Java SQL e JDBC para se conectar a um banco de dados MySQL, onde as manifestações são armazenadas.

## Funcionalidades

1. **Listagem das Manifestações**: Visualiza todas as manifestações registradas no sistema.
2. **Listagem de Manifestações por Tipo**: Lista as manifestações de acordo com o tipo selecionado (Reclamação, Sugestão ou Elogio).
3. **Criar uma Nova Manifestação**: Permite aos usuários registrar uma nova manifestação, fornecendo o tipo, nome do manifestante e descrição.
4. **Exibir Quantidade de Manifestações**: Mostra a quantidade total de manifestações registradas no sistema.
5. **Pesquisar uma Manifestação por Código**: Permite pesquisar uma manifestação específica pelo seu ID.
6. **Excluir uma Manifestação pelo Código**: Permite aos administradores excluir uma manifestação com base no seu ID.
7. **Sair do Sistema**: Encerra a execução do sistema.

## Tecnologias Utilizadas

- Linguagem de Programação: Java
- Bibliotecas: `java.sql.*`, JDBC (Java Database Connectivity)
- Banco de Dados: MySQL

## Configuração do Banco de Dados

Antes de executar o sistema, é necessário configurar o banco de dados MySQL e criar a tabela `manifestacao` com a seguinte estrutura:

```sql
CREATE TABLE manifestacao (
    idManifestacao INT AUTO_INCREMENT PRIMARY KEY,
    tipoManifestacao VARCHAR(50),
    nomeManifestante VARCHAR(100),
    manifestacao TEXT
);
```

## Utilização do Sistema

1. Clone o repositório para o seu ambiente de desenvolvimento.
2. Configure o banco de dados MySQL e a tabela `manifestacao`.
3. Compile e execute a classe `SistemaOuvidoria.java`.
4. Siga as instruções no console para acessar as diferentes funcionalidades do sistema.
5. Após cada interação, pressione qualquer tecla para continuar.

## Contribuição

Contribuições são bem-vindas! Se você encontrar bugs, problemas ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autor
Este projeto foi desenvolvido por João Paulo Ferreira Gomes.
