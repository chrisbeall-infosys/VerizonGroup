import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelerHomeComponent } from './traveler-home.component';

describe('TravelerHomeComponent', () => {
  let component: TravelerHomeComponent;
  let fixture: ComponentFixture<TravelerHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelerHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
