import {Injectable} from '@angular/core';
import {RequestOptions} from '@angular/http';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Game} from './game-table/interfaces';
import {Headers} from '@angular/http';

export const BASE_URL = 'http://localhost:8080';

@Injectable()
export class BackendService {

  // games: BehaviorSubject<Game[]> = new BehaviorSubject([]);

  headers = new Headers({'Content-Type': 'application/json'});
  options = new RequestOptions({headers: this.headers});

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    // let self = this;
    return this.http.get(BASE_URL + '/getAll');
    // this.http.get(BASE_URL + '/getAll').subscribe((resp: Game[]) => {
    //   this.games.next(resp);
    //   let a = 6;
    // });
  }

  createOrUpdate(game: Game): Observable<any> {
    return this.http.post(BASE_URL + `/create/${game.team1}/${game.team2}/${game.title}/${game.tickets}/${game.priceOfTicket}`, this.options);
  }

  delte(id) {
    this.http.delete(BASE_URL + `/delete/${id}`).subscribe();
  }

}
