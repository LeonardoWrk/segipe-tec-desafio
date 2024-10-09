
# Projeto de Gestão Bancária XYZ

## Descrição
Este projeto é uma aplicação web para a gestão de operações bancárias, incluindo cadastro de contas, depósitos, saques, transferências e visualização de extratos. O projeto é implementado usando Angular no frontend e uma API backend.

## Funcionalidades
- **Cadastro de Contas**: Consultar, incluir, alterar e excluir contas bancárias.
- **Depósito**: Registrar depósitos realizados no caixa pelo cliente.
- **Saque**: Registrar saques realizados no caixa pelo cliente, verificando saldo suficiente.
- **Transferência**: Transferir valores entre contas distintas.
- **Extrato**: Visualizar o saldo atual e todas as operações envolvendo uma conta.

## Pré-requisitos
- Node.js
- Angular CLI
- API backend em execução

## Instalação

### Passo 1: Clonar o Repositório
```bash
git clone https://github.com/usuario/projeto-banco-xyz.git
cd projeto-banco-xyz
```

### Passo 2: Instalar Dependências
```bash
npm install
```

### Passo 3: Configurar a URL da API
Abra `src/app/services/api.service.ts` e configure a URL base para a sua API:
```typescript
private baseUrl = 'https://api.exemplo.com' http://localhost:8080/api/;
```

### Passo 4: Executar a Aplicação
```bash
ng serve
```
Acesse `http://localhost:4200` no seu navegador.

## Estrutura do Projeto
```
src/
  app/
    account-management/
    deposit/
    withdrawal/
    transfer/
    statement/
    services/
      api.service.ts
    models.ts
  assets/
  environments/
  index.html
  main.ts
  ...
```

## Uso

### Cadastro de Contas
Navegue até **Cadastro de Contas** no menu de navegação. Aqui você pode adicionar, editar e excluir contas.

### Registrar Depósito
Navegue até **Depósito** no menu. Preencha o formulário com as informações da conta e valor, e clique em **Adicionar**.

### Registrar Saque
Navegue até **Saque** no menu. Preencha o formulário com as informações da conta e valor, e clique em **Adicionar**.

### Transferência
Navegue até **Transferência** no menu. Preencha o formulário com as informações da conta de origem, conta de destino e valor, e clique em **Transferir**.

### Visualizar Extrato
Navegue até **Extrato** no menu. Insira o ID da conta para visualizar todas as transações.

## Contribuição
Sinta-se à vontade para abrir um issue ou enviar um pull request para qualquer melhoria ou correção.

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
