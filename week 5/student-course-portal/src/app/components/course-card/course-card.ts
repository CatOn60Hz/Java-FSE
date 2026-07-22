import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { Course } from '../../models/course.model';
import { EnrollmentService } from '../../services/enrollment';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  constructor(private enrollmentService: EnrollmentService) {}

  get isEnrolled() {
    return this.course ? this.enrollmentService.isEnrolled(this.course.id) : false;
  }

  toggleEnrollment(event: Event) {
    event.stopPropagation();
    if (this.isEnrolled) {
      this.enrollmentService.unenroll(this.course.id);
    } else {
      this.enrollmentService.enroll(this.course.id);
      this.enrollRequested.emit(this.course.id);
    }
  }

  // Getters keep templates clean by keeping logic in the component
  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course?.credits >= 4,
      'expanded': this.isExpanded
    };
  }
  
  get borderStyle() {
    switch(this.course?.gradeStatus) {
      case 'passed': return 'green';
      case 'failed': return 'red';
      case 'pending': return 'grey';
      default: return 'transparent';
    }
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['course']) {
      console.log('Previous course value:', changes['course'].previousValue);
      console.log('Current course value:', changes['course'].currentValue);
    }
  }
}
