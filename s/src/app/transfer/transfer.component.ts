import { Component } from '@angular/core';
import { ApiService } from '../../../../s/src/app/services/api.service';
import { Account, Deposit, Withdrawal, Transfer, Transaction, User } from '../../../../s/src/app/models'; // Aqui você importa as interfaces
@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html'
})
export class TransferComponent {
  transfer: Transfer = { sourceAccountId: 0, destinationAccountId: 0, amount: 0, obText: '' };

  constructor(private apiService: ApiService) { }

  makeTransfer(): void {
    this.apiService.makeTransfer(this.transfer).subscribe();
  }
}
