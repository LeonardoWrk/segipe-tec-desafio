import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { Account, Deposit, Withdrawal, Transfer, Transaction, User } from '../../../../s/src/app/models'; // Aqui você importa as interfaces
@Component({
  selector: 'app-account-management',
  templateUrl: './account-management.component.html'
})
export class AccountManagementComponent implements OnInit {
  accounts: Account[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getAccounts();
  }

  getAccounts(): void {
    this.apiService.getAccounts().subscribe(accounts => this.accounts = accounts);
  }

  addAccount(): void {
    const newAccount: Account = { id: 0, name: 'Novo Cliente', type: 'Corrente' }; // Exemplo de novo cliente
    this.apiService.addAccount(newAccount).subscribe(() => this.getAccounts());
  }

  editAccount(account: Account): void {
    // Implementar lógica de edição
  }

  deleteAccount(id: number): void {
    this.apiService.deleteAccount(id).subscribe(() => this.getAccounts());
  }
}
