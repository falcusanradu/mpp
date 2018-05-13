import {Injectable} from '@angular/core';
import {RequestOptions} from '@angular/http';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Game} from './game-table/interfaces';

export const DEFAULT_URL = 'http://localhost:8080';

@Injectable()
export class BackendService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(DEFAULT_URL + '/getAll');
  }


}
