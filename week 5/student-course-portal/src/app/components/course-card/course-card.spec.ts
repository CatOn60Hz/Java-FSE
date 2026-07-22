import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CourseCard } from './course-card';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCard, RouterTestingModule]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    component.course = { id: 1, name: 'Test', code: 'TC1', credits: 3, gradeStatus: 'pending' };
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
