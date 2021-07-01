import { Component, OnInit } from '@angular/core';
import { getMaxListeners } from 'process';
import { Employee } from "../employee";
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];

  constructor() {
    this.employees =[];
  }

  ngOnInit(): void {
    this.employees = [{
      "id": 1,
      "firstName": "田中",
      "lastName":  "太郎",
      "emailId": "test@gmail.com"
    },
    {
      "id": 2,
      "firstName": "山田",
      "lastName": "花子",
      "emailId": "simple@gmail.com"
    }]
  }

}
