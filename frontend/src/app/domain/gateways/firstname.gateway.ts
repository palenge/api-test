import { Observable } from 'rxjs';
import { FirstName } from '../firstname';

export abstract class FirstNameGateway {
  public abstract getlist(): Observable<FirstName[]>;
  public abstract insert(firstName: FirstName): Observable<FirstName>;
  public abstract delete(ind: number): Observable<FirstName>;
}
