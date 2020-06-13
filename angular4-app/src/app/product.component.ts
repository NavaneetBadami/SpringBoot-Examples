import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component ({
   selector: 'app-root',
//    template: 'Products',
templateUrl: './product.component.html',
})

export class Appproduct  {

    constructor(private _router: Router){

    }
    desc = 'Product list';

    goBack(): void {
        this._router.navigate(['/InventoryLink']); 
    }
}