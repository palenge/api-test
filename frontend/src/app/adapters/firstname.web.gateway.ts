import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { FirstNameGateway } from '../domain/gateways/firstname.gateway';
import { FirstName } from '../domain/firstname';

@Injectable()
export abstract class FirstNameWebGateway implements FirstNameGateway {
  private PREFIX = 'first_name';

  constructor(private http: HttpClient) {}

  public getlist(): Observable<FirstName[]> {
    return this.http.get<FirstName[]>(`${environment.SERVER_URL}/${this.PREFIX}`);
  }

  public insert(firstName: FirstName): Observable<FirstName> {
    return this.http.post<FirstName>(`${environment.SERVER_URL}/${this.PREFIX}`, firstName);
  }

  public delete(id: number): Observable<FirstName> {
    return this.http.delete<FirstName>(`${environment.SERVER_URL}/${this.PREFIX}/${id}`);
  }
}
