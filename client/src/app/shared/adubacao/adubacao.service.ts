import { Diagnostico } from './adubacao.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = '//localhost:8080/';

@Injectable({
  providedIn: 'root'
})

export class AdubacaoService {
  private api: string;
  constructor(private http: HttpClient) {
    this.api = `${baseUrl}api/adubacoes`;
   }

  getAll(): Observable<any> {
    return this.http.get(`${this.api}`).map((response: any) => response);
  }

  public get(id: number): Observable<Diagnostico> {
    return this.http.get(`${this.api}/${id}`).map((response: Diagnostico) => response);
  }

  public add(diagnostico: Diagnostico): Observable<boolean> {
    return this.http.post(this.api, diagnostico).map((response: boolean) => response);
  }

  public update(diagnostico: Diagnostico): Observable<boolean> {
    return this.http.put(this.api, diagnostico).map((response: boolean) => response);
  }

  public delete(body: any): Observable<boolean> {
    console.log(body);
    return this.http.request('delete', `${this.api}`, { body }).map((response: boolean) => response);
  }

}
