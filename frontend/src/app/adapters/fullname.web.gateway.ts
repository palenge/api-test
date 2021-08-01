import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { FullName } from '../domain/fullname';
import { FullNameGateway } from '../domain/gateways/fullname.gateway';

@Injectable()
export abstract class FullNameWebGateway implements FullNameGateway {
  private PREFIX = 'full_name';

  constructor(private http: HttpClient) {}

  public getLast(): Observable<FullName> {
    return this.http.get<FullName>(`${environment.SERVER_URL}/${this.PREFIX}`);
  }

  public generate(): Observable<FullName> {
    return this.http.get<FullName>(`${environment.SERVER_URL}/${this.PREFIX}?generate=true`);
  }
}
