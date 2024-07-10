import { Routes } from '@angular/router';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { EmployeeAddComponent } from './components/employee-add/employee-add.component';
import { EmployeeEditComponent } from './components/employee-edit/employee-edit.component';
import { EmployeeViewComponent } from './components/employee-view/employee-view.component';

export const routes: Routes = [
    { path: '', component: EmployeeListComponent},
    { path: 'add', component: EmployeeAddComponent},
    { path: 'edit/:id', component: EmployeeEditComponent },
    { path: 'view/:id', component: EmployeeViewComponent },
];
