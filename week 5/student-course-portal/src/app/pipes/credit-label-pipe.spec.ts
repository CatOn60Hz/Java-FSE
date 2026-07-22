import { CreditLabelPipe } from './credit-label-pipe';

describe('CreditLabelPipe', () => {
  it('create an instance', () => {
    const pipe = new CreditLabelPipe();
    expect(pipe).toBeTruthy();
  });

  it('should format 3 as 3 Credits', () => {
    const pipe = new CreditLabelPipe();
    expect(pipe.transform(3)).toBe('3 Credits');
  });

  it('should format 1 as 1 Credit', () => {
    const pipe = new CreditLabelPipe();
    expect(pipe.transform(1)).toBe('1 Credit');
  });
});
