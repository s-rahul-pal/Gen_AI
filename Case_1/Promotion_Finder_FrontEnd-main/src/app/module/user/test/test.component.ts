import { Component,OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  valuevalue:any
  constructor() { }
  getValue(value:any){
    console.log(value.target.value);
    this.valuevalue=value.target.value;
  }

  ngOnInit(): void {
    
  }
}
