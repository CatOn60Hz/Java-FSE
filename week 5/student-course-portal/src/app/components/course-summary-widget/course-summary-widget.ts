import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-summary-widget',
  imports: [],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css'
})
export class CourseSummaryWidget implements OnInit {
  courseCount = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit() {
    this.courseService.getCourses().subscribe(courses => {
      this.courseCount = courses.length;
    });
  }

  addDummyCourse() {
    const dummy: Course = { id: Math.floor(Math.random() * 1000) + 10, name: 'Dummy Course', code: 'DC99', credits: 1, gradeStatus: 'pending' };
    this.courseService.addCourse(dummy);
  }
}
