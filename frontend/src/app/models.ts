// models.ts

// src/app/models/account.model.ts

  export interface Account {
    receiverId?: number;
    id?: number;
    firstName: string;
    lastName: string;
    document: string;
    balance?: number;
    email: string;
    password: string;
  }
  
  export interface Deposit {
    receiverId: number;
    amount: number;
    obText: string;
  }
  
  export interface Withdrawal {
    receiverId: number;
    amount: number;
    obText: string;
  }
  
  export interface Transfer {
    senderId: number;
    receiverId: number;
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
  