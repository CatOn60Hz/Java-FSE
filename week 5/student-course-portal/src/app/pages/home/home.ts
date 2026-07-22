import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course';
import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget';

@Component({
  selector: 'app-home',
  imports: [FormsModule, CourseSummaryWidget],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';
  availableCoursesCount = 0;
  newCourseName = '';

  constructor(private courseService: CourseService) {}

  ngOnInit() {
    this.courseService.getCourses().subscribe(courses => {
      this.availableCoursesCount = courses.length;
    });
  }

  refreshCount() {
    this.courseService.getCourses().subscribe(courses => {
      this.availableCoursesCount = courses.length;
    });
  }

  addCourse() {
    const newCourse: import('../../models/course.model').Course = {
      id: Math.floor(Math.random() * 1000),
      name: this.newCourseName,
      code: 'NEW',
      credits: 3,
      gradeStatus: 'pending'
    };
    this.courseService.addCourse(newCourse);
    this.newCourseName = '';
  }

  ngOnDestroy() {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }
}
