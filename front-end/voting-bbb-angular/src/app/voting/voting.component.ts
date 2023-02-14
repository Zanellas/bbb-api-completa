import { Component, OnInit } from '@angular/core';
import { Participant } from '../model/participant';
import { RestService } from '../service/rest-service.service';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.scss']
})
export class VotingComponent implements OnInit {
  

  title = 'Votação BBB 22';
  participants: Participant[] | undefined;

  constructor(private restService : RestService) {}

  ngOnInit(): void {
    this.getParticipants();
  }

  getParticipants() {
    this.restService.getData('/participants/all').subscribe((participants) => {
      this.participants = participants;
    }) ;
  }

}
