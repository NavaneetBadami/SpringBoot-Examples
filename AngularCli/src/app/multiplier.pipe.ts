import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'custMultiplier'})

export class MultiplierPipe implements PipeTransform {
    // Multiplication
    // transform(value: number, multiply: string) : number{
    //     let mul =  parseFloat(multiply);
    //     return mul * value;
    // }

    // Addtion
    transform(value: number, addition: string) : number{
        let add =  parseFloat(addition); // parse float
        return add + value;
    }
}