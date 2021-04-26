import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCarappComponent } from './home-carapp.component';

describe('HomeCarappComponent', () => {
  let component: HomeCarappComponent;
  let fixture: ComponentFixture<HomeCarappComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeCarappComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeCarappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
