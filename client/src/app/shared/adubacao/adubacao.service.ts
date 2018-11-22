import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdubacaoService {
  public API = '//localhost:8080/api';
  public ADUBACAO_API = this.API + '/adubacoes';
  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/adubacoes');
  }
  get(id: string) {
    return this.http.get(this.ADUBACAO_API + '/' + id);
  }
  save(laudo: any): Observable<any> {
    let result: Observable<Object>;
    if (laudo['href']) {
      result = this.http.put(laudo.href, laudo);
    } else {
      result = this.http.post(this.ADUBACAO_API, laudo);
    }
    return result;
  }
  remove(href: string) {
    return this.http.delete(href);
  }
}
