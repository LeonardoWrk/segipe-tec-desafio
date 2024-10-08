// models.ts
export interface Account {
    id: number;
    name: string;
    type: string; // 'Corrente' ou 'Poupança'
    balance?: number;
  }
  
  export interface Deposit {
    accountId: number;
    amount: number;
    obText: string;
  }
  
  export interface Withdrawal {
    accountId: number;
    amount: number;
    obText: string;
  }
  
  export interface Transfer {
    sourceAccountId: number;
    destinationAccountId: number;
    amount: number;
    obText: string;
  }
  
  export interface Transaction {
    id: number;
    amount: number;
    sender: User | null;
    receiver: User | null;
    timestamp: string;
    obText: string;
    type: string; // 'Deposit' ou 'Withdrawal'
  }
  
  export interface User {
    id: number;
    firstName: string;
    lastName: string;
    document: string;
    email: string;
    password: string;
    balance: number;
  }
  