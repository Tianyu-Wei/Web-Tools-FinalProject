import { Injectable } from '@angular/core';
import { searchresult } from '../models/searchresult';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FetchdataService {

  constructor(private http: HttpClient) { }

  getItemDetailService(id: string) {
    const httpParams = new HttpParams()
    .set('id', id);

    return this.http.get<Array<searchresult>> (environment.api_URL + 'detail', {params: httpParams});
  }
}
