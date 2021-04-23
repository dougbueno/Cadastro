Sistema de Cadastro de Pessoas
===================

Exemplo de sistema de Cadastro:
IDE: Eclipse.
Postman
Git
BackEnd: Java - SpringBoot
FrontEnd: Angular 8
Banco de Dados: Postgres.

## Funcionalidades.
1.  Listagem de Todos os CPF cadastrados.
2.	Buscar por CPF.
3.	Listagem de todos os CPF cadastrados.
4.	Deletar um CPF do cadastro.
5.	Atualizar dados de um CPF cadastrado.
  
  EndPoints BackEnd:
	- buscarTodosCadastros: http://localhost:8080/api/cadastro/list
	- buscarCadastroPorCpf: http://localhost:8080/api/cadastro/id/cpf
	- salvarCadastro: http://localhost:8080/api/cadastro/save
	- deleteCadastro: http://localhost:8080/api/cadastro/delete/cpf
	- putNutricionista: http://localhost:8080/api/cadastro/put/cpf
