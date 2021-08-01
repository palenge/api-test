import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FirstName } from '../domain/firstname';
import { FirstNameGateway } from '../domain/gateways/firstname.gateway';

@Injectable({
  providedIn: 'root',
})
export class FirstNameService {
  constructor(private firstNameGateway: FirstNameGateway) {}

  public  getlist(): Observable<FirstName[]> {
    return this.firstNameGateway.getlist();
  }

  public  insert(firstName: FirstName): Observable<FirstName> {
    return this.firstNameGateway.insert(firstName);
  }

  public  delete(id: number): Observable<FirstName> {
    return this.firstNameGateway.delete(id);
  }
}
