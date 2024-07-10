import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../types/employee';

@Component({
  selector: 'app-employee-view',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './employee-view.component.html',
  styleUrl: './employee-view.component.scss'
})
export class EmployeeViewComponent implements OnInit {

  employee: Employee | null = null;


  constructor(private route: ActivatedRoute, private employeeService: EmployeeService){}

  ngOnInit(): void {
    this.getEmployeeDetails();
  }
  getEmployeeDetails(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.employeeService.getEmployeeById(id).subscribe(employee => {
      this.employee = employee;
    });
  }

}
