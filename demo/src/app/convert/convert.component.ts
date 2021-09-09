import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Data } from '../Model/data';

@Component({
  selector: 'app-convert',
  templateUrl: './convert.component.html',
  styleUrls: ['./convert.component.css']
})
export class ConvertComponent implements OnInit {
  url = ' http://localhost:8082/encode';
  data : Data;


  constructor(private httpClient : HttpClient) {
    this.data = new Data();
   }

  ngOnInit(): void {
  }

  save(){
      this.httpClient.post(this.url,this.data).subscribe(data=>{
        console.log(data);
      });
  }

}
