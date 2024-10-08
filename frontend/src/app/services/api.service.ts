import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Account, Deposit, Withdrawal, Transfer, Transaction, User } from '../models'; // Aqui você importa as interfaces
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api/'; // URL da sua API

  constructor(private http: HttpClient) { }

  // Métodos para consumir a API

  // Cadastro de Contas
  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(`${this.baseUrl}users`);
  }

  addAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.baseUrl}users`, account);
  }

  updateAccount(account: Account): Observable<Account> {
    return this.http.patch<Account>(`${this.baseUrl}users/edit/${account.id}`, account);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}users/delete/${id}`);
  }

  // Depósito
  makeDeposit(deposit: Deposit): Observable<Deposit> {
    return this.http.post<Deposit>(`${this.baseUrl}deposit`, deposit);
  }

  // Saque
  makeWithdrawal(withdrawal: Withdrawal): Observable<Withdrawal> {
    return this.http.post<Withdrawal>(`${this.baseUrl}saque`, withdrawal);
  }

  // Transferência
  makeTransfer(transfer: Transfer): Observable<Transfer> {
    return this.http.post<Transfer>(`${this.baseUrl}transactions`, transfer);
  }

  // Extrato
  getStatement(accountId: number): Observable<Transaction[]> {
    return this.http.get<{ transactions: Transaction[] }>(`${this.baseUrl}transactions/extrato/${accountId}`)
      .pipe(
        map(response => response.transactions) // Extraia a lista de transações do objeto de resposta
      );
  }
  
}
