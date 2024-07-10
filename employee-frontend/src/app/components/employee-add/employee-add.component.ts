// import { Component } from '@angular/core';
// import { Employee } from '../../types/employee';
// import { EmployeeService } from '../../services/employee.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-employee-add',
//   standalone: true,
//   imports: [],
//   templateUrl: './employee-add.component.html',
//   styleUrl: './employee-add.component.scss'
// })
// export class EmployeeAddComponent {

//   employee: Employee = {
//     fName: '',
//     lName: '',
//     phone: '',
//     email: '',
//     salary: 0
//   };

//   constructor(private employeeService: EmployeeService, private router: Router) { }

//   addEmployee(): void {
//     this.employeeService.createEmployee(this.employee).subscribe(() => {
//       this.router.navigate(['/']);
//     });
//   }

// }
