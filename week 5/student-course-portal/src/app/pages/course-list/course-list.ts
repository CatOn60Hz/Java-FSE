import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { CourseCard } from '../../components/course-card/course-card';
import { Highlight } from '../../directives/highlight';
import { Course } from '../../models/course.model';
import { Router, ActivatedRoute } from '@angular/router';
import { selectAllCourses, selectCourseLoading } from '../../state/course.selectors';
import { loadCourses } from '../../state/course.actions';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard, Highlight, FormsModule],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  courses$!: Observable<Course[]>;
  isLoading$!: Observable<boolean>;
  selectedCourseId: number | null = null;
  searchTerm = '';

  constructor(
    private store: Store,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.store.dispatch(loadCourses());
    this.courses$ = this.store.select(selectAllCourses);
    this.isLoading$ = this.store.select(selectCourseLoading);
    
    // Read query parameter
    const searchParam = this.route.snapshot.queryParamMap.get('search');
    if (searchParam) {
      this.searchTerm = searchParam;
    }
  }

  onSearch() {
    this.router.navigate(['/courses'], { queryParams: { search: this.searchTerm } });
  }

  viewCourseDetails(courseId: number) {
    this.router.navigate(['/courses', courseId]);
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}
