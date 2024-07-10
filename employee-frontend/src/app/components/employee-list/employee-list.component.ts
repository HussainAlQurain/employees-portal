import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Employee } from '../../types/employee';
import { EmployeeService } from '../../services/employee.service';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ConfirmationDialogComponent } from '../../confirmation-dialog/confirmation-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatButtonModule, MatSortModule, MatInputModule, MatFormFieldModule, RouterLink, ConfirmationDialogComponent],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.scss'
})
export class EmployeeListComponent implements OnInit, AfterViewInit {

  @ViewChild(MatSort, {static: false}) sort: MatSort | null = null;

  employees: MatTableDataSource<Employee> = new MatTableDataSource<Employee>([]);
  displayedColumns: string[] = ['fname', 'lname', 'phone', 'email', 'salary', 'actions'];
  
  constructor(private employeeService: EmployeeService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe((employees) => {
      this.employees.data = employees;
      this.employees.sort = this.sort;
      console.log(this.employees.sort)
    });
  }
  ngAfterViewInit() {
    this.employees.sort = this.sort;
  }

  deleteEmployee(id: number): void {
    const employee = this.employees.data.find(e => e.id === id);
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '700px',
      data: { message: `Are you sure you want to delete employee:`, details: employee }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.employeeService.deleteEmployee(id).subscribe(() => {
          this.employees.data = this.employees.data.filter((employee) => employee.id !== id);
        });
      }
    });
  }


  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.employees.filter = filterValue.trim().toLowerCase();
  }

}
