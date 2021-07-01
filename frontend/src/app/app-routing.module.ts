import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';

/**
 *​「pathMatch: 'full'」で空のパスと完全に一致するURLを、
 * パスが'/employees'であるルートにリダイレクト
 *
 * '/employees'にリクエスト送った場合のみemployeesが表示される
*/
const routes: Routes = [
  { path: 'employees', component: EmployeeListComponent },
  { path: '', redirectTo: 'employees', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
