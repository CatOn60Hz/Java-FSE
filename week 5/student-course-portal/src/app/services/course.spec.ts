import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return courses via API', async () => {
    const mockCourses: Course[] = [
      { id: 1, name: 'Test Course', code: 'TC1', credits: 3, gradeStatus: 'passed' }
    ];

    const coursesPromise = new Promise(resolve => {
      service.getCourses().subscribe(courses => {
        expect(courses.length).toBe(1);
        expect(courses).toEqual(mockCourses);
        resolve(true);
      });
    });

    const req = httpMock.expectOne('/assets/courses.json');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);

    await coursesPromise;
  });
});
