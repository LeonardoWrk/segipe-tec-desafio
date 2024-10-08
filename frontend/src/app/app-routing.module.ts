import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountManagementComponent } from './account-management/account-management.component';
import { StatementComponent } from './statement/statement.component';

const routes: Routes = [
  { path: 'accounts', component: AccountManagementComponent },
  { path: 'statement', component: StatementComponent },
  { path: '', redirectTo: '/accounts', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
  