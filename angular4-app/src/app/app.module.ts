import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import {AppInventory} from './inventory.component';
import {Appproduct} from './product.component';
import {NotFoundPage} from './pageNotFound.component';
import {RouterModule, Routes } from '@angular/router';
import { productsFromComponent } from './productsFromComponent';
// import {Ng2PaginationModule} from 'ng2-pagination';
import {MultiplierPipe} from './multiplier.pipe';
import { SqrtPipe } from './sqrt.pipe';

const appRoutes: Routes = [
  { path: 'ProductLink', component: Appproduct },
  { path: 'InventoryLink', component: AppInventory },
  { path: 'resetLink', component: NotFoundPage}
];

@NgModule({
  declarations: [ AppComponent, Appproduct, AppInventory, NotFoundPage, productsFromComponent, MultiplierPipe, SqrtPipe],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
