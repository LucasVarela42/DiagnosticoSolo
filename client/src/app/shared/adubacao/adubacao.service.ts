import { Diagnostico, Laudo } from './adubacao.model';
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

  public get(id: string): Observable<Diagnostico> {
    return this.http.get(`${this.api}/${id}`).map((response: Diagnostico) => response);
  }

  public add(laudo: Laudo): Observable<string> {
    return this.http.post(this.api, laudo).map((response: Diagnostico) => response.id);
  }

  public update(diagnostico: Diagnostico): Observable<string> {
    return this.http.put(`${this.api}/${diagnostico.id}`, diagnostico).map((response: Diagnostico) => response.id);
  }

  public delete(body: any): Observable<boolean> {
    return this.http.request('delete', `${this.api}`, { body }).map((response: boolean) => response);
  }

}
