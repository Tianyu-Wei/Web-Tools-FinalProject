import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { searchresult } from '../models/searchresult';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  getDataService(category: string, keyword: string): Observable<Array<searchresult>> {
    const httpParam = new HttpParams()
    .set('cate', category)
    .set('keyword', keyword);

    console.log(httpParam);
    return this.http.get<Array<searchresult>> (environment.api_URL + 'searchname', {params: httpParam})
  };

  getMainDataService(): Observable<Array<searchresult>> {
    return this.http.get<Array<searchresult>> (environment.api_URL);
  };

  getCategoryService(category: string): Observable<Array<searchresult>> {
    const httpParam = new HttpParams()
    .set('cate', category);

    return this.http.get<Array<searchresult>> (environment.api_URL + 'category', {params: httpParam});
  }
}
