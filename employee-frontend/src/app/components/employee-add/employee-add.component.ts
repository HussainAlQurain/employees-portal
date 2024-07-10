import { Component } from '@angular/core';
import { Employee } from '../../types/employee';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-employee-add',
  standalone: true,
  imports: [FormsModule, CommonModule, MatFormFieldModule, MatInputModule, MatInputModule, MatButtonModule],
  templateUrl: './employee-add.component.html',
  styleUrl: './employee-add.component.scss'
})
export class EmployeeAddComponent {

  employee: Employee = {
    fname: '',
    lname: '',
    phone: '',
    email: '',
    salary: 0
  };

  constructor(private employeeService: EmployeeService, private router: Router) { }

  addEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe(() => {
      this.router.navigate(['/']);
    });
  }

}
