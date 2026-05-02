# CRUD Java com JDBC 

Sistema simples de CRUD com Java + MySQL utilizando JDBC.

##  Funcionalidades

- Cadastro de usuários
- Listagem de usuários
- Atualização de dados
- Deleção de usuários
- Criação de pedidos

##  Tecnologias

- Java
- MySQL
- JDBC
- IntelliJ IDEA

##  Como rodar o projeto

### 1. Configure as variáveis de ambiente

#### Windows (PowerShell)
$env:DB_URL="jdbc:mysql://localhost:3306/enterprise"
$env:DB_USER="root"
$env:DB_PASSWORD="sua_senha"

#### Linux/Mac

export DB_URL=jdbc:mysql://localhost:3306/enterprise
export DB_USER=root
export DB_PASSWORD=sua_senha


---

###  Execute o projeto

Rode a classe `Main.java`

---

##  Estrutura do projeto

- `User` → entidade
- `UserDAO` → acesso ao banco
- `Pedido` → entidade de pedidos
- `PedidoDAO` → operações de pedidos
- `Main` → interface via terminal

---

##  Aprendizados

- JDBC na prática
- CRUD completo
- Uso de PreparedStatement
- Separação de responsabilidades (DAO)
- Uso de variáveis de ambiente (segurança)

---

##  Autor

Mikael Machado
