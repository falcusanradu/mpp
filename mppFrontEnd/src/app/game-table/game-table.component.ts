import {Component, OnInit} from '@angular/core';
import {BackendService} from '../backend.service';
import {Game} from './interfaces';

@Component({
  selector: 'app-game-table',
  templateUrl: './game-table.component.html',
  styleUrls: ['./game-table.component.css']
})
export class GameTableComponent implements OnInit {

  games: Game[];

  constructor(private backendService: BackendService) {
  }

  ngOnInit() {
    this.backendService.getAll().subscribe(response =>
      this.games = response
    );
  }

}
