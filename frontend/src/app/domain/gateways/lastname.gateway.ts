import { Observable } from 'rxjs';
import { LastName } from '../lastname';

export abstract class LastNameGateway {
  public abstract getlist(): Observable<LastName[]>;
  public abstract insert(firstName: LastName): Observable<LastName>;
  public abstract delete(ind: number): Observable<LastName>;
}
