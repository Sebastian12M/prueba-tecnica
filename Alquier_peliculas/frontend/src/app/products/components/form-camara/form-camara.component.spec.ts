import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCamaraComponent } from './form-camara.component';

describe('FormCamaraComponent', () => {
  let component: FormCamaraComponent;
  let fixture: ComponentFixture<FormCamaraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormCamaraComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormCamaraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
