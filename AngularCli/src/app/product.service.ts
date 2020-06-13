import { Injectable } from '@angular/core';
import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { IProduct } from './product';

@Injectable()
export class ProductService {
   private _producturl='http://localhost:8082/ratingservice/ratings/dbg10';
   constructor(private _http: Http){}
   
   getproducts(): Observable<IProduct[]> {
      // return this._http.get(this._producturl)
      // .map((response: Response) => <IProduct[]> response.json())
      // .do(data => console.log(JSON.stringify(data)))
      // .catch(this.handleError);
      return this._http.get(this._producturl)
      .map((response: Response) => <IProduct[]> response.json())
      .do(data => console.log(JSON.stringify(data)))
      .catch(this.handleError);
   }

   getDataObservable() {
      return this._http.get(this._producturl)
          .map(data => {
              data.json();
              console.log("I CAN SEE DATA HERE: ", data.json());
              return data.json();
      }).catch(this.handleError);
  }

   private handleError(error: Response) { 
    console.error(error); 
    return Observable.throw(error.json().error()); 
 } 
}