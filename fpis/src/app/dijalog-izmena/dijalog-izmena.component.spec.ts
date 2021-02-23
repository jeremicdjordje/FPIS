import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DijalogIzmenaComponent } from './dijalog-izmena.component';

describe('DijalogIzmenaComponent', () => {
  let component: DijalogIzmenaComponent;
  let fixture: ComponentFixture<DijalogIzmenaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DijalogIzmenaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DijalogIzmenaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
