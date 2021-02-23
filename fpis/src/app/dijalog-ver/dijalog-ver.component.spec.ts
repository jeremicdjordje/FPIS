import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DijalogVerComponent } from './dijalog-ver.component';

describe('DijalogVerComponent', () => {
  let component: DijalogVerComponent;
  let fixture: ComponentFixture<DijalogVerComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DijalogVerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DijalogVerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
