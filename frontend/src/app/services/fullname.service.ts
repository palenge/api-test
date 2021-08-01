import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FullName } from '../domain/fullname';
import { FullNameGateway } from '../domain/gateways/fullname.gateway';

@Injectable({
  providedIn: 'root',
})
export class FullNameService {
  constructor(private fullNameGateway: FullNameGateway) {}

  public getLast(): Observable<FullName> {
    return this.fullNameGateway.getLast();
  }

  public generate(): Observable<FullName> {
    return this.fullNameGateway.generate();
  }
}
