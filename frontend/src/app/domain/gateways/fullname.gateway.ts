import { Observable } from 'rxjs';
import { FullName } from '../fullname';

export abstract class FullNameGateway {
  public abstract getLast(): Observable<FullName>;
  public abstract generate(): Observable<FullName>;
}
