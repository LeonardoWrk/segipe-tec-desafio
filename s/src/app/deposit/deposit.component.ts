import { Component } from '@angular/core';
import { ApiService } from '../../../../s/src/app/services/api.service';
import { Account, Deposit, Withdrawal, Transfer, Transaction, User } from '../../../../s/src/app/models'; // Aqui você importa as interfaces
@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html'
})
export class DepositComponent {
  deposit: Deposit = { accountId: 0, amount: 0, obText: '' };

  constructor(private apiService: ApiService) { }

  makeDeposit(): void {
    this.apiService.makeDeposit(this.deposit).subscribe();
  }
}
