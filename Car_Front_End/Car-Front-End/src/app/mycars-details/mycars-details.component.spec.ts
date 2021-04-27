import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MycarsDetailsComponent } from './mycars-details.component';

describe('MycarsDetailsComponent', () => {
  let component: MycarsDetailsComponent;
  let fixture: ComponentFixture<MycarsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MycarsDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MycarsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
