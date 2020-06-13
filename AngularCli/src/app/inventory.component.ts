import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component ({
   selector: 'app-root',
//    template: 'Inventory',
    templateUrl: './inventory.component.html',
})
export class AppInventory  {
    desc = 'Inventory List';

    constructor(private _router : Router){

    }

    reset(): void{
        this._router.navigate(['/']);
    }
    
}