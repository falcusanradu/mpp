import {Component, Input, OnInit} from '@angular/core';
import {BackendService} from '../backend.service';
import {Game} from './interfaces';

@Component({
  selector: 'app-game-table',
  templateUrl: './game-table.component.html',
  styleUrls: ['./game-table.component.css']
})
export class GameTableComponent implements OnInit {

  games: Game[];
  @Input() newGame: Game = new Game();
  clicked: boolean;
  editMode: boolean;
  id: number;
  saveGameForEdit: Game;

  constructor(private backendService: BackendService) {
  }

  ngOnInit() {
    this.loadAllGames();
  }

  addNewRule() {
    this.clicked = true;
  }

  addNewGame() {
    this.backendService.createOrUpdate(this.newGame).subscribe();
    this.loadAllGames();
    this.clicked = false;
    this.newGame = new Game();
    location.reload();
  }

  edit(game) {
    this.saveGameForEdit = game;
    this.editMode = true;

  }

  update(game: any) {
    this.backendService.createOrUpdate(game).subscribe();
    this.editMode = false;
  }

  cancel() {
    this.clicked = false;
    this.newGame = new Game();
  }

  delete(game) {
    this.backendService.delte(game.id);
    location.reload();
  }

  cancelEdit(game: any) {
    game = this.saveGameForEdit;
    this.editMode = false;
  }

  searchById(){

  }

  private loadAllGames() {
    this.backendService.getAll().subscribe(resp => {
      this.games = resp;
    });
  }
}
