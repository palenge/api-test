import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { LastNameGateway } from '../domain/gateways/lastname.gateway';
import { LastName } from '../domain/lastname';

@Injectable()
export abstract class LastNameWebGateway implements LastNameGateway {
  private PREFIX = 'last_name';

  constructor(private http: HttpClient) {}

  public getlist(): Observable<LastName[]> {
    return this.http.get<LastName[]>(`${environment.SERVER_URL}/${this.PREFIX}`);
  }

  public insert(lastName: LastName): Observable<LastName> {
    return this.http.post<LastName>(`${environment.SERVER_URL}/${this.PREFIX}`, lastName);
  }

  public delete(id: number): Observable<LastName> {
    return this.http.delete<LastName>(`${environment.SERVER_URL}/${this.PREFIX}/${id}`);
  }
}
