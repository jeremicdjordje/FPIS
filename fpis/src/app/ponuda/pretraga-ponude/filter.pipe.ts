import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'kriterijum',
  pure: false
})
export class FilterPipe implements PipeTransform {

  transform(value: any, kriterijum: string, propName: string): any {
    if (value.length === 0 || kriterijum === '') {
      return value;
    }
    const filterNiz = [];
    for (const item of value) {
      if (item[propName] === kriterijum) {
        filterNiz.push(item);
      }
    }
    return filterNiz;
  }

}
