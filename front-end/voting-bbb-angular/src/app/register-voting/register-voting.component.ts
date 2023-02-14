import { Participant } from './../model/participant';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';


import { RestService } from '../service/rest-service.service';

@Component({
  selector: 'app-register-voting',
  templateUrl: './register-voting.component.html',
  styleUrls: ['./register-voting.component.scss']
})
export class RegisterVotingComponent implements OnInit {

  title = 'Voto computado';
  vote = '';

  constructor(private route : ActivatedRoute,
              private restService : RestService,
              private location: Location) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.sendVote(params['id'])
    });
  }

  goBack(): void {
    this.location.back();
  }

  sendVote(id:string) {
    let request = { id : id }
    this.restService.postData('/voting', request).subscribe(response => {
      console.log(response)
      let vote = response as Participant;
      this.vote = vote.name;
    });
  }

}