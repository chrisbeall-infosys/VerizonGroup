import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizationErrorComponent } from './authorization-error.component';

describe('AuthorizationErrorComponent', () => {
  let component: AuthorizationErrorComponent;
  let fixture: ComponentFixture<AuthorizationErrorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizationErrorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizationErrorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
