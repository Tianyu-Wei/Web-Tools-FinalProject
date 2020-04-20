import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHandler } from '@angular/common/http';
import { searchresult } from '../models/searchresult';
import { environment } from 'src/environments/environment';
import { order } from '../models/order';
import { orderresult } from '../models/orderresult';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {

  constructor(private http: HttpClient) { }

  getCartData(username: string){
    const params = new HttpParams()
    .set('username', username);

    return this.http.post<Array<searchresult>>(environment.api_URL + 'getcart', params);
  }

  deleteCartData(username: string, id: string){
    const params = new HttpParams()
    .set('id', id)
    .set('username', username);

    return this.http.post(environment.api_URL + 'deletecart', params);
  }

  addToCart(username: string, id: string, amount: string){
    const params = new HttpParams()
    .set('username', username)
    .set('id', id)
    .set('quantity', amount);

    return this.http.post(environment.api_URL + 'addcart', params);
  }

  createOrder(username: string, id: string, amount: string){
    const params = new HttpParams()
    .set('username', username)
    .set('id', id)
    .set('amount', amount);

    return this.http.post(environment.api_URL + 'addorder', params);
  }

  getOrder(username: string){
    const params = new HttpParams()
    .set('username', username);

    return this.http.post<Array<orderresult>>(environment.api_URL + 'getorder', params);
  }

  returnOrder(orderNum: string, username: string){
    const params = new HttpParams()
    .set('ordernum', orderNum)
    .set('username', username);
    console.log(orderNum);
    console.log(username);

    return this.http.post(environment.api_URL + 'returnorder', params);
  }

  getOrderlist(username: string){
    const params = new HttpParams()
    .set('username', username);

    return this.http.post<Array<order>>(environment.api_URL + 'getorderlist', params);
  }

  approveReturn(orderNum: string, username: string){
    const params = new HttpParams()
    .set('ordernum', orderNum)
    .set('username', username);
    console.log(orderNum);
    console.log(username);

    return this.http.post(environment.api_URL + 'approvereturn', params);
  }

  getNormalOrder(username: string){
    const params = new HttpParams()
    .set('username', username);

    return this.http.post<Array<orderresult>>(environment.api_URL + 'getnormalorder', params);
  }

  getReturnOrder(username: string){
    const params = new HttpParams()
    .set('username', username);

    return this.http.post<Array<orderresult>>(environment.api_URL + 'getreturnorder', params);
  }
  
  shipOrder(username: string, orderNum: string, label: string) {
    const params = new HttpParams()
    .set('username', username)
    .set('label', label)
    .set('ordernum', orderNum);

    return this.http.post(environment.api_URL + 'shiporder', params);
  }

  rejectReturn(orderNum: string, username: string){
    const params = new HttpParams()
    .set('ordernum', orderNum)
    .set('username', username);
    console.log(orderNum);
    console.log(username);

    return this.http.post(environment.api_URL + 'rejectreturn', params);
  }

  cancelOrder(orderNum: string, username: string) {
    const params = new HttpParams()
    .set('ordernum', orderNum)
    .set('username', username);
    console.log(orderNum);
    console.log(username);

    return this.http.post(environment.api_URL + 'cancelorder', params);
  }
  

}
