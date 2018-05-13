import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {GameTableComponent} from './game-table/game-table.component';
import {BackendService} from './backend.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';


@NgModule({
  declarations: [
    AppComponent,
    GameTableComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
  ],
  providers: [HttpClient, BackendService,],
  bootstrap: [AppComponent]
})
export class AppModule {
}
