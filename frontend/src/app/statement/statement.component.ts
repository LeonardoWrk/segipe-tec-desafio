import { Component } from '@angular/core';
import { ApiService } from 's/src/app/services/api.service';
import { Account, Deposit, Withdrawal, Transfer, Transaction, User } from 's/src/app/models'; // Aqui você importa as interfaces
@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html'
})
export class StatementComponent {
  accountId: number = 0;
  transactions: Transaction[] = [];

  constructor(private apiService: ApiService) { }

  getStatement(): void {
    this.apiService.getStatement(this.accountId).subscribe(transactions => this.transactions = transactions);
  }
}
