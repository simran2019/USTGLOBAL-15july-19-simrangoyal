import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-general',
  templateUrl: './general.component.html',
  styleUrls: ['./general.component.css']
})
export class GeneralComponent implements OnInit {

  General:any[]=[];
  constructor(private http:HttpClient) {
    http.get<any>('https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=c944805bb2ef41488be2d7847dd013dd').subscribe((resData)=>{
      this.General=resData.articles;
      console.log(this.General)
    })
   }

  ngOnInit() {
  }

}
