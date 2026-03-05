🧀 Sistema de Vendas - Vei Macho do Queijo

Projeto desenvolvido em Java utilizando JDBC para simular um sistema simples de vendas com gerenciamento de produtos, estoque e registro de vendas.

O objetivo do projeto é praticar conceitos de Java backend, acesso a banco de dados, arquitetura em camadas e operações CRUD.

🚀 Tecnologias utilizadas

Java

JDBC

MySQL

Maven

Git e GitHub

📁 Estrutura do projeto

O projeto foi organizado em camadas para facilitar a manutenção e organização do código.

src/main/java

app
 └ Main.java (menu interativo do sistema)

model
 ├ Produto.java
 ├ Venda.java
 └ ItemVenda.java

dao
 ├ ProdutoDAO.java
 ├ VendaDAO.java
 └ ItemVendaDAO.java

connection
 └ Conexao.java
📦 Funcionalidades do sistema

O sistema atualmente permite:

📦 Produtos

Cadastrar produto

Listar produtos

Excluir produto

🧾 Vendas

Registrar venda

Listar vendas realizadas

🗄 Banco de dados

O projeto utiliza MySQL com as seguintes tabelas:

Produto
id INT AUTO_INCREMENT
nome VARCHAR
preco DECIMAL
qtd_estoque INT
Venda
id INT AUTO_INCREMENT
data DATETIME
valor_total DECIMAL
ItemVenda
id INT AUTO_INCREMENT
venda_id INT
produto_id INT
quantidade INT
preco_unitario DECIMAL
subtotal DECIMAL
⚙️ Como executar o projeto
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git
2️⃣ Criar o banco de dados

Criar o banco no MySQL:

CREATE DATABASE vei_macho_do_queijo;

Criar as tabelas conforme descrito acima.

3️⃣ Configurar a conexão

Editar a classe:

connection/Conexao.java

Exemplo:

private static final String URL = "jdbc:mysql://localhost:3306/vei_macho_do_queijo";
private static final String USER = "root";
private static final String PASSWORD = "sua_senha";
4️⃣ Executar a aplicação

Rodar a classe:

Main.java

O sistema abrirá um menu interativo no console.

📚 Aprendizados com o projeto

Durante o desenvolvimento foram praticados:

Java orientado a objetos

JDBC

CRUD com banco de dados

PreparedStatement

Organização de projeto em camadas

Versionamento com Git

🔮 Próximas melhorias

Implementar camada Service

Atualizar estoque automaticamente após venda

Inserir múltiplos itens na venda

Criar interface gráfica

Implementar tratamento de erros mais robusto

👨‍💻 Autor

Gabriel Holanda

LinkedIn:
https://www.linkedin.com/in/gabriel-holanda-51322735b/
