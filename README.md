# README - Sistema de CRUD para Concessionária
Este projeto é um sistema de CRUD (Create, Read, Update, Delete) para uma concessionária, desenvolvido em Java com o framework Spring Boot. O objetivo é gerenciar informações sobre carros, concessionárias, funcionários e clientes.

Resumo do Projeto
O sistema possui quatro principais entidades:

Carro: Representa as informações de um carro, incluindo marca, modelo, cor e ano.

Concessionária: Representa uma concessionária, contendo informações sobre o nome, proprietário, uma lista de carros associados e uma lista de clientes.

Funcionário: Representa um funcionário da concessionária, com detalhes como nome, cargo e salário.

Cliente: Representa um cliente da concessionária, incluindo informações como nome, CPF, idade e uma lista de carros associados.

Funcionalidades
O sistema oferece as seguintes funcionalidades:

Carro: CRUD para carros, permitindo adicionar, listar, atualizar e excluir informações sobre os carros.

Concessionária: CRUD para concessionárias, possibilitando adicionar, listar, atualizar e excluir informações sobre as concessionárias. Cada concessionária tem uma lista de carros e clientes associados a ela.

Funcionário: CRUD para funcionários, permitindo adicionar, listar, atualizar e excluir informações sobre os funcionários. Cada funcionário pode estar associado a uma concessionária.

Cliente: CRUD para clientes, permitindo adicionar, listar, atualizar e excluir informações sobre os clientes. Cada cliente pode estar associado a uma concessionária e tem uma lista de carros associados.

Estrutura do Projeto
Entidades Java: As entidades Carro, Concessionária, Funcionário e Cliente são representadas por classes Java com anotações JPA para mapeamento de entidades.

Controladores (Controllers): Controladores Spring Boot para manipular as requisições HTTP relacionadas a carros, concessionárias, funcionários e clientes.

Repositórios: Utilização de interfaces de repositório Spring Data JPA para interagir com o banco de dados.
