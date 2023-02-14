import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { VotingComponent } from './voting/voting.component';
import { RegisterVotingComponent } from './register-voting/register-voting.component';

const appRoutes : Routes = [
  { path: 'voting', component: VotingComponent },
  { path: 'register-voting', component: RegisterVotingComponent },
  { path: '', redirectTo: '/voting', pathMatch: 'full' }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }   
    ),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}