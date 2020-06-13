import {Component} from '@angular/core';
import {Products} from './products';

@Component({
	selector: 'product-form',
	templateUrl: './productsFromComponent.html',
})

export class productsFromComponent {
		// binding
		model  = new Products(1, 'iphone', 'DBG01', 3, 'IN');

		productId = this.model.ProductID;
		productName = this.model.ProductName;
		movieId = this.model.movieId;
		ratings = this.model.ratings;
		zone = this.model.zone;
		

}