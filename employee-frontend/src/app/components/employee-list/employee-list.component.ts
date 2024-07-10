import { Component, OnInit } from '@angular/core';
import { Employee } from '../../types/employee';
import { EmployeeService } from '../../services/employee.service';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatButtonModule],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.scss'
})
export class EmployeeListComponent implements OnInit {
  employees: MatTableDataSource<Employee> = new MatTableDataSource<Employee>([]);
  displayedColumns: string[] = ['fName', 'lName', 'phone', 'email', 'salary', 'actions'];
  
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe((employees) => {
      this.employees.data = employees;
    });
  }

  deleteEmployee(id: number): void {
    this.employeeService.deleteEmployee(id).subscribe(() => {
      if (this.employees.data) {
        this.employees.data = this.employees.data.filter((employee) => employee.id !== id);
      }
    });
  }

}
