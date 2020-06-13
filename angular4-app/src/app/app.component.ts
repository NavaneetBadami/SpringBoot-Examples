import { Component } from '@angular/core';
import {IProduct} from './product';
import {ProductService} from './product.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// import 'rxjs/add/operator/map';
import {appService} from './app.service';
// import {PaginatePipe, PaginationService} from 'ng2-pagination';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // template: '<product-form></product-form>',
  styleUrls: ['./app.component.css'],
  providers : [ProductService, appService]
})
export class AppComponent {
  title = 'app works!';
  myTitle = 'Looks intresting';
  appValue = ''; 
  data: any[] = [
    {
    'id': 'one',
    'name' : 'Navaneet',
  },
  {
    'id': 'Two',
    'name' : 'Navaneet2',
  }];

  iproducts: IProduct[];
  testResponse: any;
  movieId: string;
  ratings: string;
  zone: string;
  appValue2: string;
  constructor(private product: ProductService, private appservice: appService) {
   }
   // tslint:disable-next-line:use-lifecycle-interface
   ngOnInit(): void {
    //  this.product.getproducts().subscribe(iproducts => this.iproducts = iproducts);

      // getting data from App Serice
      this.appValue = this.appservice.getApp();
      this.appservice.serviceProperty = 'Hello World App Service - UPDATED';
      this.appValue2 = this.appservice.getApp();


      // getting data from  Product service
      this.product.getDataObservable().subscribe(
        data => {
          this.testResponse = data;
          console.log(' I GOT DATA HERE: ', this.testResponse);
          this.movieId = this.testResponse.ratings.movieId;
          this.ratings = this.testResponse.ratings.ratings;
          this.zone =  this.testResponse.ratings.zone;
        }
    );
   }

   appList: any[] = [{
    'ID': '1',
    Name: 'One',
    url: 'app/Images/One.jpg'
 },
 {
    ID: '2',
    Name: 'Two',
    url: 'app/Images/two.jpg'
 }];

 clickStatus: string;
 clicked(event) {
  this.clickStatus = 'Button clicked !!';
 }

 newdate = new Date(1989, 11, 21);
 newValue: number = 30;
 newValue2: number = 10;
 jsonValue = {name: 'Navi', age:'25', address:{city: 'Pune', state:'MH'}};

 months = ['January', 'Feburary', 'March', 'April', 'May',
            'June', 'July', 'August', 'September',
            'October', 'November', 'December'];

isavailable = true;
selectedMonth: string;
  changemonths(event) {
    this.selectedMonth = event.target.value;
  }

  onClickSubmit(data) {
    alert(" Entered Email id : " + data.emailid);
 }

}
