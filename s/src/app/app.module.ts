import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Importa o FormsModule
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountManagementComponent } from './account-management/account-management.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawalComponent } from './withdrawal/withdrawal.component';
import { TransferComponent } from './transfer/transfer.component';
import { StatementComponent } from './statement/statement.component';
import { HttpClientModule } from '@angular/common/http'; // Importa o HttpClientModule
import { ApiService } from './services/api.service'; // Importe o serviço

@NgModule({
  declarations: [
    AppComponent,
    AccountManagementComponent,
    DepositComponent,
    WithdrawalComponent,
    TransferComponent,
    StatementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, // Adicione o FormsModule aqui
    HttpClientModule // Importa o HttpClientModule para as chamadas de API
  ],
  providers: [ApiService], // Adicione o serviço aqui
  bootstrap: [AppComponent]
})
export class AppModule { }
