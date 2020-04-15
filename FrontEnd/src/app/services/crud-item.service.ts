import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CrudItemService {

  constructor(private http: HttpClient) { }

  deleteItemService(id: string) {
    const params = new HttpParams()
    .set('id', id);

    return this.http.post(environment.api_URL + '/deleteitem', params);
  }

  updateItemService(id: string, name: string, amount: string, price: string, category: string, description: string, imgURL: string, discount: string) {
    const params = new HttpParams()
    .set('id', id)
    .set('name', name)
    .set('amount', amount)
    .set('price', price)
    .set('category', category)
    .set('description', description)
    .set('imgURL', imgURL)
    .set('discount', discount);

    return this.http.post(environment.api_URL + "updateitem", params);
  }

  createItemService(name: string, amount: string, price: string, category: string, description: string, imgURL: string, discount: string) {
    const params = new HttpParams()
    .set('name', name)
    .set('amount', amount)
    .set('price', price)
    .set('category', category)
    .set('description', description)
    .set('imgURL', imgURL)
    .set('discount', discount);

    return this.http.post(environment.api_URL + "additem", params);
  }
}
