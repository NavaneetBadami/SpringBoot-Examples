import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// import 'rxjs/add/operator/map';
// import 'rxjs/add/operator/do';
// import 'rxjs/add/operator/catch'; 
import { IProduct } from './product';

@Injectable()
export class ProductService {
   private producturl = 'http://localhost:8082/ratingservice/ratings/dbg10';
   constructor(private http: HttpClient) {}
   
   // getproducts(): Observable<IProduct[]> {
   //    // return this.http.get(this.producturl)
   //    // .map((response: Response) => <IProduct[]> response.json())
   //    // .do(data => console.log(JSON.stringify(data)))
   //    // .catch(this.handleError);
   //    return this.http.get(this.producturl)
   //    .map((response: Response) => <IProduct[]> response.json())
   //    .do(data => console.log(JSON.stringify(data)))
   //    .catch(this.handleError);
   // }

   getDataObservable() {
      return this.http.get(this.producturl);
      //     .map(data => {
      //         data.json();
      //         console.log("I CAN SEE DATA HERE: ", data.json());
      //         return data.json();
      // }).catch(this.handleError);
  }

//   getDataObservable2() {
//    return this.http.get(this.producturl)
//        .map(data => {
//            data.json();
//            console.log("I CAN SEE DATA HERE: ", data.json());
//            return data.json();
//    }).catch(this.handleError);
// }


//    private handleError(error: Response) { 
//     console.error(error); 
//     return Observable.throw(error.json().error()); 
//  } 
}