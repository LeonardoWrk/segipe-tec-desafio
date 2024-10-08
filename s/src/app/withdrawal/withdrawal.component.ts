import { Component } from '@angular/core';
import { ApiService } from '../../../../s/src/app/services/api.service';
import { Account, Deposit, Withdrawal, Transfer, Transaction, User } from '../../../../s/src/app/models'; // Aqui você importa as interfaces
@Component({
  selector: 'app-withdrawal',
  templateUrl: './withdrawal.component.html'
})
export class WithdrawalComponent {
  withdrawal: Withdrawal = { accountId: 0, amount: 0, obText: '' };

  constructor(private apiService: ApiService) { }

  makeWithdrawal(): void {
    this.apiService.makeWithdrawal(this.withdrawal).subscribe();
  }
}
