import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { Account, Deposit, Transaction, Transfer, Withdrawal } from '../models';  // Importe o modelo da conta

@Component({
  selector: 'app-account-management',
  templateUrl: './account-management.component.html',
  styleUrls: ['./account-management.component.css']
})
export class AccountManagementComponent implements OnInit {
  
  accounts: Account[] = [];
  transactions: Transaction[] = [];
  newAccount: Account = {  // Inicializando o newAccount com propriedades vazias
    firstName: '',
    lastName: '',
    document: '',
    balance: 0,
    email: '',
    password: ''
  };

  selectedAccount: Account = { id: 0, firstName: '', lastName: '', document: '', balance: 0, email: '', password: ''}; 
  // Inicialização // Conta selecionada para edição
  depositData: Deposit = {
    receiverId: 0, // Mude para accountId
    amount: 0,    // Mude para amount
    obText: ''
  };// Estado para controlar se estamos em modo de edição

  withdrawData: Withdrawal = {
    receiverId: 0, // Mude para accountId
    amount: 0,    // Mude para amount
    obText: ''
  };

  transferData: Transfer = {
    senderId: 0,
    receiverId: 0, // Mude para accountId
    amount: 0,    // Mude para amount
    obText: ''
  }

  isEditing: boolean = false;
  showDepositForm: boolean = false;
  showDepositForm2: boolean = false;
  showDepositForm3: boolean = false;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getAccounts();
  }

  getAccounts(): void {
    this.apiService.getAccounts().subscribe(accounts => {
      this.accounts = accounts; // Dentro do subscribe, garantimos que o log é feito após os dados serem carregados
    });
  }// Alteração para refletir que é um array de arrays
 
  getStatement(id: number | undefined): void {
    if (id !== undefined) {
      this.apiService.getStatement(id).subscribe({
        next: (transactions: Transaction[]) => {
          this.transactions = transactions;
          console.log("Transações:", this.transactions);
        },
        error: (error) => {
          console.error("Erro ao obter transações:", error);
        },
        complete: () => {
          console.log("Requisição completa.");
        }
      });
    } else {
      console.error('ID is undefined');
    }
  }

  addAccount(): void {
    this.apiService.addAccount(this.newAccount).subscribe(() => {
      this.getAccounts();
      this.resetForm(); // Limpa o formulário após adicionar
    });
  }

  deleteAccount(id: number | undefined): void {
    if (id !== undefined) { // Verifique se id está definido
      this.apiService.deleteAccount(id).subscribe(() => this.getAccounts());
    } else {
      console.error('ID is undefined, cannot delete account');
    }
  }
  
  editAccount(account: Account): void {
    this.selectedAccount = { ...account }; // Cria uma cópia do objeto para edição
    this.isEditing = true; // Define que estamos no modo de edição
  }

  updateAccount(): void {
    if (this.selectedAccount) {
      // Chama o serviço para atualizar a conta
      this.apiService.updateAccount(this.selectedAccount).subscribe({
        next: () => {
          this.getAccounts(); // Atualiza a lista de contas após a edição // Reseta após a atualização
          this.isEditing = false; // Reseta o estado de edição
          alert('Conta atualizada com sucesso!'); // Mensagem de sucesso (opcional)
        },
        error: (err) => {
          console.error('Erro ao atualizar conta', err);
          alert('Erro ao atualizar a conta. Tente novamente mais tarde.'); // Mensagem de erro (opcional)
        }
      });
    }
  }

  cancelEdit(): void {
    // Cancela a edição
    this.isEditing = false; // Reseta o estado de edição
  }


  resetForm(): void {
    this.newAccount = {  // Reseta o objeto newAccount para valores vazios
      firstName: '',
      lastName: '',
      document: '',
      balance: 0,
      email: '',
      password: ''
    };
  }

  makeDeposit(): void {
    if (this.depositData.receiverId && this.depositData.amount > 0) {
      this.apiService.makeDeposit(this.depositData).subscribe(response => {
          alert('Depósito realizado com sucesso!');
          this.resetDepositForm(); 
          this.getAccounts();
      }, error => {
          console.error('Erro ao realizar depósito:', error);
          alert('Erro ao realizar depósito. Verifique os dados.');
      });
  } else {
      alert('Por favor, preencha todos os campos corretamente.');
  }
}

  selectForDeposit(): void {
    // this.selectedAccount = account;// Atribui corretamente o ID da conta
    this.showDepositForm = true; // Mostra o formulário de depósito
    this.showDepositForm2 = false;
    this.showDepositForm3 = false;
  }

  makeWithdraw(): void {
    if (this.withdrawData.receiverId && this.withdrawData.amount > 0) {
      this.apiService.makeWithdrawal(this.withdrawData).subscribe(response => {
          alert('saque realizado com sucesso!');
          this.resetDepositForm2();
          this.getAccounts();
      }, error => {
          console.error('Erro ao realizar saque:', error);
          alert('Erro ao realizar saque. Verifique os dados.');
       });
    } else {
      alert('Por favor, preencha todos os campos corretamente.');
    }
  }

  makeTransfer(): void {
    if (this.transferData.senderId && this.transferData.receiverId && this.transferData.amount > 0) {
      this.apiService.makeTransfer(this.transferData).subscribe(response => {
          alert('transferencia realizado com sucesso!');
          this.resetDepositForm3();
          this.getAccounts();
      }, error => {
          console.error('Erro ao realizar transferencia:', error);
          alert('Erro ao realizar transferencia. Verifique os dados.');
       });
    } else {
      alert('Por favor, preencha todos os campos corretamente.');
    }
  }

  resetDepositForm(): void {
    this.depositData = { receiverId: 0, amount: 0, obText: '' }; // Reseta o formulário
    // this.selectedAccount = null; // Limpa a conta selecionada
    this.showDepositForm = false; // Esconde o formulário
  }

  resetDepositForm2(): void {
    this.withdrawData = { receiverId: 0, amount: 0, obText: '' }; // Reseta o formulário
    // this.selectedAccount = null; // Limpa a conta selecionada
    this.showDepositForm2 = false; // Esconde o formulário
  }

  resetDepositForm3(): void {
    this.transferData = {senderId: 0, receiverId: 0, amount: 0, obText: '' }; // Reseta o formulário
    // this.selectedAccount = null; // Limpa a conta selecionada
    this.showDepositForm3 = false; // Esconde o formulário
  }

  selectForWithdraw(): void {
    // this.selectedAccount = account; nao entendo mais a necessidade, revisita para repensar logica
    this.showDepositForm = false;
    this.showDepositForm3 = false;
    this.showDepositForm2 = true; // Mostra o formulário de depósito
  }

  selectForTransaction(): void {
    // this.selectedAccount = account;// Atribui corretamente o ID da conta
    this.showDepositForm = false;
    this.showDepositForm2 = false;
    this.showDepositForm3 = true; // Mostra o formulário de depósito
  }

}
