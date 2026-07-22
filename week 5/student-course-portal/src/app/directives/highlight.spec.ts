import { Highlight } from './highlight';
import { ElementRef } from '@angular/core';

describe('Highlight', () => {
  it('should create an instance', () => {
    const directive = new Highlight(new ElementRef(document.createElement('div')));
    expect(directive).toBeTruthy();
  });
});
