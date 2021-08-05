import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { FullNameGateway } from 'src/app/domain/gateways/fullname.gateway';
import { FullName } from 'src/app/domain/fullname';

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
