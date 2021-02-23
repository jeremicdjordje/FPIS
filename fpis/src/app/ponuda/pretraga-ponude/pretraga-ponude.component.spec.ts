import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PretragaPonudeComponent } from './pretraga-ponude.component';

describe('PretragaPonudeComponent', () => {
  let component: PretragaPonudeComponent;
  let fixture: ComponentFixture<PretragaPonudeComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ PretragaPonudeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PretragaPonudeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
