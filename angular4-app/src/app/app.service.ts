import {Injectable} from '@angular/core';

@Injectable()
export class appService {

    serviceProperty = 'Hello World App Service';
    getApp() : string {
        return this.serviceProperty;
        }

}
