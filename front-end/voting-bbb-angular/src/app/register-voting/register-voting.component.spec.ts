import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterVotingComponent } from './register-voting.component';

describe('RegisterVotingComponent', () => {
  let component: RegisterVotingComponent;
  let fixture: ComponentFixture<RegisterVotingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterVotingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterVotingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
