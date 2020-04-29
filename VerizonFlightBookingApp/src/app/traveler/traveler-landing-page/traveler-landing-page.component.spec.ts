import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelerLandingPageComponent } from './traveler-landing-page.component';

describe('TravelerLandingPageComponent', () => {
  let component: TravelerLandingPageComponent;
  let fixture: ComponentFixture<TravelerLandingPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelerLandingPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelerLandingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
