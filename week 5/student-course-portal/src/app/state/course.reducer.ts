import { createReducer, on } from '@ngrx/store';
import { Course } from '../models/course.model';
import * as CourseActions from './course.actions';

export interface CourseState {
  courses: Course[];
  error: any;
  status: 'pending' | 'loading' | 'error' | 'success';
}

export const initialState: CourseState = {
  courses: [],
  error: null,
  status: 'pending'
};

export const courseReducer = createReducer(
  initialState,
  on(CourseActions.loadCourses, state => ({ ...state, status: 'loading' })),
  on(CourseActions.loadCoursesSuccess, (state, { courses }) => ({
    ...state,
    courses,
    error: null,
    status: 'success'
  })),
  on(CourseActions.loadCoursesFailure, (state, { error }) => ({
    ...state,
    error,
    status: 'error'
  }))
);
