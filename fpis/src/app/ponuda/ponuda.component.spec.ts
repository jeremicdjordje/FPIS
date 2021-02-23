import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PonudaComponent } from './ponuda.component';

describe('PonudaComponent', () => {
  let component: PonudaComponent;
  let fixture: ComponentFixture<PonudaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ PonudaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PonudaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
