import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LastNameGateway } from '../domain/gateways/lastname.gateway';
import { LastName } from '../domain/lastname';

@Injectable({
  providedIn: 'root',
})
export class LastNameService {
  constructor(private lastNameGateway: LastNameGateway) {}

  public getlist(): Observable<LastName[]> {
    return this.lastNameGateway.getlist();
  }

  public insert(firstName: LastName): Observable<LastName> {
    return this.lastNameGateway.insert(firstName);
  }

  public delete(id: number): Observable<LastName> {
    return this.lastNameGateway.delete(id);
  }
}
