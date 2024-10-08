import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
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
    return this.http.get<Account[]>(`${this.baseUrl}/accounts`);
  }

  addAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.baseUrl}/accounts`, account);
  }

  updateAccount(account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.baseUrl}/accounts/${account.id}`, account);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/accounts/${id}`);
  }

  // Depósito
  makeDeposit(deposit: Deposit): Observable<Deposit> {
    return this.http.post<Deposit>(`${this.baseUrl}/deposit`, deposit);
  }

  // Saque
  makeWithdrawal(withdrawal: Withdrawal): Observable<Withdrawal> {
    return this.http.post<Withdrawal>(`${this.baseUrl}/withdrawal`, withdrawal);
  }

  // Transferência
  makeTransfer(transfer: Transfer): Observable<Transfer> {
    return this.http.post<Transfer>(`${this.baseUrl}/transfer`, transfer);
  }

  // Extrato
  getStatement(accountId: number): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.baseUrl}/statement/${accountId}`);
  }
}
