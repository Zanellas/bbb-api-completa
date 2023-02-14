import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VotingComponent } from './voting/voting.component';
import { RegisterVotingComponent } from './register-voting/register-voting.component';

  @NgModule({
  declarations: [
    AppComponent,
    VotingComponent,
    RegisterVotingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule ,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
