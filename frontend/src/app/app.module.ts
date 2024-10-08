import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module'; 
import { AppComponent } from './app.component';
import { AccountManagementComponent } from './account-management/account-management.component';
import { StatementComponent } from './statement/statement.component';
import { HttpClientModule } from '@angular/common/http'; 
import { ApiService } from './services/api.service';

@NgModule({
  declarations: [
    AppComponent,
    AccountManagementComponent,
    StatementComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule, 
    FormsModule, 
    HttpClientModule 
  ],
  providers: [ApiService], 
  bootstrap: [AppComponent]
})
export class AppModule { }
