import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseList } from './course-list';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Course } from '../../models/course.model';

describe('CourseList', () => {
  let component: CourseList;
  let fixture: ComponentFixture<CourseList>;
  let store: MockStore;
  
  const mockCourses: Course[] = [
    { id: 1, name: 'Test Course 1', code: 'TC1', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'Test Course 2', code: 'TC2', credits: 4, gradeStatus: 'pending' }
  ];
  
  const initialState = {
    courses: {
      courses: mockCourses,
      error: null,
      status: 'success'
    }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseList, RouterTestingModule],
      providers: [provideMockStore({ initialState })]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CourseList);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render course cards', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    const cards = compiled.querySelectorAll('app-course-card');
    expect(cards.length).toBe(2);
  });
});
